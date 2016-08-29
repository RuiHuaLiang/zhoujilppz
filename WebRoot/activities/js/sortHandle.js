/**
 * Created by liangruihua on 2016/8/24.
 */

$(function(){
	path = $("#path").val().trim();
	var url = $("#page input:eq(0)").val().trim();
	
	//默认
	$("body").on('click','#sort li:eq(1)',function(){
		$(this).children().css({
			color:"red"
		});
		
		$(this).siblings("li").children().css({
			color:"black"
		});
		$(this).siblings("input").val("false");
		$("#default").val("true");
		
		var sort = $("#sort input[value='true']").attr("id").trim();
		$.get(url+"&sort="+sort , {currentPage: "1"} , function(data){
			iteration(data);
		},'json');
	});
	
	//销量
	$("body").on('click','#sort li:eq(2)',function(){
		$(this).children().css({
			color:"red"
		});
		$(this).siblings("li").children().css({
			color:"black"
		});
		
		$(this).siblings("input").val("false");
		$("#sales").val("true");
		
		var sort = $("#sort input[value='true']").attr("id").trim();
		$.get(url+"&sort="+sort , {currentPage: "1"} , function(data){
			iteration(data);
		},'json');
	});
	
	//价格
	$("body").on('click','#sort li:eq(3)',function(){
		$(this).children().css({
			color:"red"
		});
		$(this).siblings("li").children().css({
			color:"black"
		});
		
		$(this).siblings("input").val("false");
		$("#price").val("true");
		
		var sort = $("#sort input[value='true']").attr("id").trim();
		$.get(url+"&sort="+sort , {currentPage: "1"} , function(data){
			iteration(data);
		},'json');
	});
	
	
});



//function iteration(data){
//	$("#cur").html(data.currentPage);
//	$("#pCout").html(data.pageCount);
//	$("#goodsListContent").html("");
//	$.each(data.data , function(index , item){
//		var gHtml = $("#goodsListContent").html();
//		var contentItem = "<div class='goodsInfo'>" +
//			"<a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+item.goodsId+"'><img src='"+path+item.pictureUrl+"' alt='hotsail'/></a>" +
//			"<h1><a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+item.goodsId+"'>"+item.goodsName+"</a></h1>" +
//			"<div class='clear'></div>" +
//			"<div><p>"+item.description+"</p></div>" +
//			"<div><p>￥<span class='inline'>"+item.price+"</span></p></div>" +
//			"<div class='addCard'><a href='#'>加入购物车</a></div>" +
//			"<span class='left blackColor'>已售："+item.sales+"</span>" +
//			"<span class='right blackColor'>评分：4.5</span>" +
//		"</div>";
//		$("#goodsListContent").html(gHtml+contentItem);
//	});
//}