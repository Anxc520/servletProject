<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="cn.anxcyun.www.po.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body align="center">
<h1>hello World!</h1>
<select id="select">
<option value="0">模糊查询</option>
<option value="1">精准查询</option>
</select>&nbsp;&nbsp;
<select id="select1">
<option value="u_username">用户名</option>
<option value="u_class">班级</option>
<option value="u_number">学号</option>
<option value="u_sex">性别</option>
<option value="u_tel">电话</option>
</select>&nbsp;&nbsp;
<input type="text" id="select2" >&nbsp;&nbsp;
<input type="button" value="查询" onclick="check()" />&nbsp;&nbsp;
<input type="button" value="添加" onclick="add()">
</br>

<table style="border:2px solid #FFF;border-color:#F0F0F0;background:#00F0F0;font-size:25px;color:#F0F0F0;width:700px;" align="center">
<tr style="border:2px solid #FFF">
	<th>用户名</th><th>班级</th><th>学号</th><th>性别</th><th>电话</th><th>操作</th>
</tr>
<c:forEach var="user" items="${list}">
<tr>
         <td>${user.u_name}</td><td>${user.u_classes}</td><td>${user.u_number}</td><td>${user.u_sex}</td><td>${user.u_tel}</td>
         <td><input type="button" value="修改"  onclick="updateUser('${user.u_name}')" /><input type="button" onclick="deleteUser('${user.u_name}')" value="删除"></td>
</tr>
</c:forEach>            
</table>
<script>
function updateUser(u_name){
	window.location.href="update?name="+u_name;
}
function deleteUser(u_name){
	window.location.href="deleteUser?name="+u_name;
}
function check(){
	var select = document.getElementById("select");//查询方式
	var select1 = document.getElementById("select1");//查询列名称
	var textvalue = document.getElementById("select2").value;//查找的内容
	
	var index = select.selectedIndex;
	var selectvalue = select.options[index].value;
	
	var index1 = select1.selectedIndex;
	var selectvalue1 = select1.options[index1].value;
	
	/*selectvalue =0模糊查询  =1精准查询  */
	if(selectvalue=="0"){
		textvalue=" "+" where "+selectvalue1+" LIKE '%"+textvalue+"%'";
		//window.location.href="select?name="+u_name;
	}else{
		textvalue=" "+" where "+selectvalue1+"= '"+textvalue+"'";
	}
	//alert("select * from user"+textvalue);
	
	window.location.href=encodeURI("select?sql="+textvalue);
}
function add(){window.location.href='addUser.jsp';}
/* select * from user where u_username LIKE '%1%';
select * from user where u_username=2;  
select?sql=%20%20where%20u_sex%20LIKE%20%27%1%%27
select?sql=%20%20where%20u_sex=1*/
</script>
</body>
</html>