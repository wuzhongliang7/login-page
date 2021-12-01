package com.bjpn.javaweb.dao;

import com.bjpn.javaweb.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public boolean isVerify(String loginName, String loginPwd) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean verify = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from t_user where loginName=? and loginPwd=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginName);
            ps.setString(2, loginPwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                verify = true;
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.close(conn, ps, rs);
        }
        return verify;

    }
}
