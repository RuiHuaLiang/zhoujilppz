<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getAllCategory.jsp' starting page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/manageview/js/jquery-2.1.4.js"></script>
  	<script type="text/javascript">
  		$(function(){
	  		/* $("#byName").click(function(){
		    	$("#query").submit();
		    }); */ 
		    $("#byType").change(function(){
		    	$("#query").submit();
		    });
		    
		    $("#byParentId").change(function(){
		    	$("#query").submit();
		    });
		    	
			$("#addOrUpdate").click(function(){
				$("#addForm").submit();
			});
			$("").click();
		});
		function nextPage(currentPage){
			document.getElementById("currentPage").value=currentPage;
			//document.getElementById("pageSize").value=pageSize;
			document.getElementById("query").submit();//实现表单的提交
		}
		
		/* function deleteType(categoryId) {
			var msg = "确定要删除该类别？\n\n请确认！";
			if(confirm(msg)){
				$("#command").val("deleteType");
				$("#categoryId").val(categoryId);
				 alert($("#command").val());
				alert($("#categoryId").val()); 
				$("#query").submit();
			}
			//$("#query").submit();
		//表单提交修改command
		//a标签在方法中提交请求，可在后面加参数
		 //window.location.href='${pageContext.request.contextPath}/backservlet/CategoryServlet?command=deleteType';
		 }   */
		 
		 
		 
		 /*
		 	添加或修改类别表信息
		 */
		 function addType(categoryId,categoryName,parentId){
		 	alert("被调用了");
		 	if(categoryId != null && categoryId.lenth > 0){
		 		alert("被调用了");
		 		$("#title").html("修改类别信息");
		 		$("#addCommand").val("updateType");
		 		$("#id").attr("type","text");
		 		$("#tip").show();
		 		$("#id").val(categoryId);
		 		$("#addName").val(categoryName);
		 		//alert();
		 		$("#addOrUpdate").val("修改");
		 		$("#addParentId").children().each(function(i){
   					if($(this).val == parentId){
   						$(this).attr("selected");
   					}
 				});
		 	}
		 
		  $("#mask").show();
   	 	  $("#hideDiv").show();
		 }
  	</script>
  </head>
  
  <body>
  	<h1>商品类别管理</h1>
    <div>
    	<form id="query" action="${pageContext.request.contextPath}/backservlet/CategoryServlet">
    		<input type="hidden" id="command" name="command" value="queryType">
    		<input type="hidden" id="currentPage" name="currentPage" value="">
    		<input type="hidden" id="pageSize" name="pageSize" value="">
    		<input type="hidden" id="categoryId" name="categoryId" value="">
    		<select id="byType" name="type">
    			<option value="0">所有</option>
    			<option value="1" ${type==1?"selected":"" }>父类别</option>
    			<option value="2" ${type==2?"selected":"" }>子类别</option>
    		</select>
    		<select id="byParentId"name="parentId" >
    				<option value="">--按父类别查询--</option>
    				<c:forEach items="${parentCate}" var="cate2">
    					<c:choose>
	    					<c:when test="${cate2.categoryId == parentId}">
	    						<option value="${cate2.categoryId}" selected >${cate2.categoryName}</option>
	    					</c:when>
	    					<c:otherwise>
								<option value="${cate2.categoryId}">${cate2.categoryName}</option>	
							</c:otherwise>
	    					</c:choose>	
    				</c:forEach>
    		</select>
    		<input name="name" value="${name}"><input type="submit" value="查询">
    	</form>
    	<a id="addType" href="javaScript:;" onclick="addType()">添加子类别</a>
    	<div id="mask" style="display:none; width: 100%;height: 100%;background-color:#C6BDFF;position: absolute;left: 0px;top: 0px;opacity:.5;z-index: 100"></div>
    	<div id="hideDiv" style="z-index:101; display: none;position: absolute;border: 2px solid gray;background-color:#FF9C9B;">
    		
    		<span id="title">添加类别信息</span>
    		<form id="addForm" action="${pageContext.request.contextPath}/backservlet/CategoryServlet">
    			<input type="hidden" id="addCommand" name="command" value="addType">
    			<span id="tip" style="display:none">类别编号:</span>
    			<input type="hidden" id="addId" name="id" readonly value=""><br/>
    			类别名称:<input id="addName" name="categoryName" value=""><br/>
    			选择父类别:<select id="addParentId" name="parentId">
		    			<c:forEach items="${parentCate}" var="cate2">
    					<c:choose>
	    					<c:when test="${cate2.categoryId == parentId}">
	    						<option value="${cate2.categoryId}" selected >${cate2.categoryName}</option>
	    					</c:when>
	    					<c:otherwise>
								<option value="${cate2.categoryId}">${cate2.categoryName}</option>	
							</c:otherwise>
	    					</c:choose>	
    					</c:forEach>
		    			</select><br/>
		    			<input type="button" id="addOrUpdate" value="添加">
		    			<input type="button" id="reset" value="取消"><br/>
    		</form>
    	</div>
    	<div>
    	<table border="1px" cellspacing="0">
    	 <tbody>
    		<tr>
    			<th>类别类型</th>
    			<th>父类别id</th>
    			<th>父类别名称</th>
    			<th>类别id</th>
    			<th>类别名称</th>
    			<th>操作</th>
    		</tr>
    	<c:forEach items="${allCate.data}" var="cate">
    		<tr>
    			<c:choose>
    				<c:when test="${cate.parentId ==0}">
    					<td>父类别</td>
    					<td>---无---</td>
    					<td>---无---</td>
    				</c:when>
    				<c:otherwise>
    					<td>子类别</td>
    					<td>${cate.parentId}</td>
    					<c:forEach items="${parentCate}" var="cate2">
    						<c:if test="${cate.parentId == cate2.categoryId}">
    							<td>${cate2.categoryName}</td>
    						</c:if>
    					</c:forEach>
    				</c:otherwise>
    			</c:choose>
    			<td>${cate.categoryId}</td>
    			<td>${cate.categoryName}</td>
    			<td><a href="javaScript:;" onclick="addType('${cate.categoryId}','${cate.categoryName}','${cate.parentId}')">修改</a></td>
    		<%-- 	${cate.categoryId},${cate.categoryName},${cate.parentId}
 --%>    		</tr>
    	</c:forEach>
    	<tr>
				<td colspan="6">
				<a href="javaScript:;" onclick="nextPage(1)">第一页</a> 
				<c:choose>
					<c:when test="${allCate.currentPage==1}">
						${"上一页"}
					</c:when>			
				 	<c:otherwise>
					<a href="javaScript:;"onclick="nextPage(${allCate.currentPage-1})">上一页</a>
					</c:otherwise>
				 </c:choose>
				<c:choose>
					<c:when test="${allCate.currentPage==allCate.pageCount}">
						${"下一页"}
					</c:when>			
				 	<c:otherwise>
					<a href="javaScript:;" onclick="nextPage(${allCate.currentPage+1})">下一页</a>
					</c:otherwise>
				 </c:choose>
				<a href="javaScript:;" onclick="nextPage(${allCate.pageCount})">尾页</a> 
				[当前第${allCate.currentPage}页/${fn:length(allCate.data)}条][每页<input id="size" value="${allCate.pageSize}">条][共${allCate.pageCount}页/共${allCate.totalRecord}条]</td>
			</tr>
		</tbody>
    	</table>
    	</div>
    </div>
  </body>
</html>
