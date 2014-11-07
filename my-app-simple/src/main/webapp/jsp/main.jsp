<%@ page import="com.mygudou.app.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>合同生成界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=big5">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../js/tableExport.js"></script>
	<script src="../js/stickup.min.js"></script>
	     <!-- 编辑栏置顶 -->
	  <script type="text/javascript">
              //initiating jQuery
              jQuery(function($) {
                $(document).ready( function() {               
                  $('.navbar navbar-default').stickUp();
                });
              });
            </script>    
              <script type="text/javascript">
                 $(document).ready(function(){
                	 $("[id^=category_]").click(function(){
                     	alert($(this).attr("id").split("category_")[1]);
                     	//ajax
                     });	 
                	 /* 生成word */
                 });           
              </script>
            
           <style>
                .breadcrumb{
                margin-top: 0px;
                margin-bottom:0px;
           
                }
                .jumbotron{
                margin: 0px;
                
                }
                .navbar navbar-default{
                margin:0px;
                }
                .active1{
                float:right;
                }
                .Context{
                width:1030px;
                margin:0 auto;
                }
                .editbutton{
                float:right;
                }
               .thelast{
               	width:1030px;
               	margin:0 auto;
               }
               .container{
               width:1300px;
               }
              </style>  
</head>
<body class="Context"  background="../images/1.jpg">
    
		 <!--A区  -->
		<ul class="breadcrumb">
			<li>
				<a href="#">
				<span class="glyphicon glyphicon-home" style="color: rgb(54, 140, 167); font-size: 16px;"> Home</span></a> <span class="divider"></span>
			</li>
<!-- 			<li>
				<a href="#"><span class="glyphicon glyphicon-time" style="color: rgb(54, 140, 167); font-size: 17px;"> Time</span></a> <span class="divider"></span>
			</li> -->
			<li class="active1">
				<a href="#"><span class="glyphicon glyphicon-question-sign" style="color: rgb(54, 140, 167); font-size: 17px;"> Help</span></a> <span class="divider"></span>
			</li>
			<li class="active1"><span class="glyphicon glyphicon-phone-alt" style="color: rgb(64, 114, 145); font-size:16px;"> Phone:010-12345678</span></li>
		</ul>
	 <!--幕区  -->
      <div class="jumbotron">
        <h1><c:forEach items="${law }" var="law">${law.name }</c:forEach>合同</h1>
        <p>Any individual provision of this Contrat which is or become invalid, or any 
        omission to provide for any subject matter, shall not affect the validity 
        of the remaining provisions of this Contract. In such cases, the Parties shall 
        seek solutions as closely approximate as possible in economic effet to the invalid provisions.
        </p>
       
		<strong>提示：</strong> 涉及相关财产，请注意保护个人隐私安全
       </div> 
       
	<!--D区编辑置顶-->
       <nav class="navbar navbar-default" role="navigation">
		<div class="row"> 
		  <div class="container">
		      <ul class="nav navbar-nav">
		      	<li class="editbutton"><a href="#"><span class="glyphicon glyphicon-edit" style="color: rgb(0, 124, 162); font-size: 17px;"> 编辑</span></a></li>
		        <li><a href="#"><span class="glyphicon glyphicon-arrow-left" style="color: rgb(0, 124, 162); font-size: 15px;"> 撤销</span></a></li>
		        <li><a href="#"><span class="glyphicon glyphicon-arrow-right" style="color: rgb(0, 124, 162); font-size: 15px;"> 返回</span></a></li>
		        <li><a href="#"><span class="glyphicon glyphicon-remove" style="color: rgb(0, 124, 162); font-size: 15px;"> 重置</span></a></li>	       
		      </ul>
		    </div>
		  </div>	 
		</nav>
		<!-- B区 -->
		<div class="row"  color="#d0d0d0">
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="nav-header">基本条款</li>
					<c:forEach items="${category }" var="category">
						<div>
						<ul class="nav nav-list">
							<li class="active"> 
							 <a style="cursor: pointer" id="category_${category.id }">${category.categoryname}</a> 
							 </li>
						</ul>
					    </div>
					</c:forEach> 
				</ul> 
	<div>
	     <button class="btn btn-lg btn-default" data-toggle="modal"data-target="#myModal">
	     <span class="glyphicon glyphicon-play-circle" style="color: rgb(64, 114, 145); font-size: 22px;">Show</span></button></div>
		<div id="wordtobe" ><button type="button" class="btn btn-lg btn-default" onclick=openWord() >
			<span class="glyphicon glyphicon-saved" style="color: rgb(64, 114, 145); font-size: 22px;"  >Word</span></button>
		</div>
			</div>
			
			
		<!-- 数据区域 -->
		<div class="col-md-9" id="exportWord">
			<div class="container">
				<div class="row">
				  <div class="col-md-8" id="DateRes">	
			<!-- 数据 区域 -->
			<c:forEach items="${category }" var="category">	
				<ul class="list-group">
					<li class="list-group-item">		
						<strong>${category.categoryname}条款：</strong>
				    </li>					
				</ul>
			</c:forEach>
				
		<div class="container">
			<tr> <c:forEach items="${items }" var="item">
				  <c:if test="${item.id%4==2 }">${item.data }</c:if>
	              </c:forEach>
			<div class="btn-group btn-group-sm">
			  <button type="button" class="btn btn-default" data-toggle="collapse"  data-target="#demo">
 				 <span class="glyphicon glyphicon-circle-arrow-down" style="color: rgb(64, 114, 145);">Tips</span>
 			  </button>
			
			</div>
			</tr>
				<tr><div id="demo" class="collapse in">
					  <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==3 }">
							  	${item.refer }
							  	</c:if>
	                 		</c:forEach>
					</div>
				</tr>
					</div>
					</div>
				</div>
			</div> 
		</div>
	 </div>
	    	<!--    页脚分割线     -->
		  <HR style="FILTER: progid:DXImageTransform.Microsoft.Glow(color=#987cb9,strength=10)" width="100%" color=#987cb9 SIZE=1>
		  <div class="thelast">
		  	XX认证123456
		   </div>
</body>
</html>
 	
			

