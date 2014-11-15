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
    <link href="../css/flat-ui.css" rel="stylesheet">

    <style>
    
    	.login-form{
    	width:800px;
    	magin:0px auto;
    	}
    	.tile p{
    	font-size: 20px;
    	}
    	.tile-title {
		  margin: 0;
		  font-size: 45px;
		  }
    	.tile-image {
    	  margin-top:5px;
		  height: 400px;
		 }
		 .btn btn-large btn-block btn-info{
		 width:500px;
		 }
    
    </style>
  </head>
  <body class="body1" >
	<div class="jumbotron">
	   <div class="container">
	      <div class="span3">
          <div class="tile">
            <img class="tile-image" alt="" src="../images/note.jpg" />
            <h3 class="tile-title">合同Maker</h3>
            <p>用最简单的方式生成合同</p>
           <a href="login" class="btn btn-primary btn-lg" >进入</a>
          </div>
        </div>     
	   </div>
	</div>
</body>
</html>
 	
			

