<%@ page import="cn.hibernate.day05opensessioninview.service.EmployeeService" %>
<%@ page import="cn.hibernate.day04mapping.manytomany.Employee" %>
<html>
<body>
<%
    EmployeeService service=new EmployeeService();
    Employee employee=(Employee)service.getData(Employee.class,51);
    out.println(employee);
%>
</html>