<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/3
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/firstExceptionSelf" method="post">
    用户名：<input name="name"/><br/>
    密码：<input name="age"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
