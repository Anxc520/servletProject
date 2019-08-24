<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="cn.anxcyun.www.po.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面</title>
</head>
<body align="center">
<h1>用户信息展示如下：</h1>
<form action="updateUser" method="post" >
<table style="border:2px solid #FFF;border-color:#F0F0F0;background:#00F0F0;font-size:25px;color:#F0F0F0;width:700px;height:400px" align="center">
<tr style="border:2px solid #FFF" hidden>
	<th>用户名</th><td><input type="text" name="name" value="${user.u_name}"></td>
</tr>
<tr>
	<th>班级</th><td><input type="text" name="classes" value="${user.u_classes}"></td>
</tr>
<tr>
	<th>学号</th><td><input type="text" name="number" value="${user.u_number}"></td>
</tr>
<tr>
	<th>性别</th><td><input type="text" name="sex" value="${user.u_sex}"></td>
</tr>
<tr>
	<th>电话</th><td><input type="text" name="tel" value="${user.u_tel}"></td>
<tr>
<td colspan="2"><input type="submit" value="提交"></td>
</tr>               
</table>
</form>
</body>
</html>