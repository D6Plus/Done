<%--
  Created by IntelliJ IDEA.
  User: JOKER   A
  Date: 2020/6/5
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String name = (String) request.getSession().getAttribute("user"); %>
this is <%=name%>
</body>
</html>
