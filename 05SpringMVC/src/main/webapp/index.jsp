<%@page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<title>Ajax</title>
<head>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#list").click(function () {
                $.ajax({
                    url:"/five",
                    type:"POST",
                    success:function (data) {
                        $.each(data,function (i,dom) {
                            alert(dom.name);
                            alert(dom.age);
                        });
                    }
                });
            });
        });
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"/map",
                    type:"POST",
                    success:function (datas) {
                        $.each(datas,function (i,dom) {
                            alert(datas[i].name)
                            alert(datas[i].age)
                        });
                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>${msg}</h1>
<h2>Hello SpringMVC!&nbsp;&nbsp;&nbsp;${uname}</h2>
<%--<img src="image/shanshui.jpg"/>--%>
<div id="list">
    <input type="button" value="ajax获取list类型"/>
</div>
<div id="btn">
    <input type="button" value="ajax获取map类型"/>
</div>
</body>
</html>
