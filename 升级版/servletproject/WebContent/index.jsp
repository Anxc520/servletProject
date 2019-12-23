<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
		<div class="login-form">
			<h1>用户信息管理系统</h1>
					<div class="head">
						<img src="images/user.png" alt=""/>
					</div>
				<form action="login" method="post" >
						<input type="text" class="text" value="用户名" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" >
						<input type="password" value="密码****" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密码****';}">
						<div class="submit">
							<input type="submit"  value="登陆" >
					</div>	
					<p><a href="#" onclick="func()">注册</a></p>
				</form>
			</div>
		</div>
	</div>
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