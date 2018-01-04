<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>数据校验</h1>
<form action="/first" method="post">
    成绩：<input name="score"/><span>${scoremsg}</span><br/><br/>
    姓名：<input name="name"/><span>${namemsg}</span><br/><br/>
    电话：<input name="phone"/><span>${phonemsg}</span><br/><br/>
    出生日期：<input name="birthday"/><span>${birthday}</span>
    <input type="submit"/>
</form>
</body>
</html>
