
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        /*1.光标失去焦点*/
        /*var data={"name":"微冷的雨","age":20,"address":"河南安阳"};
         alert(data.name+"\r\n"+data.age+"\r\n"+data.address);*/

        /*var data=[{"name":"微冷的雨","age":20,"address":"北京上地"},
            {"name":"微热的翔","age":22,"address":"河南郑州"}];

        $.each(data,function (i,dom)  { //i;索引   dom 当前遍历到的对象
            alert(dom.name+"\r\n"+dom.age+"\r\n"+dom.address);
        });*/

        var userArray = [ {
            "id" : 2,
            "name" : "足球小子---张卫健",
            "pwd" : "123"
        }, {
            "id" : 3,
            "name" : "斯姆詹",
            "pwd" : "11111"
        }, {
            "id" : 4,
            "name" : "西梅",
            "pwd" : "6666"
        } ];
        var $table = $("<table border='1'></table>")
            .append("<tr><td>ID</td><td>用户名</td><td>密码</td></tr>");  //内存


        $(function () {

            /*$("#box").html($table);

            $.each(userArray,function (i,dom)  { //i;索引   dom 当前遍历到的对象
                $table.append("<tr><td>"+dom.id+"</td><td>"+dom.name+"</td><td>"+dom.pwd+"</td></tr>");
            });*/

          /*$.get()*/

           $("[name=uname]").blur(function () {
               //oldAjax();
               //newAjax();
              /*$.get('/FirstServlet',{"uname":$("[name=uname]").val()},function (data) {
                $("#msg").html(data);
                });*/
                //post请求
              /* $.post('/FirstServlet',{"uname":$("[name=uname]").val()},function (data) {
                   $("#msg").html(data);
               });*/
             //getJSON方法
               /*$.getJSON('/FirstServlet',{"uname":$("[name=uname]").val()},function (data) {
                   alert(typeof data);
                   $("#msg").html(data);
               });*/
              /* $("#msg").load('/FirstServlet',{"uname":$("[name=uname]").val()});*/
            //serialize方法
               //var data=$.param($("#form1").serializeArray());
             /* var data=$("#form1").serialize();
               alert(data)*/
            });
        });
        function newAjax() {
         $.ajax({
         url:"/FirstServlet",
         type:"POST",
         data:{"uname":$("[name=uname]").val()},
         async:true,
         success:function (data) {
         $("#msg").html(data);
         }
         });
         }
    </script>

    <script>
        function oldAjax() {
            //1.发送ajax请求
            var xhr=null;
            if(window.XMLHttpRequest){  //非IE浏览器（版本比较高的IE）
                xhr=new XMLHttpRequest();
            }else{
                //code execute here,说明是IE
                xhr=new ActiveXObject("Microsoft.XMLHTTP");
            }
            //01.能准备发送请求的   方式   目标地址    是否异步 true 异步
            xhr.open("post","/FirstServlet",true);
            xhr.onreadystatechange=function () {
                if(xhr.readyState==4 && xhr.status==200){  //认为请求已经成功发送，并且客户端浏览器已经成功获取到服务器响应的数据
                    //一个系统对象的属性，获取到响应回来的文本
                    var data=xhr.responseText;
                    // alert(data);
                    $("#msg").html(data);
                }
            };
            //5k的一句话，请求头中必须有Content-Type
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            xhr.send("uname="+$("[name=uname]").val());
        }
    </script>
</head>
<body>
  <form id="form1" name="form1">
      <input name="uname"/><span id="msg"></span>
      <input name="upwd" value="000000"/>
      <input name="uaddress" value="北京"/>
      <input name="uphone" value="15201069845"/>
      <div id="box">
      </div>
  </form>
</body>
</html>
