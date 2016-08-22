<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="activities/css/describle.css">
	<script type="text/javascript" src="activities/js/jquery-2.1.4.js"></script>
	<script type="text/javascript" >
		
		var $un = $("#username");
		var $pw = $("#password");
		
		$un.focus(function() {
			$(".fill-error.username").hide();
		});
		$pw.focus(function() {
			$(".fill-error.password").hide();
		});
			
		function submitForm() {
			var cansubmit = true;
			if (!$un.val()) {
				$(".fill-error.username").show();
				cansubmit = false;
			}
			if (!$pw.val()) {
				$(".fill-error.password").show();
				cansubmit = false;
			}
			return cansubmit;
		}
		
	</script>
  </head>
  
  <body>
    
    	<form id="fm1" action="/login?service=http%3A%2F%2Fwww.lppz.com%2F" method="post" onsubmit="return submitForm();">
		<input type="hidden" name="lt" value="LT-122449-Hf1O69u0wnqheZ2GQEtbdU4cB0NEHH-www.lppz.com" />
		<input type="hidden" name="execution" value="e1s1" />
		<input type="hidden" name="_eventId" value="submit" />
		<!-- 导航条 -->
		<div class="toolbar">
			<div class="toolbar-cont wrap">
				<ul class="fl">
					<li>您好，欢迎来到周记梁品铺子官方商城！</li>
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
							<a class="follow" href="activities/login.jsp">关注梁品</a>|
						</div></li>
					<li>
						<div class="top-help">
							<a href="activities/login.jsp">官方网站</a>&nbsp;&nbsp;|
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
		<!-- -->
		<div class="log-header wrap">
			<div class="slogo">
				<a title="周记梁品铺子" href="">
					<img alt="" src="activities/img/LoginAndReg/logo.png">
				</a>
			</div>
			<div class="sub-tit">欢迎登录</div>
		</div>

		<!--内容部分-->
		<div class="login-main wrap clearfix">
			<div class="login-img">
				<img src="activities/img/LoginAndReg/left_img.jpg" alt="" class="pic"/>
			</div>
			<div class="login-data">
				<div class="ldt-titlte">
					<strong class="tit">会员登录</strong><span class="reg-new">新用户，<a href="activities/register.jsp" class="free-reg">免费注册></a>
					</span>
				</div>
				
				<ul class="ldt-form focus-bd">
					<li>
						<span class="lab">用户名/邮箱/手机号</span>
						<div class="ipt">
							<input id="username" name="username" class="tx-ipt" tabindex="1" type="text" value="" size="25" autocomplete="off"/>
							<label class="fill-error username none">请输入邮箱/用户名/已验证手机</label>
						</div>
					</li>
					<li>
						<span class="lab">密码</span>
						<div class="ipt">
							<input id="password" name="password" class="tx-ipt" tabindex="2" type="password" value="" size="25" autocomplete="off"/>
							<label class="fill-error password none">请输入密码</label>
						</div>
					</li>
					
					<li>
						<span class="lab">
						<a style="color:#005ea7;" href="activities/login.jsp">已有会员卡，我要激活</a>
						</span>
						<div class="smt-btn">
							<input type="submit" class="log-btn d-b" accesskey="l" value="登 录" />
						</div>
					</li>
				</ul>
				<div class="coopt-login">
					<span>使用合作网站账号登录梁品铺子：</span>
					<div class="coopt-item">
						<a class="alipay" href="activities/login.jsp">支付宝登录</a> 
						<a class="qq" href="activities/login.jsp">QQ登录</a> 
						<a class="weibo" href="activities/login.jsp">微博登录</a>
					</div></div></div></div>

		<!--底部-->
		<div class="log-footer">
			<div class="lfoot wrap">
				<div class="lfoot-link">
					<ul>
						<li><a href="activities/login.jsp">关于我们</a> |</li>
						<li><a href="activities/login.jsp">联系我们</a> |</li>
						<li><a href="activities/login.jsp">客户服务</a> |</li>
						<li><a href="activities/login.jsp">诚聘英才</a> |</li>
						<li><a href="activities/login.jsp">商务合作</a> |</li>
						<li><a href="activities/login.jsp">媒体报道</a> |</li>
						<li><a href="activities/login.jsp">网站地图</a> |</li>
						<li><a href="activities/login.jsp">快递查询</a></li>
					</ul>
				</div>
				<div class="copyright">
					Copyright@2006-2016 湖北良品铺子电子商务有限公司 All rights Reserved<br/><a href="activities/login.jsp">鄂ICP备15022981号</a>
				</div>
				
			</div>
		</div>
	</form>
    
  </body>
</html>
