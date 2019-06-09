<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>登录</title>
</head>
<body>
	<form action="/login" method="post">
		<p><label>用户名：</label><input type="text" name="username" /></p>
		<p><label>密&emsp;码：</label><input type="password" name="password" /></p>
		<p><input type="submit" value="登录"/></p>
	</form>
</body>
</html>