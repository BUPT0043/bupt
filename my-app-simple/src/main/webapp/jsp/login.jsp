<%@ page import="com.mygudou.app.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>条款种类选择界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=big5">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../js/tableExport.js"></script>
	<script src="../js/stickup.min.js"></script>
	 <link href="../css/flat-ui.css" rel="stylesheet">
	<style type="text/css">

	 .breadcrumb{
                margin-top: 0px;
                margin-bottom:0px;
           
                }
                .jumbotron{
                margin-top: 0px;
                margin-bottom:5px;
                }
                .navbar navbar-default{
                margin:0px;
                
                }
				.login-edit{
				   width:1030px;
			       margin:0 auto;
			       
			      
				}
				.menu-edit{
				   width:1030px;
			       margin:0 auto;
			       background-color:white;
				
				}
				.active1{
                float:right;
                }
				.row demo-tiles{
				
				width:250px;
				margin:0 auto;
				}
				.row{
				margin-left:0px;
				margin-right:0px;
				margin-up:5px;
				}
				.row demo-tiles{
				width:1030px;
				padding:20px;
				}
				
				.jumbotron{
				margin-bottom:0px;
				}
				.alert{
				margin-bottom:0px;
				background-color:white;
				}
	</style>

	</head>
	<body class="login-edit" background="../images/1.jpg";>
	 <!--A区  -->
		<ul class="breadcrumb">
			<li>
				<a href="firstshow">
				<span class="glyphicon glyphicon-home" style="color: rgb(54, 140, 167); font-size: 16px;"> Home</span></a> <span class="divider"></span>
			</li>
			<li class="active1">
				<a href="#"><span class="glyphicon glyphicon-question-sign" style="color: rgb(54, 140, 167); font-size: 17px;"> Help</span></a> <span class="divider"></span>
			</li>
			<li class="active1"><span class="glyphicon glyphicon-phone-alt" style="color: rgb(64, 114, 145); font-size:16px;"> Phone:010-12345678</span></li>
		</ul>
	 <!--幕区  -->
      <div class="jumbotron">
        <h1>条款类型</h1>
       
		<strong>提示：</strong> 请选择相关合同条款类型，如涉及钱款，请注意保护相关安全
       </div> 
       
       <div class="alert alert-info" role="alert">
      </div>
	 
	<div class="menu-edit">
		 
	     <div class="row demo-tiles">
	      <c:forEach items="${law}" var="law">
	        <div class="col-md-4">
	          <div class="tile">
	            <h3 class="tile-title">${law.name}</h3>
	            <p>${law.name}相关合同生成</p>
	            <a class="btn btn-primary btn-large btn-block" href="<%=basePath%>/show/main?lawid=${law.id}">进入</a>
	          </div>
           </div>  
          </c:forEach> 
	   </div>
	</div>
	</body>
</body>
</html>
 	
			

