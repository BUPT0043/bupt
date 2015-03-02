<%@ page import="com.mygudou.app.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="./head.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
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

a.list-group-item {
	margin-left: auto;
	margin-right: auto;
	margin-top: 13px;
	width: 750px;
	height: 50px;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
}

.backgd {
	margin-top: 3px;
}

.navbar-default {
	margin-top: 3px;
	margin-bottom: 3px;
}

#zm_page {
	float: right;
}
</style>


</head>
<body class="login-edit" background="../images/1.jpg";>
	<!--A区  -->
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
	<!--幕区  -->
	<div class="jumbotron">
		<h1>法律案例</h1>

		<strong>提示：</strong> 请选择相关合同条款类型，如涉及钱款，请注意保护相关安全
	</div>

	<div class=backgd
		style="width: 1030px; height: 1000px; background-color: white;">
		<div class=backup
			style="width: 1030px; height: 70px; background-color: white;">
			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand">相关案例：</a>
			</div>
			<div>
				<form class="navbar-form navbar-left" method="post"
					action="<%=basePath%>/lawcase/search" role="search">
					<div class="form-group">
						<input type="text" name="title" value="${title}"
							class="form-control" id="lalainput" placeholder="请输入查询关键字">
					</div>
					<button type="submit" class="btn btn-default">提交</button>
				</form>
			</div>
			</nav>
		</div>

		<input type="hidden" id="total" value="${total }" />
		<div class=backdown
			style="width: 900px; height: 50px; background-color: white;">
			<p id="pagecontent">
				<c:forEach items="${matter }" var="m">
					<a href="<%=basePath%>/show/searchresult?id=${m.id}"
						class="list-group-item"> <c:out value="${m.title}"></c:out>
					</a>
				</c:forEach>
			</p>
			<div id="zm_page">
				<c:forEach begin="0" end="${total }" var="p">
					<a href="javascript:void(0)" p="${p}" curr="0" title="${title }"
						onclick="toPage(this)"> <c:out value="${p+1}"></c:out>
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<script type="text/javascript">
       		function toPage(obj){
       			var p = $(obj).attr("p");
       			var curr = $(obj).attr("curr");
       			var title = $(obj).attr("title");
       			var total = $("#total").val();
       			$.ajax({
       				url:'<%=basePath%>/show/searchajax',
       				data:{"p":p,
       					"curr":curr,
       					"title":title
       					},
       				dataType:"json",
       				type:"post",
       				success:function(data){
       					console.info(data);
       					//pagecontent
       					
       					var listHtml = '';
       					$.each(data,function(index,obj){
       						console.info(obj);
       						listHtml+='<a href="<%=basePath%>
		/show/searchresult?id='
														+ obj['id']
														+ '" class="list-group-item" >'
														+ obj['title'] + '</a>';
											});

							$("#pagecontent").html(listHtml);
							//zm_page

						},
						error : function(xmlHttpRequest, status, errorThrown) {
							console.info(errorThrown);
						}

					});

		}
	</script>
</body>
</html>



