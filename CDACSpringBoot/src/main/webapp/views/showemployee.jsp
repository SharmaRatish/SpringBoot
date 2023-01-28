<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>City</th>
<th>Post</th>
<th>Salary</th>
</tr>

<%
Iterable<Employee> data=(Iterable)request.getAttribute("list");
for(Employee e :data)
{%>
<tr>
<td><%=e.getID%></td>
<td><%=e.getName%></td>
<td><%=e.getAge%></td>
<td><%=e.getCity%></td>
<td><%=e.getPost%></td>
<td><%=e.getSalary%></td>
</tr>
<%} %>

</table>
</body>
</html>