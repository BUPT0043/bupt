<%@ page import="com.mygudou.app.model.*"%>
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
<title>相关事件查询搜索</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="../js/tableExport.js"></script>
<script src="../js/stickup.min.js"></script>
<link href="../css/flat-ui.css" rel="stylesheet">
<style type="text/css">
.breadcrumb {
	margin-top: 0px;
	margin-bottom: 0px;
	width: 1030px;
	height: 46px;
}

.jumbotron {
	margin-top: 3px;
	margin-bottom: 5px;
}

.navbar navbar-default {
	margin: 0px;
}

.login-edit {
	width: 1030px;
	margin: 0 auto;
}

.menu-edit {
	width: 1030px;
	margin: 0 auto;
	background-color: white;
}

.active1 {
	float: right;
}

.row demo-tiles {
	width: 250px;
	margin: 0 auto;
}

.jumbotron {
	margin-bottom: 0px;
}

#lalainput {
	width: 450px;
}

.backdown {
	margin-left: 65px;
	margin-right: 65px;
}

.backgd {
	margin-top: 3px;
	font-size: 14px;
}

p {
	margin-top: 3px;
	font-size: 14px;
}
</style>

</head>
<body class="login-edit" background="../images/1.jpg";>
	<!--A区  -->
	<ul class="breadcrumb">
		<li><a href="<%=basePath%>/show/firstshow"> <span
				class="glyphicon glyphicon-home"
				style="color: rgb(54, 140, 167); font-size: 16px;"> Home</span></a> <span
			class="divider"></span></li>
		<!-- <li >
				<a href="/show/search"><span class="glyphicon glyphicon-repeat" style="color: rgb(54, 140, 167); font-size: 17px;"> Back</span></a> <span class="divider"></span>
			</li> -->
		<li class="active1"><a href="#"><span
				class="glyphicon glyphicon-question-sign"
				style="color: rgb(54, 140, 167); font-size: 17px;"> Help</span></a> <span
			class="divider"></span></li>
		<li class="active1"><span class="glyphicon glyphicon-phone-alt"
			style="color: rgb(64, 114, 145); font-size: 16px;">
				Phone:010-12345678</span></li>
	</ul>
	<!--幕区  -->
	<div class="jumbotron">
		<h1>法律事件咨询</h1>
		<strong>提示：</strong> 请选择相关合同条款类型，如涉及钱款，请注意保护相关安全
	</div>
	<div class=backgd
		style="width: 1030px; height: 1000px; background-color: white;">
		<div>
			<div class=backdown
				style="width: 900px; height: 850px; background-color: white;">
				<p>
					<c:forEach items="${matter }" var="m">
						<c:out value="${m.content }"></c:out>
						<%-- <a href="#" class="list-group-item">${m.content }</a> --%>
					</c:forEach>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
