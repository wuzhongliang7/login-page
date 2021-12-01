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
<script type="text/javascript">

    quit = function () {
        window.location.href = "<%=request.getContextPath()%>/login?type=logout"
    }

</script>
<body>

<%
    String loginName = (String) session.getAttribute("loginName");

    if (session == null || loginName == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
    }
%>

当前登陆用户:<%=session.getAttribute("loginName")%>&nbsp;
<input type="button" name="quit" id="quit" value="退出" onclick="quit()"/>
<h1 align="center">欢迎进入系统!!</h1>
</body>
</html>
