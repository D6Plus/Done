<%--
  Created by IntelliJ IDEA.
  User: JOKER   A
  Date: 2020/5/4
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>denglui</title>
</head>
<body>
    <h1>用户登录</h1>
    <form action="login1" method="post">
        <div>
             <label>用户名：</label>
            <inpput type="text" name="userID"></inpput>
        </div>
        <div>
            <label>密码：</label>
            <inpput type="text" name="pwd"></inpput>
        </div>
        <div>
            <input type="submit" value="登录">
        </div>
    </form>
</body>
</html>
