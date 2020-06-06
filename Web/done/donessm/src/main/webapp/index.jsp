<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>111</title>
</head>


<body>
<h2>Hello World!</h2>

<form action="/User/login1" method="post">
    <input type="text" name="userID">
    <input type="password" name="pwd">
    <input type="submit">
</form>

<form action="/User/queryUserByID">
    <input type="text" name="UserID">
    <input type="submit">
</form>
<h2><a href="/User/queryAllUser">点---abc---击</a></h2>

<% String name = (String) request.getSession().getAttribute("user"); %>
this is <%=name%>
</body>
</html>ID