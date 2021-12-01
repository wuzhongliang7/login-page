<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆成功页面</title>
    <script type="text/javascript">
        window.alert("登陆成功!")
        window.location.href = "<%=request.getContextPath()%>/jsp/index.jsp"
    </script>
</head>
<body>
</body>
</html>