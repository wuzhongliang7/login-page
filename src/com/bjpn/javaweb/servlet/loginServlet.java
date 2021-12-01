package com.bjpn.javaweb.servlet;

import com.bjpn.javaweb.dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        //提取请求中的数据
        String loginName = request.getParameter("username");
        String loginPwd = request.getParameter("password");
        String checkCode = request.getParameter("checkcode");
        //转换为小写字母
        checkCode = checkCode.toLowerCase();

        //提取会话域中的验证码
        String verCode = (String) session.getAttribute("verCode");
        //验证输入验证码
        boolean checkCodeOK = checkCode.equals(verCode);

        //验证账号密码
        AccountDao accountDao = new AccountDao();
        boolean verify = accountDao.isVerify(loginName, loginPwd);

        //验证成功 跳转到系统页
        if (verify && checkCodeOK) {

            session.setAttribute("loginName", loginName);

            response.sendRedirect(request.getContextPath() + "/jsp/loginsucceed.jsp");

        } else {
            //验证失败 重新登陆
            response.sendRedirect(request.getContextPath() + "/jsp/loginfail.jsp");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        if (type != null) {
            if (type.equals("logout")) {
                //清除cookie专用
/*
        Cookie[] cookies = request.getCookies();


       for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginName")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            } else if (cookie.getName().equals("loginpwd")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }*/
                request.getSession().removeAttribute("loginName");
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }
    }
}
