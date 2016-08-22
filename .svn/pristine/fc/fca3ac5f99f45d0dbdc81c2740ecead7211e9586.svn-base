<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
    <ul id="tree" style="height:97%;width:96%;margin: 0px;padding: 0px;padding-top: 10px;padding-left: 5px; background:#AFF7FF; background-repeat:repeat-y;background-image: url('${pageContext.request.contextPath}/images/bg_center.jpg');">
	     <li>
	     	<a id="type" href="${pageContext.request.contextPath}/backservlet/CategoryServlet?command=getType" target="center">类别管理</a>
	     </li>
	     <li>
	     	<a id="goods" href="" target="center">商品管理</a>
	     </li>
	     <li>
	     	<a id="order" href="jsp" target="center">订单管理</a>
	     </li>
     </ul>
  </body>
</html>
