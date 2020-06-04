<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<h1>用户登录</h1>
<form action="login.action" method="post">
    <div>
        <label>用户名：</label>
        <input type="text" name="userID"/>
    </div>
    <div>
        <label>密码：</label>
        <input type="password" name="pwd"/>
    </div>
    <div>
        <input type="submit" value="登录">
    </div>
</form>
</body>
</html>
