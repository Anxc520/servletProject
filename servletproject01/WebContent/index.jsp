<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>欢迎</title>
</head>
<body align="center">
<h1>登陆页面</h1>
<form action="login" method="post">
<table style="margin:0 auto;width:500px;height:300px;font-size:15">
	<tr>
		<td>姓名：</td><td><input type="text" name="username"></td>
	</tr>
	
	<tr>
		<td>学号：</td><td><input type="text" name="number"></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="登陆">&nbsp;&nbsp;
		<input type="button" onclick="func()" value="注册">
		<br>
		</td>
	</tr>
</table>
</form>
<script>
function func(){window.location.href='register.jsp';}
window.onload=function(){
	var flag = <%=(String) request.getAttribute("flag") %>;
	if(flag =="0"){
		alert("登陆错误！");
		flag="1";
	}
}
</script>
</body>
</html>