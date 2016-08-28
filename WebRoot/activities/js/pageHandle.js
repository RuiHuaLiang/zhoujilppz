/**
 * Created by liangruihua on 2016/8/24.
 */

$(function(){
	path = $("#path").val().trim();
	var sort = $("#sort input[value='true']").attr("id").trim();
	var url = $("#page input:eq(0)").val().trim()+"sort="+sort;
	//首页
	$("#page a:eq(0)").click(function(){
		$("#pageIndex").val("");
		var currentPage = $("#cur").html().trim();
		if(parseInt(currentPage) > 1){
			$.get(url , {currentPage: "1"} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//上一页
	$("#page a:eq(1)").click(function(){
		$("#pageIndex").val("");
		var currentPage = $("#cur").html().trim();
		if(parseInt(currentPage) > 1){
			$.get(url , {currentPage: currentPage - 1} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//下一页
	$("#page a:eq(2)").click(function(){
		$("#pageIndex").val("");
		var currentPage = $("#cur").html().trim();
		var pageCount = $("#pCout").html().trim();
		if(parseInt(currentPage) < parseInt(pageCount)){
			$.get(url , {currentPage: parseInt(currentPage) + 1} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//跳转
	$("#page a:eq(3)").click(function(){
		var pageCount = $("#pCout").html().trim();
		var pageIndex = $("#pageIndex").val().trim();
		if(parseInt(pageIndex) <= parseInt(pageCount ) && parseInt(pageIndex) >= 1){
			$.get(url , {currentPage: pageIndex} , function(data){
				iteration(data);
			},'json');
		}else{
			alert("错误的页码！页码范围：1~"+pageCount);
		}
	});
	
	
	//尾页
	$("#page a:eq(4)").click(function(){
		$("#pageIndex").val("");
		var currentPage = $("#cur").html().trim();
		var pageCount = $("#pCout").html().trim();
		if(parseInt(currentPage) < parseInt(pageCount)){
			$.get(url , {currentPage: parseInt(pageCount)} , function(data){
				iteration(data);
			},'json');
		}
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