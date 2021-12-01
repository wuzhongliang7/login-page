<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆失败页面</title>
    <script type="text/javascript">
        window.alert("登陆失败,请重新输入!")
        window.location.href = "<%=request.getContextPath()%>/jsp/login.jsp"
    </script>
</head>
<body>
</body>
</html>
