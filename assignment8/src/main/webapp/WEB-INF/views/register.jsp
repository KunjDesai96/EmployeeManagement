<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Page</h1>
	<div>
		<form action="/register" method="post">
			<table>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName" />
					<div></div>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" />
				</tr>
				<tr>
					<td><input type="submit" /></td>
					<td><a href="/auth/login.html">Login Page</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>