<%@ page import="com.mygudou.app.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ include file="./head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>合同生成界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../js/stickup.min.js"></script>
	<script src="../js/tableExport.js"></script>
	<script src="../js/jquery.base64.js"></script>
	<script src="../js/base64.js"></script>
	<script src="../js/sprintf.js"></script>
	<script src="../js/jspdf.js"></script>
	<link href="../css/flat-ui.css" rel="stylesheet">
	<link href="../css/main.css" rel="stylesheet">
    <!-- 编辑栏置顶 -->
    	  <style type="text/css">
    	  .jumbotron{
    	  margin-top: 2px;
    	  }
    	  .dataeditzone{
				margin-left:0px;
				width:255px;
				background-color: white;
				}
				.btn-lg, .btn-group-lg > .btn{
				margin: 8px;
				}
				.editzone{
				width:1030px;
				margin-top:2px;
				margin-bottom: 2px;
			    position:absoulte;
			    z-index:5555
				}
				.datazone p{
				font-size: 14px;
				width:769px;
				margin-right: 0px;
				padding-right: 0px;
				}
				.col-md-12{
				margin-bottom: 2px;
				}
				.btn2{
				margin:12px;
				margin-right: 15px;
				margin-top: 5px;
				float:right;
				}
				.btn-primary{
				float:right;
				margin-bottom: 12px;
				width:150px;
				}
				.btn-default{
				background-color: #1ABC9C;
				}
				.refer1{
					margin-left: 15px;
				}
				.bbtn{
				  color: #fff;
				  background-color: #1ABC9C;
				  width:25px;
				  height: 25px;
				  border:0px #ff0000 solid;
 				  border-radius: 5px;
				}
				.lawbtn{
				 color: #fff;
 				 background-color: #637A90;
 				 border:0px #ff0000 solid;
 				 border-radius: 5px;
 				 margin-left: 665px;
 				 width: 80px;
 				 height: 30px;
 				 
				}
    	  </style>
    	  
		  <script type="text/javascript">
			  jQuery(function($){ 
				  $(document).ready(function() { 
						  $("#editzone").stickUp(); 
						  });
				  }); 
			  
			  jQuery(function($){ 
				  $(document).ready(function() { 
						  $('.dataeditzone').stickUp(); 
						  });
				  }); 
		  </script>
	     
         <script type="text/javascript">
            function searchItem(){
        		var categoryids=0;
                $('#navList input[type=checkbox]:checked').each( function(){
                        id=$(this).attr("id").split("category_")[1];
                        categoryids+=","+id;
                }); 
                
                //ajax
            	 $.ajax({
                    type: "POST",
                    url: "${myapp}/show/searchItem",
                    data: "categoryids="+categoryids+"&"+"lawid="+${lawid} ,
                    success: function(data) {
                   	 var list=eval("("+data+")");
                   	 var newContent = "";
                   		for(var i in list){
                   			var dataList = list[i]['data'].split("<br/>");
                   			newContent +="<table><tr>";
                   			for(var j in dataList){
                   				if("" != dataList[j]){
                   					newContent +="<div><div><input class='cbxcss'  type='checkbox'>"+dataList[j]+"</input></div>"+
                   						"<input type='button' value='+' class='bbtn' onclick='$(this).parent().clone(true).insertAfter(this);'/></div>";
                   				}
                   			}
                   			 newContent +="<input type='button' class='lawbtn' value='法律条款' onclick='showRefer(this,"+i+")' /><p id='refer_"+i+"' style='display:none'>"+list[i]['refer']+"</p>";
             	             }
                   		$("#data").html(newContent);
             	        }
                });
        	}
            
            function showRefer(obj,i){
            	if($("#refer_"+i).is(":hidden")){
            		$(obj).val("关闭");
            	}else{
            		$(obj).val("法律条款");
            	}
            	
            	$("#refer_"+i).toggle();
            	
            }
            function toWord(){
            	var param = new Array();
            	$(".datazone input:checked").each(function(){
            		var newContent = $(this).parent().clone();
            		newContent.find("input").each(function(i){
            			if(i != 0){
            				var str = $(this).val();
                			$(this).replaceWith("<p>"+str+"</p>");
            			}
            		});
            		param.push(newContent.text());
            	});
            	window.open('toWord?param='+param);
            	
            }
            	//显示div
            $(document).ready(function(){
				  $("#btn1").click(function(){
					  $("#Itemedit").slideUp(500);
					  var newContent = "";
					  $("#navList").find(":checked").parent().clone().each(function(){
						  newContent+= "<p style='font-size: 13px'>"+$(this).text()+"<p/>";
					  })
					  $("#navaSidebar").html(newContent);
					  });
					  $("#btn2").click(function(){
						  //alert('2222')
						  $("#Itemedit").slideDown(500);
						  });
			});
            	
         </script>
</head>

<body class="Context" id="body1" background="../images/1.jpg">
		 <!--A区  -->
		<ul class="breadcrumb">
			<li>
				<a href="firstshow">
				<span class="glyphicon glyphicon-home" style="color: rgb(54, 140, 167); font-size: 16px;"> Home</span></a> <span class="divider"></span>
			</li>
			<li >
				<a href="login"><span class="glyphicon glyphicon-repeat" style="color: rgb(54, 140, 167); font-size: 17px;"> Back</span></a> <span class="divider"></span>
			</li>
			<li class="active1">
				<a href="#"><span class="glyphicon glyphicon-question-sign" style="color: rgb(54, 140, 167); font-size: 17px;"> Help</span></a> <span class="divider"></span>
			</li>
			<li class="active1"><span class="glyphicon glyphicon-phone-alt" style="color: rgb(64, 114, 145); font-size:16px;"> Phone:010-12345678</span></li>
		</ul>
		
		<!--幕区  -->
        <div class="jumbotron">
        <h1>${law.name }合同</h1>
        <p>读取数据库内容</p>
		<strong>提示：</strong> 涉及相关财产，请注意保护个人隐私安全
       </div>  
		<!--D区编辑editzone--置顶-->
       <div class="editzone" id="editzone" style="background-color: #FFFFCC";>  <strong style="margin-left: 10px;">条款操作</strong>
       		   <a href="#" class="btn2" onclick="javascript:window.top.location.reload()"><span class="glyphicon glyphicon-remove" style="color: rgb(0, 124, 162); font-size: 15px;"> 重置</a>
	           <a href="#" id="btn2" class="btn2"><span class="glyphicon glyphicon-list" style="color: rgb(0, 124, 162); font-size: 15px;"> 重新选择</a>
       </div>
      
		<!-- 数据区域 -->
		<!-- 数据Item 选择区 -->
		<div class="col-md-12" id="Itemedit"  style="background-color: #EEEEEE">
		   <div class="panel-heading">
		      <h3 class="panel-title">条款内容选择：</h3>
		   </div>
           <div>
            <ul id="navList" class= "nav nav-list">
               <c:forEach items= "${category }" var="category">
                 <li class= "item1">
				         <label class="checkbox"  for="checkbox1">
				         <input style="cursor: pointer" type="checkbox" value="${category.id }" id ="category_${category.id}">是否有${category.categoryname}？</input></label>
                 </li>
               </c:forEach>
            </ul>
           </div>
            <button class="btn btn-primary" id="btn1" type="button" onclick="searchItem();">确定</button>
		 </div>
		<!-- 数据内容区域 -->
		<div class="col-md-3" style="background-color: white">
		<div class="dataeditzone" >
			 <div class="container">
		      <div class="row">
		        <div class="col-sm-3 col-md-2 sidebar">
		          <ul class="nav nav-sidebar">
		          	<li id="navaSidebar"></li>
		          	<li>
                        <button type ="button" class="btn btn-lg btn-default" onClick ="toWord();">
                        	<span class= "glyphicon glyphicon-saved" style="color : rgb(255, 255, 255); font-size: 22px;" > Word</span>
                        </button>
		          	</li>
		          </ul>
		       	 </div>
		      </div>
	         </div>
	        </div>
		</div>
			<!-- 条款投射区 -->
		<div class="col-md-9">
			<div class="datazone" style="background-color: white">
				<p id="data" class="data1"></p>
				<p id="refer" class="refer1"></p>
		   </div>
	   </div>
		 <!--    页脚分割线     -->
		
        <HR style=" FILTER: progid:DXImageTransform.Microsoft.Glow (color=#987cb9,strength= 10)" width ="100%" color=#987cb9 SIZE= 1>
        <div class= "thelast">
          XX认证123456
        </div>
</body>
</html>
 	
			

