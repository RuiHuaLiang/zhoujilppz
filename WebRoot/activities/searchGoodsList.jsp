<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>搜索页</title>
	<link rel="stylesheet" href="<%=path%>/activities/css/reset.css"/>
	<link rel="stylesheet" href="<%=path%>/activities/css/search.css"/>
	<link rel="stylesheet" href="<%=path%>/activities/css/comment.css"/>
	<script src="<%=path%>/activities/js/jquery-2.1.4.js"></script>
	<script src="<%=path%>/activities/js/main.js"></script>
	<script src="<%=path%>/activities/js/pageHandle.js"></script>
</head>
<body>
	<input type="hidden" value="<%=path%>" id = "path">
	<div id="rightToolBar">
		<ul>
			<li><a href="#">购物车</a><span class="circleRed">
				<c:if test="${!empty carItems}">
					${carItems.size()}
				</c:if>
				<c:if test="${empty carItems}">
					0
				</c:if>
			</span></li>
			<li><a href="#"><img src="<%=path%>/activities/img/userinfo.png" alt="userinfo"/></a>
				<div><a href="#">个人中心</a></div>
			</li>
			<li><a href="#"><img src="<%=path%>/activities/img/love.png" alt="love"/></a>
				<div><a href="#">收藏夹</a></div>
			</li>
		</ul>
		<ul class="positionBottom">
			<li><a href="#">&and;</a>
				<div><a href="#">返回顶部</a></div>
			</li>
		</ul>
	</div>
		<div id="header">
		<div id="toolBar">
			<div id="toolBarContent">
				<ul id="welCome">
					<li id="UserName" class="redColor">${user.getUserName()}</li>
					<li>欢迎来到周记良品铺子官方商城！</li>
					<li id="login"><a href="#" class="redColor" >[登陆]</a></li>
					<li  id="register"><a href="#" class="redColor">[注册]</a></li>
				</ul>

				<ul id="info">
					<li  class="whiteBorder"><a href="#">我的良品<img src="<%=path%>/activities/img/list1.png" alt="list"/></a>

						<div id="UserInfo">
							<div>
								<div id="headImg">
									<img src="<%=path %>/activities/img/avatar.png" alt="avatar"/>
								</div>
								<h1><c:if test="${!empty user.getUserName()}"><span class="redColor inline">${user.getUserName()}</span></c:if>
									您好 
									<c:if test="${empty user.getUserName()}"><span class="redColor inline">请登录</span></c:if></h1>
								<div>
									<ul id="infoList">
										<li><a href="#">我的订单</a></li>
										<li><a href="#">我的关注</a></li>
										<li><a href="#">我的优惠券</a></li>
										<li><a href="#">我的积分</a></li>
									</ul>
								</div>
								<div >
									<ul id="item">
										<li><a href="#">签到有好礼</a></li>
										<li><a href="#">购物指南</a></li>
									</ul>
								</div>

							</div>
							<div id="latestAndMore">
								<span class="left blackColor">最近浏览</span>
								<a class="right" href="#">更多</a>
							</div>
						</div>
					</li>
					<li >|</li>
					<li class="redAndUnderline"><a href="#">关注良品</a></li>
					<li >|</li>
					<li class="redAndUnderline"><a href="<%=path%>/IndexServlet">官方网站</a></li>
				</ul>
			</div>
		</div>

		<div id="logoAndSearch">
			<div>
				<div id="logo" class="left">
					<a href="<%=path%>/IndexServlet"><img src="<%=path%>/activities/img/logo.png" alt="logo"/></a>
				</div>

				<div id="shoppingCar">
					<a href="#" class="shoppingLineHeight">购物车</a>
					<span class="shoppingLineHeight">&gt;</span>
					<span class="shoppingLineHeight">
						<c:if test="${!empty carItems}">
							${carItems.size()}
						</c:if>
						<c:if test="${empty carItems}">
							0
						</c:if>
					</span>

					<div id="shoppingCarItem">
						<div id="itemHead">
							最新加入的商品
						</div>
						<table id="goodsItem" width="320px">
							<tr>
								<th width="40px">简图</th>
								<th width="200px">商品名</th>
								<th width="40px">数量</th>
								<th width="40px">单价</th>
							</tr>
							
							<c:set var="sum" value="0"></c:set>
							<c:set var="itemCount" value="0"></c:set>
							<c:forEach items="${carItems}" var="item">
								<tr>
									<th><a href="<%=path%>/GoodsServlet?command=goodsInfo&goodsId=${item.goodsId}"><img src="<%=path%>${item.pictureUrl}" alt="decount"/></a></th>
									<th><a href="<%=path%>/GoodsServlet?command=goodsInfo&goodsId=${item.goodsId}">${item.goodsName})</a></th>
									<th><span class="redColor inline">${item.goodsNum}</span></th>
									<th><span class="redColor inline">￥${item.goodsPrice}</span></th>
								</tr>	
								<c:set var="sum" value="${sum+(item.goodsPrice*item.goodsNum)}"></c:set>
								<c:set var="itemCount" value="${itemCount+item.goodsNum}"></c:set>
							</c:forEach>
							
						</table>

						<p class="right" style="margin-right: 15px ;color: white">
							共 <span class="redColor inline"> ${itemCount}</span> 件商品，共计
							<span class="redColor inline">￥ ${sum}</span>
						</p>
						<div class="clear"></div>
						<div id="count"><a href="#">去购物车结算</a></div>
					</div>
				</div>

				<div id="search" class="right">
					<div id="hotSearch">
						<span class="blackColor left">热门搜索：</span>
						<a href="#">松子</a>
						<a href="#">松子</a>
						<a href="#">松子</a>
						<a href="#">松子</a>
					</div>
					<div id="searchInput">
						<form action="<%=path%>/GoodsServlet">
							<input type="hidden" name="command" value="search"/>
							<input type="hidden" name="pageSize" value="16"/>
							<input type="hidden" name="currentPage" value="1"/>
							
							<c:if test="${!empty search}">
								<input id="searchText" type="text" name="search" value="${search}"/>
							</c:if>
							<c:if test="${empty search}">
								<input id="searchText" type="text" name="search" value="商品关键字"/>
							</c:if>
							
							<input id="searchSubmit" type="submit" value="搜&nbsp;&nbsp;索"/>
						</form>
							
					</div>
				</div>
			</div>

		</div>

		<div id="navigation">
			<div>

				<ul id="navigationList">
					<li><a href="<%=path%>/IndexServlet">首页</a></li>
					<li><a href="#">八月新品</a></li>
					<li><a href="#">助味奥运惠</a></li>
					<li><a href="#">糖果糕点</a></li>
					<li><a href="#">进口食品</a></li>
					<li><a href="#">无肉不欢</a></li>
					<li><a href="#">坚果放价</a></li>
					<li><a href="#">缤纷果干</a></li>
					<li><a href="#">良品E卡</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="body">

		<div id="path">
			<a href="<%=path%>/IndexServlet">首页</a>
			<span>&gt;</span>
			<span>商品搜索</span>
		</div>

		<div id="condition">
			<ul id="conditionHead">
				<li class="conditionHeadStyle">商品搜索 </li>
				<li style="color:#555555;">共${goodsPage.totalRecord}个商品</li>
			</ul>
			<ul id="conditionList">
				<li><span>品牌：</span><a href="#">周记梁品铺子</a></li>
				<li><span>包装形式：</span><a href="#">散装</a><a href="#">散装</a></li>
				<li><span>产源：</span><a href="#">国产</a></li>
				<li><span>价格：</span><a href="#">9.9元以下</a></li>
			</ul>

			<ul id="sort">
				<li>排序：</li>
				<li><a href="#">综合排序</a></li>
				<li><a href="#">销量</a></li>
				<li><a href="#">价格</a></li>
				<li><a href="#">评分</a></li>
			</ul>
		</div>

		<div id="goodsList">
			<h1></h1>
			<div class="clear"></div>
			<div id="goodsListContent">
				<c:forEach items="${goodsPage.data}" var="gp">
					<div class="goodsInfo">
						<a href="<%=path%>/GoodsServlet?command=goodsInfo&goodsId=${gp.goodsId}"><img src="<%=path%>${gp.pictureUrl}" alt="hotsail"/></a>
						<h1><a href="<%=path%>/GoodsServlet?command=goodsInfo&goodsId=${gp.goodsId}">${gp.goodsName}</a></h1>
						<div class="clear"></div>
						<div><p>${gp.description}</p></div>
						<div><p>￥<span class="inline">${gp.price}</span></p></div>
						<div class="addCard"><a href="#">加入购物车</a></div>
						<span class="left blackColor">已售：${gp.sales}</span>
						<span class="right blackColor">评分：4.5</span>
					</div>
				
				</c:forEach>
			</div>

			<div id="page">
				<input type="hidden" value="<%=path%>/GoodsServlet?command=pageHandle&pageSize=${goodsPage.pageSize}&search=${search}"/>
				<a href="javascript:;">首页</a>
				<a href="javascript:;">上一页</a>
				<span class="greenColor" id="cur">${goodsPage.currentPage}</span>
				<span>/</span>
				<span class="whiteColor" id="pCout">${goodsPage.pageCount}</span>
				<a href="javascript:;">下一页</a>
				<input type="text" name="pageIndex" id="pageIndex"/>
				<a href="javascript:;">跳转</a>
				<a href="javascript:;">尾页</a>

			</div>
			
		</div>
	</div>
	<div id="footer">
				<div>
					<ul>
						<li><a href="#">关于我们</a></li>
						<li>|</li>
						<li><a href="#">联系我们</a></li>
						<li>|</li>
						<li><a href="#">客户服务</a></li>
						<li>|</li>
						<li><a href="#">诚聘英才</a></li>
						<li>|</li>
						<li><a href="#">商务合作</a></li>
						<li>|</li>
						<li><a href="#">媒体报道</a></li>
						<li>|</li>
						<li><a href="#">网站地图</a></li>
						<li>|</li>
						<li><a href="#">站长招募</a></li>
					</ul>
					<div id="copyRight">Copyright@2016-2116 周记梁品铺子电子商务有限公司 All rights Reserved</div>

				</div>
			</div>
</body>
</html>