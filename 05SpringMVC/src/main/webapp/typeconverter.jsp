<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/4
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>类型转换</h1>
<form action="${pageContext.request.contextPath}/first" method="post">
    出生日期：<input name="birthday"value="${birthday}"/>
    年龄：<input name="age" value="${age}"/>
    <input type="submit"/>
</form>
</body>
</html>
