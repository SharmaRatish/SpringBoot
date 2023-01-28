<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"><title>Insert title here</title>
</head>
<body>
<h1 align="center">User Form</h1>
<fieldset>
<form action ="userdata" method="post">
<pre>
<div class="jambotron">
<div class="container" bg-dark>
<label>name</label>
name   :<input type="text" name="name">
</div>

Age    :<input type="number" name="age"><br><br>

Course :<input type="text" name="course"><br><br>

Address:<input type="text" name="address"><br><br>

        <input type="submit" value="submit"><br><br>

</pre>
</form>

</fieldset>
</body>
</html>