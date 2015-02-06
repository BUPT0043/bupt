<%@ page import="com.mygudou.app.Model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./head.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎进入合同Maker！</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="../js/jquery.base64.js"></script>
<script src="../js/base64.js"></script>
<script src="../js/sprintf.js"></script>
<script src="../js/jspdf.js"></script>
<link href="../css/main.css" rel="stylesheet">
<style type="text/css">
.btn-group, .btn-group-vertical {
	margin-left: 402px;
}

.form-horizontal .form-group {
	margin-right: -240px;
	margin-left: 240px;
}

.tile p {
	font-size: 20px;
	margin-bottom: 3px;
	margin-left: 420px;
}

.register {
	margin-left: 520px;
}

.tile-title {
	font-size: 45px;
	margin-left: 420px;
	margin-top: 100px;
}
.navbar-form{
margin-left: 411px;
}

.background1 {
	margin-top: 80px;
}
</style>
<!-- 编辑栏置顶 -->

</head>

<body class="Context" id="body1" background="../images/note.jpg">
	<div class="tile">
		<h3 class="tile-title">合同Maker</h3>
		<p>用最简单的方式生成合同</p>
	</div>
	<div class="background1">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-sm-2 control-label"><span
					class="glyphicon glyphicon-user"
					style="color: rgb(0, 100, 75); font-size: 15px;"><strong>
							Role</strong></span></label>
				<div class="col-sm-3">
					<select id="focusedInput" class="form-control">
						<option>律师</option>
						<option>用户</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span
					class="glyphicon glyphicon-log-in"
					style="color: rgb(0, 100, 75); font-size: 15px;"><strong>
							Login</strong></span></label>
				<div class="col-sm-3">
					<input class="form-control" id="focusedInput" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"><span
					class="glyphicon glyphicon-lock"
					style="color: rgb(0, 100, 75); font-size: 15px;"><strong>
							Password</strong></span></label>
				<div class="col-sm-3">
					<input class="form-control" id="focusedInput" type="text">
				</div>
			</div>
		</form>
		<p class="register">
			<a href="<%=basePath%>/show/register">注册</a>
		</p>
		<form class="navbar-form navbar-left" method="post"
			action="<%=basePath%>/show/search" role="search">
			<input type="hidden" name="title" value="${title}"
				class="btn btn-default"> <a href="<%=basePath%>/show/userLogin"
				class="btn btn-default">登录</a>
			<input type="hidden" name="title" value="${title}"
				class="form-control"> <a href="<%=basePath%>/show/login"
				class="btn btn-default">生成合同</a>
			<button type="submit" class="btn btn-default">案例查询</button>
		</form>
	</div>
</body>
</html>



