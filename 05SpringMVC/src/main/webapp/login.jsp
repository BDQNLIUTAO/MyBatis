<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/30
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login3" method="post">
userName：<input name="name" type="text"/><br/>
Favorite books1：<input name="book.bookname" type="text"/><br/>
Favorite books2：<input name="books[1].bookname" type="text"/>
<input type="submit"/>
</form>
</body>
</html>
