<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/manageview/css/backLogin.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/manageview/js/jquery-2.1.4.js"></script>
  	<script type="text/javascript">
  		
  	</script>
  </head>
 <body style="margin:0px;" class="bodystyle">
	<div style="position:absolute;">
		<div style="margin:0 auto;width:320px;height:300px;position:absolute;left:500px;top:120px;">
		<h1 style="margin:0 auto;padding-top:10px; color:#FF936A;">周记梁品铺子后台登录</h1><br/>
		<form action="${pageContext.request.contextPath}/servlet/AdminServlet">
					<div>
						<input type="hidden" name="command" value="adminLogin">
	                    <p>账户名</p><input value="admin01" name="adminaccount" style="width:200px;height:34px;box-shadow:inset 0 0 8px #eaeaea; background:#fdfdfd;"type="text"></input>
	                	<span class="err-msg-login">${errVo.errinfo1}</span>
	                </div>
	               
	                
	                <div>
	                	<p>密码</p>
	                    <input value="pwd123" name="adminpassword" style="width:200px;height:34px;box-shadow:inset 0 0 8px #eaeaea; background:#fdfdfd;" class="log-input log-input-bottom" type="password" placeholder="密码"></input>
	                	<span class="err-msg-login">${errVo.errinfo2}</span>
	                </div>
	                
	                <span>${info}</span><br/>
	                
	                <input type="submit" value="登录"></input>
				
			 </form>
		</div>
	</div>
 </body>
</html>

