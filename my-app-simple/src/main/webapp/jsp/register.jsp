<%@ page import="com.mygudou.app.Model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="../css/main.css" rel="stylesheet">
<style type="text/css">
.background1 {
	background-color: white;
	width: 960px;
	height: 643px;
	margin-left: auto;
	margin-right: auto;
	margin-left: auto;
}

.tile-image {
	
}

.col-sm-3 {
	width: 50%;
}

.btn-group>.btn:first-child {
	margin-left: 410px;
}

.form-horizontal .form-group {
	margin-left: 225px;
	margin-right: -65px;
	margin-top: 3px;
}

.navbar-form {
	margin-left: 485px;
	font-size: 20px;
}

.form-control {
	width: 70%;
}

.breadcrumb {
	margin-bottom: 3px;
}

#fname {
	font-weight: normal;
	font-size: 13px;
	margin-left: 148px;
}
</style>
</head>
<body class="Context" id="body1" background="../images/1.jpg">
	<div class="background1">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>/show/index"> <span
					class="glyphicon glyphicon-home"
					style="color: rgb(54, 140, 167); font-size: 16px;"> Home</span></a> <span
				class="divider"></span></li>
			<li class="active1"><a href="#"><span
					class="glyphicon glyphicon-question-sign"
					style="color: rgb(54, 140, 167); font-size: 17px;"> Help</span></a> <span
				class="divider"></span></li>
			<li class="active1"><span class="glyphicon glyphicon-phone-alt"
				style="color: rgb(64, 114, 145); font-size: 16px;">
					Phone:010-12345678</span></li>
		</ul>
		<div class="form1">
			<form class="form-horizontal" role="userLogin" method="post"
				action="<%=basePath%>/show/userLogin">
					<div class="form-group">
					<label class="col-sm-2 control-label"> 注册角色： </label>
					<div class="radio">
					<label> <input type="radio" name="optionsRadios"
						id="optionsRadios1" value="option1" checked> 律师
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="optionsRadios"
						id="optionsRadios2" value="option2"> 用户
					</label>
				</div>
				</div> 
				
				<div class="form-group">
					<label class="col-sm-2 control-label">用户名：</label>
					<div class="col-sm-3">
						<input class="form-control" id="focusedInput" type="text"
							name="userid">
					</div>
					<label class="control-label" id="fname">请输入6-8位用户名，含字母，数字，下划线</label>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">密码：</label>
					<div class="col-sm-3">
						<input class="form-control" id="focusedInput" type="text"
							name="pwd">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">再次确认密码：</label>
					<div class="col-sm-3">
						<input class="form-control" id="focusedInput" type="text">
					</div>
				</div>
				<!--<div class="form-group">
			 		<label class="col-sm-2 control-label"> 性别： </label>
					<div class="col-sm-3">
						<select id="focusedInput" class="form-control" name="userrole">
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</div>
				</div> -->
				<div class="form-group">
					<label class="col-sm-2 control-label">性别：</label>
					<div class="col-sm-3">
						<input class="form-control" id="focusedInput" type="text"
							name="sex">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">邮箱：</label>
					<div class="col-sm-3">
						<input class="form-control" id="focusedInput" type="text"
							name="email">
					</div>
				</div>
				<div class="btn-group btn-group-lg">
					<button type="submit" class="btn btn-lg btn-success">确认</button>
					<button type="button" class="btn btn-lg btn-success">取消</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>


