<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getAllCategory.jsp' starting page</title>
    

  </head>
  
  <body>
  ${allCate.pageSize}${pageCate.currentPage}/${allCate.pageSize}/${allCate.pageCount}/${allCate.totalRecord}	
    <div>
    	<table border="1px" cellspacing="0">
    	 <tbody>
    		<tr>
    			<th>类型</th>
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
    					<td>一级类别</td>
    					<td>---无---</td>
    					<td>---无---</td>
    				</c:when>
    				<c:otherwise>
    					<td>二级类别</td>
    					<td>${cate.parentId}</td>
    					<c:forEach items="${allCate.data}" var="cate2">
    						<c:if test="${cate.parentId == cate2.categoryId}">
    							<td>${cate2.categoryName}</td>
    						</c:if>
    					</c:forEach>
    				</c:otherwise>
    			</c:choose>
    			<td>${cate.categoryId}</td>
    			<td>${cate.categoryName}</td>
    			<td><a href="#">删除</a><a href="#">修改</a></td>
    		</tr>
    	</c:forEach>
    	<tr>
				<td colspan="6">
				
				<!-- 
					int currentPage ; //当前第几页       由参数currentPage给定
    				int pageSize ;   //每页显示的记录数  由参数pageSize给定
    				int totalRecord; //总记录数           参数sql执行查询获得的总记录数  如参数sql为 select * from emp 返回14条记录，则此值为14
   				    int pageCount;   //总页数           pageCount =totalRecord/pageSize   需考虑有余数的情况
    				List<T> data;
				
					点击超链接，调用一js代码，由js提交表单
				 -->
				<a href="javaScript:;" onclick="nextPage(1)">第一页</a> 
				<c:choose>
					<c:when test="${allCate.currentPage==1}">
						${"上一页"}
					</c:when>			
				 	<c:otherwise>
					<a href="javaScript:;" onclick="nextPage(${allCate.currentPage-1})">上一页</a>
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
				[当前第${allCate.currentPage}页/${allCate.pageSize}条][共${allCate.pageCount}页/共${allCate.totalRecord}条]</td>
			</tr>
		</tbody>
    	</table>
    	${pageCate.currentPage}/${pageCate.pageSize}/${pageCate.pageCount}/${pageCate.totalRecord}	
    </div>
  </body>
</html>
