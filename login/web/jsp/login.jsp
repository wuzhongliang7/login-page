<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <link href="<%=request.getContextPath()%>/css/admin_login.css" rel="stylesheet" type="text/css"/>

    <%--点击刷新验证码--%>
    <%--    <script type="text/javascript">
            function changeImg() {
                var img = document.getElementById("img");
                img.src = "<%=request.getContextPath()%>/authImage?date=" + new Date();
            }
        </script>--%>
</head>
<body>

<div class="admin_login_wrap">
    <h1>用户登陆</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form id="form_for_login" action="<%=request.getContextPath()%>/login" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="username">用户名：</label>
                        <input type="text" name="username" id="username" size="35" class="admin_input_style"/>
                    </li>
                    <li>
                        <label for="password">密码：</label>
                        <input type="password" name="password" id="password" size="35" class="admin_input_style"/>
                    </li>
<%--                    <li>
                        <label for="checkcode">验证码:</label>
                        <input type="text" name="checkcode" id="checkcode" size="18" class="admin_input_style"/>
                        <img id="img" src="<%=request.getContextPath()%>/authImage" onclick="changeImg()"
                             style="position:relative;top: 10px"/>
                    </li>
                    <li>
                        <input type="checkbox" name="ten" id="ten" value="1"/>10天免登录
                    </li>--%>
                    <li>
                        <input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录" class="btn btn-primary"
                               id="btn-submit"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>

