package com.bjpn.javaweb.bean;

import java.util.Objects;

public class Account {
    private  String id;
    private  String loginName;
    private  String loginPwd;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(loginName, account.loginName) &&
                Objects.equals(loginPwd, account.loginPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginName, loginPwd);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Account() {
    }

    public Account(String id, String loginName, String loginPwd) {
        this.id = id;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }
}
