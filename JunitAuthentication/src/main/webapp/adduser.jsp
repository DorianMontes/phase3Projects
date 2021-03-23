<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
</head>
<body>
<h2>New User Registration</h2>
<form id="AddUser" action="AddUser" method="post">
    <label>Name: </label>
    <input type="text" name="name">
    <br/>
    <label>Password: </label>
    <input type="text" name="password">
    <br/>
    <button>Submit</button>
</form>

</body>
</html>