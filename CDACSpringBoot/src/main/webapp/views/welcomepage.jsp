<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome in my first jsp page</h1>
	<form action="searchemployee" method="post">
	`		<input type="text" name="id" placeholder="Enter useer id">
			<input type="submit" value="Search">
	</form>
<a href="userform">User Form</a><br><br>
<a href="home">home</a><br><br/>
<a href="contactus">contact us</a><br><br>
<a href="userdata?user=sir">go to user sir</a><br><br>
<a href="home">path variable</a><br><br>
<a href="getemployee">Show All Employee</a><br><br>
<a href="empform">Add Employee</a><br><br>
</body>
</html>