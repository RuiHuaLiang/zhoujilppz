<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
					<li><a class="reg" href="activities/login.jsp">[登录]</a>
					</li>
					<li><a class="reg" href="activities/register.jsp">[注册]</a>
					</li>
					<li><a class="alipay" href="activities/login.jsp">支付宝快捷登录</a>
					</li>
					<li><a class="qq" href="activities/login.jsp">QQ</a>
					</li>
					<li><a class="weibo" href="activities/login.jsp">微博登录</a>
					</li>
				</ul>
				<ul class="fr">
					<li>
						<div class="top-follow">
							<a class="follow" href="activities/register.jsp">关注梁品</a>|
						</div></li>
					<li>
						<div class="top-help">
							<a href="activities/register.jsp">官方网站</a>&nbsp;&nbsp;|
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
		
		<!-- 左部logo -->
		<div class="log-header wrap">
			<div class="slogo">
				<a title="周记梁品铺子" href="">
					<img alt="" src="activities/img/LoginAndReg/logo.png">
				</a>
			</div>
			<div class="sub-tit">欢迎注册</div>
		</div>
		
		<div class="register-main wrap clearfix">
			<div class="reg-img">
				<img src="activities/img/LoginAndReg/left_img.jpg" alt="" class="pic"/>
			</div>
			<div class="reg-data">
				<div class="rdt-titlte">
					<strong class="tit">用户注册</strong><span class="to-log">已有账户，<a href="activities/login.jsp" class="free-reg">在此登录></a>
					</span>
				</div>
				
				<ul class="form-data">
					<li>
						<span class="lb-txt"><b class="requiredField">* </b>用户名：</span>
						<input class="tx-ipt uname" type="text" name="username" id="username" maxlength="20" tabindex="1">
					</li>
					<li>
						<span class="lb-txt"><b class="requiredField">* </b>密　码：</span>
						<input class="tx-ipt pword" type="password" name="password" id="password" maxlength="20" tabindex="2">
					</li>
					<li>
						<span class="lb-txt"><b class="requiredField">* </b>确认密码：</span>
						<input class="tx-ipt pword" type="password" name="rePassword" id="rePassword" maxlength="20" tabindex="3">
					</li>
					<li>
						<span class="lb-txt"><b class="requiredField">* </b>手机号：</span>
						<input class="tx-ipt phone" type="text" name="mobile" id="mobile" maxlength="11" tabindex="4">
					</li>
					<li>
						<span class="lb-txt"><b class="requiredField">* </b>验证码：</span>
						<div class="ver-code">
							<input class="tx-ipt mcode" type="text" name="image" id="image" maxlength="20" tabindex="5"/>
							<input type="hidden" name="imageId" id="imageId" value="c043cc1fdff84a389b2fec00f0059335"/>
							<span class="verify">
								<img alt="验证码" src="http://check.lppz.com/imgcode/c043cc1fdff84a389b2fec00f0059335.jpg" class="cimg" id="imageShow">看不清？<a href="javascript:;" class="change-img">换一张</a>
							</span>
						</div>
					</li>
					<li class="clause">
						<div class="agreement">
							<b class="requiredField">* </b>
							<input class="ckb-ipt" type="checkbox" 
							name="lppz_info" id="lppz_info" checked>
							我已阅读并同意
							<a onclick="hasUp($('.agree-popup'))" 
							href="javascript:;">《良品铺子用户注册协议》</a>
						</div>
					</li>
					<li>
						<div class="submit"><input id="smt-btn" class="smt-btn" type="button" value="同意协议并注册" onClick="smtBtn()"></div>
					</li>
					</ul>
				</div>
			</div>
			<div class="log-footer">
			<div class="lfoot wrap">
				<div class="lfoot-link"></div>
				<div class="copyright">
					Copyright@2006-2016 湖北良品铺子电子商务有限公司 All rights Reserved<br/><a href="activities/register.jsp">鄂ICP备15022981号</a>
				</div>
				
			</div>
		</div>
    </form>
    
  </body>
</html>
