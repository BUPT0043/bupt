<%@ page import="com.mygudou.app.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta charset="utf-8">
<title>Error!</title>
<meta http-equiv="Content-Type" content="text/html; charset=big5">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- Loading Flat UI -->

<style>
.container {
	width: 960px;
	margin: 0 auto;
}
</style>

</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				<span class="glyphicon glyphicon-wrench"
					style="color: rgb(49, 161, 157); font-size: 25px;"> 网络出错了……！</span>
			</h1>
		</div>
		<p class="lead">
			可能由于您的网络原因导致界面链接断开，这时候请按<strong>F5</strong>，或者重新<strong>刷新</strong>网页！
		</p>
		<p>
			<strong>提示：如果刷新不出现，请检查您的网络或者查看浏览器版本，本系统支持IE6以上以及谷歌、火狐等主流浏览器。</strong>
		</p>
	</div>

	<div class="footer">
		<div class="container">
			<p class="text-muted">最终解释权归XX所有</p>
		</div>
	</div>
</body>
</html>


