<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="com.test.www.po.User" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <title>用户信息</title>

    <link href="dist/css/style.css" rel="stylesheet">

</head>

<body class="skin-default-dark fixed-layout">
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">Elegant admin</p>
        </div>
    </div>
    <div id="main-wrapper">
       
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-dark">
               
                <div class="navbar-header">
                    <a class="navbar-brand" href="javascript:void(0)">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                            <!-- Light Logo icon -->
                            <img src="assets/images/logo-light-icon.png" alt="homepage" class="light-logo" />
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text --><span>
                         <!-- dark Logo text -->
                         <img src="assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                         <!-- Light Logo text -->    
                         <img src="assets/images/logo-light-text.png" class="light-logo" alt="homepage" /></span> </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto">
                    &nbsp;
                    <select class="custom-select b-0" style="width" id="select">
										<option value="0">模糊查询</option>
										<option value="1">精准查询</option>
										</select>
										&nbsp;
										<select class="custom-select b-0" id="select1">
										<option value="u_username">用户名</option>
										<option value="u_class">班级</option>
										<option value="u_number">学号</option>
										<option value="u_sex">性别</option>
										<option value="u_tel">电话</option>
										</select>
										&nbsp;&nbsp;&nbsp;
										<input type="text" class="form-control form-control-line" id="select2" >
										<input type="button" class="btn btn-success d-none d-lg-block m-l-15" value=" 查  询      " onclick="check()" />
										&nbsp;&nbsp;&nbsp;
										 <input class="btn btn-success d-none d-lg-block m-l-15" type="button" value="添  加" onclick="add()">
 
                        <!-- This is  -->
                        <li class="nav-item hidden-sm-up"> <a class="nav-link nav-toggler waves-effect waves-light" href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item search-box"> <a class="nav-link waves-effect waves-dark" href="javascript:void(0)"><i class="fa fa-search"></i></a>


                        
										
                             
                            
			
                        </li>
                    </ul>
                    <ul class="navbar-nav my-lg-0">
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a href="index.jsp" ><img src="assets/images/users/1.jpg" alt="user" class="img-circle" width="30"></a>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
       
        <div>
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h4 class="text-themecolor">用户信息表</h4>
                       
                    </div>
                   
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">用户信息一览表</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>用户名</th><th>班级</th><th>学号</th><th>性别</th><th>电话</th><th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
										<c:forEach var="user" items="${list}">
										<tr>
												 <td>${user.u_username}</td>
												 <td>${user.u_classes}</td>
												 <td>${user.u_number}</td>
												 <td>${user.u_sex}</td>
												 <td>${user.u_tel}</td>
												
												
												<td>
												<c:if test="${admin.u_authority == 2}">
												<span class="label label-info" onclick="deleteUser('${user.id}')">删除</span>
												<span class="label label-danger" onclick="updateUser('${user.id}')">修改</span>
												</c:if>
												
												
												<c:if test="${admin.u_authority ==1 && admin.id == user.id }">
												<span class="label label-danger" onclick="updateUser('${user.id}')">修改</span>
												</c:if>
												</td>
												

										</tr>
										</c:forEach>  
                                          
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="assets/node_modules/jquery/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/node_modules/popper/popper.min.js"></script>
    <script src="assets/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="dist/js/perfect-scrollbar.jquery.min.js"></script>
    <!--Wave Effects -->
    <script src="dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="dist/js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="assets/node_modules/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <script src="assets/node_modules/sparkline/jquery.sparkline.min.js"></script>
    <!--Custom JavaScript -->
    <script src="dist/js/custom.min.js"></script>
	<script>
function updateUser(id){
	window.location.href="update?id="+id+"&auth="+${admin.id};
}
function deleteUser(id){
	window.location.href="deleteUser?id="+id+"&auth="+${admin.id};
}
function check(){
	var select = document.getElementById("select");//查询方式
	var select1 = document.getElementById("select1");//查询列名称
	var textvalue = document.getElementById("select2").value;//查找的内容
	
	var index = select.selectedIndex;
	var selectvalue = select.options[index].value;
	
	var index1 = select1.selectedIndex;
	var selectvalue1 = select1.options[index1].value;
	

	if(selectvalue=="0"){
		textvalue=" "+" where "+selectvalue1+" LIKE '%"+textvalue+"%'";
	
	}else{
		textvalue=" "+" where "+selectvalue1+"= '"+textvalue+"'";
	}
	
	window.location.href=encodeURI("select?sql="+textvalue+"&auth=" + ${ admin.id});
}
function add(){
	window.location.href='addUser.jsp'+"?auth=" + ${ admin.id }; 
	}
</script>
</body>

</html>