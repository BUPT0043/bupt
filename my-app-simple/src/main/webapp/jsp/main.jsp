<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.mygudou.app.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>合同生成界面</title>
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
 		 <!--A区  -->
		<ul class="breadcrumb">
			<li>
				<a href="#">用户ID:xxx登录</a> <span class="divider"></span>
			</li>
			<li>
				
			</li>
			<li>
				<a href="#">HOME</a> <span class="divider"></span>
			</li>
			<li>
				<a href="#">TIME</a> <span class="divider"></span>
			</li>
			<li>
				<a href="#">HELP</a> <span class="divider"></span>
			</li>
			<li class="active">服务电话：010-12345678</li>
		</ul>
	  
	    <!--幕区  -->
       <div class="jumbotron">
        <h1>XX合同</h1>
        <p>Any individual provision of this Contrat which is or become invalid, or any 
        omission to provide for any subject matter, shall not affect the validity 
        of the remaining provisions of this Contract. In such cases, the Parties shall 
        seek solutions as closely approximate as possible in economic effet to the invalid provisions.
        </p>
        <p><a href="#" class="btn btn-primary btn-lg" role="button">more &raquo;</a></p>
		<strong>提示：</strong> 涉及相关财产，请注意保护个人隐私安全
       </div>
       
		<div class="row">
			<nav class="navbar navbar-default" role="navigation">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#" >合同</a>
		       <a class="navbar-brand" href="#" >合同</a>
		    </div>
		
		    <!--D区-->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        
		        <li><a href="#">撤销</a></li>
		        <li><a href="#">返回</a></li>
		        <li><a href="#">重置</a></li>
		        <li><a href="#">帮助</a></li>
		      </ul>
		      <form class="navbar-form navbar-left" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Search">
		        </div>
		        <button type="submit" class="btn btn-default">Submit</button>
		      </form>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#">Link</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="#">Action</a></li>
		            <li><a href="#">Another action</a></li>
		            <li><a href="#">Something else here</a></li>
		            <li class="divider"></li>
		            <li><a href="#">Separated link</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		</div>	
			<!-- B区 -->
		<div class="row">
		<div class="col-md-1"></div>
			<div class="col-md-2">
				<ul class="nav nav-list">
					<li class="nav-header">
						基本条款
					</li>
					<li class="active">
						 <a href="#">
							 <c:forEach items="${category }" var="category">
								<c:if test="${category.id%3==1}">
								${category.categoryname }
								</c:if>
							</c:forEach> 
						</a> 
					</li>
					<li>
						<a href="#">
						 <c:forEach items="${category }" var="category">
								<c:if test="${category.id%3==2}">
								${category.categoryname }
								</c:if>
							</c:forEach>
						</a>  
					</li>
						<li>
						<a href="#">
						 <c:forEach items="${category }" var="category">
								<c:if test="${category.id%3==0}">
								${category.categoryname }
								</c:if>
							</c:forEach>
						</a>  
					</li>
					<!-- 	<li>
						<a href="#">财产</a>
					</li> -->
					
					<!-- 可选择性内容 -->
					<li class="nav-header">
						附加条款
					</li>
					<li>
						<a href="#">A</a>
					</li>
					<li>
						<a href="#">B</a>
					</li>
					<li>
						<a href="#">C</a>
					</li>
					
					
				</ul>
			</div>

		<!-- 数据区域 -->
		<div class="col-md-9">
			<div class="container-fluid">
			<div class="row-fluid">
				<div class="col-md-9">
				
						<!-- 标题区域 -->
					    <ul class="list-group">
						   <li class="list-group-item">
						   	<c:forEach items="${category }" var="category">
								<c:if test="${category.id%2==1}">
								<strong>${category.categoryname }条款：</strong>
								</c:if>
							</c:forEach></li>					
						</ul>
					<!-- 	数据区域 -->
					<div class="panel-group" id="accordion">
					  <div class="panel panel-default">
					  
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
					         <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==1 }">
							  		${item.data }
							  	</c:if>
	                	 	</c:forEach>
					        </a>
					      </h4>
					    </div>

					    <div id="collapseOne" class="panel-collapse collapse in">
					      <div class="panel-body">
					        <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==1 }">
							  	${item.refer }
							  	</c:if>
	                 		</c:forEach>
					      </div>
					    </div>
					    
					  </div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="col-md-9">
					<div class="panel-group" id="accordion">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" 
					          href="#collapseTwo">
					         <c:forEach items="${items }" var="item">
						  	<c:if test="${item.id%4==2 }">
						  		${item.data }
						  	</c:if>
	                	 </c:forEach>
					        </a>
					      </h4>
					    </div>
					    <div id="collapseTwo" class="panel-collapse collapse in">
					      <div class="panel-body">
					        <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==2 }">
							  	${item.refer }
							  	</c:if>
	                 		</c:forEach>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			</div> 
		</div>
		
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="col-md-9">
						<ul class="list-group">
						   <li class="list-group-item">
						   	<c:forEach items="${category }" var="category">
								<c:if test="${category.id%2==0}">
								<strong>${category.categoryname }条款：</strong>
								</c:if>
							</c:forEach></li>					
						</ul>
					<div class="panel-group" id="accordion">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" 
					          href="#collapseThree">
					         <c:forEach items="${items }" var="item">
						  	<c:if test="${item.id%4==3 }">
						  		${item.data }
						  	</c:if>
	                	 </c:forEach>
					        </a>
					      </h4>
					    </div>
					    <div id="collapseThree" class="panel-collapse collapse in">
					      <div class="panel-body">
					        <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==3 }">
							  	${item.refer }
							  	</c:if>
	                 		</c:forEach>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="col-md-9">
					<div class="panel-group" id="accordion">
					  <div class="panel panel-default">
					    <div class="panel-heading">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" 
					          href="#collapseFour">
					         <c:forEach items="${items }" var="item">
						  	<c:if test="${item.id%4==0 }">
						  		${item.data }
						  	</c:if>
	                	 </c:forEach>
					        </a>
					      </h4>
					    </div>
					    <div id="collapseFour" class="panel-collapse collapse in">
					      <div class="panel-body">
					        <c:forEach items="${items }" var="item">
							  	<c:if test="${item.id%4==0 }">
							  	${item.refer }
							  	</c:if>
	                 		</c:forEach>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
          <div class="col-md-4"></div>
          <div class="col-md-4">
         
           <!-- 预览按钮 -->
			<button class="btn btn-lg btn-default" data-toggle="modal" 
			   data-target="#myModal">
			   预览
			</button>
			
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
		   aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      	<div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		         </div>
	         <div class="modal-body">
	           	 合同文本
	         </div>
	           <div class="modal-footer">
	            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		         </div>
		     </div>
			</div>
			</div>
	          <button type="button" class="btn btn-lg btn-default">生成word</button>
	 </div>
      
<div class="col-md-4"></div>       
        </div>        
</body>
</html>
			

