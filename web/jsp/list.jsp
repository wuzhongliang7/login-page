<%@ page import="com.bjpn.javaweb.bean.Account" %><%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2021/12/1
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统页面</title>
</head>
<body>

<%
    Account account = (Account) session.getAttribute("account");

    if (session == null || account == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    }
%>

<h1>欢迎进入系统!!</h1>
</body>
</html>
