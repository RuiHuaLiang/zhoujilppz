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
	<title>周记梁品铺子</title>
	<link rel="stylesheet" href="<%=path%>/activities/css/reset.css"/>
	<link rel="stylesheet" href="<%=path%>/activities/css/comment.css"/>
	<link rel="stylesheet" href="<%=path%>/activities/css/main.css"/>
	<script src="<%=path%>/activities/js/jquery-2.1.4.js"></script>
	<script src="<%=path%>/activities/js/main.js"></script>
	<script src="<%=path%>/activities/js/categoryManage.js"></script>
</head>
<body>
	<div id="rightToolBar">
		<ul>
			<li><a href="#">购物车</a><span class="circleRed">0</span></li>
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
					<li class="redAndUnderline"><a href="#">官方网站</a></li>
				</ul>
			</div>
		</div>

		<div id="logoAndSearch">
			<div>
				<div id="logo" class="left">
					<img src="<%=path%>/activities/img/logo.png" alt="logo"/>
				</div>

				<div id="shoppingCar">
					<a href="#" class="shoppingLineHeight">购物车</a>
					<span class="shoppingLineHeight">&gt;</span>
					<span class="shoppingLineHeight">${carItems.size()}</span>

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
									<th><a href="#"><img src="<%=path%>${item.pictureUrl}" alt="decount"/></a></th>
									<th><a href="#">${item.goodsName})</a></th>
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
							<input id="searchText" type="text" name="search" value="商品关键字"/>
							<input id="searchSubmit" type="button" value="搜&nbsp;&nbsp;索"/>
					</div>
				</div>


			</div>

		</div>

		<div id="navigation">
			<div>
				<div id="goodsListHead" class="left">
					<span class="left">商品分类</span>
					<img class="left" src="<%=path%>/activities/img/list1.png" alt="list"/>
				</div>

				<ul id="navigationList">
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
		<div id="banner">
			<div>
				<ul id="catList" class="left">
						
					<c:forEach items="${categorys}" var="categoryItem">
						<li><a href="#">${categoryItem.categoryName}</a>
							<span class="displayNone"><%=path%>/FrontCatogoryServlet?categoryId=${categoryItem.categoryId}</span>
							<ul>
							</ul>
						</li>
					</c:forEach>
				</ul>

				<div id="bannerImg">
					<a href="#"><div id="number1" class="numberBgcolor number" >1</div></a>
					<a href="#"><div id="number2" class="number">2</div></a>
					<a href="#"><div id="number3" class="number">3</div></a>
					<a href="#"><img src="<%=path%>/activities/img/bannerimg1.jpg" alt="bannner"/></a>
					<a href="#"><img class="hidden" src="<%=path%>/activities/img/bannerimg2.jpg" alt="bannner"/></a>
					<a href="#"><img class="hidden" src="<%=path%>/activities/img/bannerimg3.jpg" alt="bannner"/></a>
				</div>

				<div id="decount">
					<a href="#"><img src="<%=path%>/activities/img/decount1.jpg" alt="decount" title="立即秒杀"/></a>
					<a href="#"><img src="<%=path%>/activities/img/decount2.jpg" alt="decount" title="立即秒杀"/></a>
				</div>
			</div>
		</div>

		<div id="realBody">
			<c:forEach items="${categoryGoods}" var="catGoods">
				<div id=""  class="commentDiv">
					<h1 class="commentH1 left">${catGoods.categoryName}</h1>
					<h1 class="commentH1 right"><a href="#">more>></a></h1>
					<div class="clear"></div>
					
					<div class="listDiv">
						<c:forEach items="${catGoods.categoryGoods}" var="cg">
								<a href="#"><img src="<%=path%>${cg.pictureUrl}" alt="discount"/></a>
						</c:forEach>
					</div>
				
				</div>
			</c:forEach>

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