/**
 * Created by liangruihua on 2016/8/24.
 */

$(function(){
	path = $("#path").val().trim();
	var url = $("#page input:eq(0)").val().trim();
	
	//默认
	$("#sort li:eq(1)").click(function(){
		$(this).children().css({
			color:"red"
		});
		
		$(this).siblings("li").children().css({
			color:"black"
		});
		$(this).siblings("input").val("false");
		$("#default").val("true");
	});
	
	//销量
	$("#sort li:eq(2)").click(function(){
		$(this).children().css({
			color:"red"
		});
		$(this).siblings("li").children().css({
			color:"black"
		});
		
		$(this).siblings("input").val("false");
		$("#sales").val("true");
	});
	
	//价格
	$("#sort li:eq(3)").click(function(){
		$(this).children().css({
			color:"red"
		});
		$(this).siblings("li").children().css({
			color:"black"
		});
		
		$(this).siblings("input").val("false");
		$("#price").val("true");
	});
	
	
	
});



function iteration(data){
	$("#cur").html(data.currentPage);
	$("#pCout").html(data.pageCount);
	$("#goodsListContent").html("");
	$.each(data.data , function(index , item){
		var gHtml = $("#goodsListContent").html();
		var contentItem = "<div class='goodsInfo'>" +
			"<a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+item.goodsId+"'><img src='"+path+item.pictureUrl+"' alt='hotsail'/></a>" +
			"<h1><a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+item.goodsId+"'>"+item.goodsName+"</a></h1>" +
			"<div class='clear'></div>" +
			"<div><p>"+item.description+"</p></div>" +
			"<div><p>￥<span class='inline'>"+item.price+"</span></p></div>" +
			"<div class='addCard'><a href='#'>加入购物车</a></div>" +
			"<span class='left blackColor'>已售："+item.sales+"</span>" +
			"<span class='right blackColor'>评分：4.5</span>" +
		"</div>";
		$("#goodsListContent").html(gHtml+contentItem);
	});
}