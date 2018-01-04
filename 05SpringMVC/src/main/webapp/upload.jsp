<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/7
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传</h1>
<form action="/first" method="post" enctype="multipart/form-data">
    文件1   <input type="file" name="upload"/>
    <%--文件2   <input type="file" name="upload"/>
    文件3   <input type="file" name="upload"/>--%>
    <input type="submit"/>
</form>
</body>
</html>
