<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加</title>
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body align="center">
<h1>添加用户页面</h1>
<form action="addUser" method="post">
<table style="margin:0 auto;width:500px;height:300px;">
	<tr>
		<td>用户名：</td><td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>密码：</td><td><input type="text" name="password"></td>
	</tr>
	<tr>
		<td>班级：</td><td><input type="text" name="class"></td>
	</tr>
	<tr>
		<td>学号：</td><td><input type="text" name="number"></td>
	</tr>
	<tr>
		<td>性别：</td><td><input type="text" name="sex"></td>
	</tr>
	<tr>
		<td>电话号码：</td><td><input type="text" name="tel"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="提交">
		<input type="reset" value="重置">
		</td>
	</tr>
<input type="hidden" name="auth" value="${ admin.id}" />
</table>
</form>
</body>
</html>