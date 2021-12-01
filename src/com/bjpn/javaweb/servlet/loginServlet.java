package com.bjpn.javaweb.servlet;

import com.bjpn.javaweb.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String loginNname = request.getParameter("username");
        String loginPwd = request.getParameter("password");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean verify = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from t_user where loginName=? and loginPwd=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginNname);
            ps.setString(2, loginPwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                verify = true;
/*                Account account = new Account();
                account.setLoginName(rs.getString("loginNname"));
                account.setLoginPwd(rs.getString("loginPwd"));*/

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.close(conn, ps, rs);
        }
        if (verify) {
            //验证成功 跳转到系统页
            response.sendRedirect(request.getContextPath() + "/jsp/loginsucceed.jsp");

        } else {
            //验证失败 重新登陆
            response.sendRedirect(request.getContextPath() + "/jsp/loginfail.jsp");

        }


    }
}
