<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="activities/css/describle.css">
  </head>
  
  <body>
    <form action="" onsubmit="return validate()">
    	<!-- 导航条 -->
    	<div class="toolbar">
			<div class="toolbar-cont wrap">
				<ul class="fl">
					<li>您好，欢迎来到周记梁品铺子官方商城！</li>
					<li><a class="reg" href="activities/login.jsp">[退出]</a>
					</li>
				</ul>
				<ul class="fr">
					<li>
						<div class="top-follow">
							<a class="follow" href="activities/user.jsp">关注梁品</a>|
						</div></li>
					<li>
						<div class="top-help">
							<a href="activities/user.jsp">官方网站</a>&nbsp;&nbsp;|
						</div>
					</li>
					<li>
						<span class="tel">
							订购热线：<em>153-8805-2293</em>
						</span>
					</li>
				</ul>
			</div>
		</div>
		<div class="header">
			<div class="head-main wrap clearfix">		
				<div class="logo">
					<a href="">
						<img alt="" src="activities/img/LoginAndRegAndUser/logo.png">
					</a>
				</div>	
				<div class="hd-user-nav">
					<ul>
						<li>
							<a href="">用户中心</a>
						</li>
						<li>
							<a href="">安全中心</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
    </form>
  </body>
</html>
