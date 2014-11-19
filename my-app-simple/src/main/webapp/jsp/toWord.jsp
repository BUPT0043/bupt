<%@ page import="com.mygudou.app.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	  <head>
    <meta charset="utf-8">
    <title>首页</title>
   <meta http-equiv="Content-Type" content="text/html; charset=big5">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <!-- Loading Flat UI -->
    
	<style>
	/* 收缩展开效果 */
	.text{line-height:22px;padding:0 6px;color:#666;}
	.box h1{padding-left:10px;height:22px;line-height:22px;background:#f1f1f1;font-weight:bold;}
	.box{position:relative;border:1px solid #e7e7e7;}
	</style>

</head>
<body>
	<script type="text/javascript">
	// 收缩展开效果
	$(document).ready(function(){
	   $(".box h1").toggle(function(){
	     $(this).next(".text").animate({height: 'toggle', opacity: 'toggle'}, "slow");
	   },function(){
	$(this).next(".text").animate({height: 'toggle', opacity: 'toggle'}, "slow");
	   });
	});
	</script>
	<!-- 收缩展开效果 -->
	<div class="box">
	<h1>收缩展开效果</h1>
	<div class="text">
	        1<br/>
	        2<br/>
	        3<br/>
	        4<br/>
	        5<br/>
	</div>
	</div>
	<br/>
	
	<div class="box">
	<h1>收缩展开效果</h1>
	<div class="text">
	        1<br/>
	        2<br/>
	</div>
	</div>
	<br>
	第一次运行请刷新一下页面。
	<br />
	<p><a href="http://www.webdm.cn">网页代码站</a> - 最专业的网页代码下载网站 - 致力为中国站长提供有质量的网页代码！</p>
	
	</body>
	</html>
			

