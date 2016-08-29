/**
 * Created by liangruihua on 2016/8/24.
 */


$(function(){
	path = $("#path").val().trim();
	userId = $("#userId").val().trim();
	url = $("#page input:eq(0)").val().trim();
	//首页
	$("body").on('click','#page a:eq(0)',function(){
		var sort = $("#sort input[value='true']").attr("id").trim();
		var currentPage = $("#cur").html().trim();
		if(parseInt(currentPage) > 1){
			$.get(url+"&sort="+sort , {currentPage: "1"} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//上一页
	$("body").on('click','#page a:eq(1)',function(){
		var sort = $("#sort input[value='true']").attr("id").trim();
		var currentPage = $("#cur").html().trim();
		if(parseInt(currentPage) > 1){
			$.get(url+"&sort="+sort , {currentPage: currentPage - 1} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//下一页
	$("body").on('click','#page a:eq(2)',function(){
		var sort = $("#sort input[value='true']").attr("id").trim();
		var currentPage = $("#cur").html().trim();
		var pageCount = $("#pCout").html().trim();
		if(parseInt(currentPage) < parseInt(pageCount)){
			$.get(url+"&sort="+sort , {currentPage: parseInt(currentPage) + 1} , function(data){
				iteration(data);
			},'json');
		}
	});
	
	//跳转
	$("body").on('click','#page a:eq(3)',function(){
		var pageCount = $("#pCout").html().trim();
		var pageIndex = $("#pageIndex").val().trim();
		var sort = $("#sort input[value='true']").attr("id").trim();
		if(parseInt(pageIndex) <= parseInt(pageCount ) && parseInt(pageIndex) >= 1){
			$.get(url+"&sort="+sort , {currentPage: pageIndex} , function(data){
				iteration(data);
			},'json');
		}else{
			alert("错误的页码！页码范围：1~"+pageCount);
		}
	});
	
	
	//尾页
	$("body").on('click','#page a:eq(4)',function(){
		var sort = $("#sort input[value='true']").attr("id").trim();
		var currentPage = $("#cur").html().trim();
		var pageCount = $("#pCout").html().trim();
		if(parseInt(currentPage) < parseInt(pageCount)){
			$.get(url+"&sort="+sort , {currentPage: parseInt(pageCount)} , function(data){
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
			"<div class='addCard'>" +
				"<a href='javascript:;' class='addToCar'>加入购物车</a>" +
				"<input type='hidden' value='"+path+"/CarsServlet?command=addToCar&goodsId="+item.goodsId+"&userId="+userId+"&goodsNumber=1'/>" +
				"<input type='hidden' value='"+item.goodsId+"'/>" +
				"<input type='hidden' value='"+path+item.pictureUrl+"'/>" +
				"<input type='hidden' value='"+item.goodsName+"'/>" +
				"<input type='hidden' value='1'/>" +
				"<input type='hidden' value='"+item.price+"'/>" +
				"<input type='hidden' value='"+userId+"'/>" +
			"</div>" +
			"<span class='left blackColor'>已售："+item.sales+"</span>" +
			"<span class='right blackColor'>评分：4.5</span>" +
		"</div>";
	
		
		$("#goodsListContent").html(gHtml+contentItem);
	});
}