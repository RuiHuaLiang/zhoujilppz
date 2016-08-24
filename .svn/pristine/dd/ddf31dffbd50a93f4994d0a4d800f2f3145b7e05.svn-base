/**
 * Created by liangruihua on 2016/8/15.
 */

var intervaId = 0;
var imgIndex = -1;
var speed = 3000;
//	图片轮播
function moveImg(index ){
	var strGt = "#bannerImg a img:gt("+index+")";
	var strLt = "#bannerImg a img:lt("+index+")";
	var strEq = "#bannerImg a img:eq("+index+")";
	$(strEq).fadeIn(speed/2);
	$(strGt).fadeOut(speed/2);
	$(strLt).fadeOut(speed/2);

	var numEq = ".number:eq("+index+")";
	var numGt = ".number:gt("+index+")";
	var numLt = ".number:lt("+index+")";
	$(numEq).css({
		background: "#705743"
	},speed/2);
	$(numGt).css({
		background: "#002535"
	},speed/2);
	$(numLt).css({
		background: "#002535"
	},speed/2);


}
$(function(){
	$("#shoppingCar").mouseenter(function(){
		$("#shoppingCarItem").css({
			display: "block"
		});
	});

	$("#shoppingCar").mouseleave(function(){
		$("#shoppingCarItem").css({
			display: "none"
		});
	});

	$("#info li:first ").mouseenter(function(){
		var urlPath = $("#info li a img").attr("src");
		$("#info li a img").attr("src",urlPath.replace('1','2'));
		$(this).css({
			"border": "1px solid #E7E7E7",
			"border-bottom": "1px solid white"
		});
		$("#info li:first >a").css({
			color:"#F14648"
		});
		//;
		$("#UserInfo").css({display: "block"});
	});
	$("#info li:first ").mouseleave(function(){
		var urlPath = $("#info li a img").attr("src");
		$("#info li a img").attr("src",urlPath.replace('2','1'));
		$(this).css({
			"border": "1px solid white",
			"border-bottom": "1px solid #E7E7E7"
		});
		$("#info li:first >a").css({
			color:"#555555"
		});
		$("#UserInfo").css({display: "none"});
	});

	//搜索框效果处理
	$("#searchText").focus(function(){

		if($(this).val().trim()=="商品关键字"){
			$(this).val("");
		}
	});
	$("#searchText").blur(function(){
		if($(this).val().trim()==""){
			$(this).val("商品关键字");
		}
	});




//	固定侧栏度化
	$("#rightToolBar ul li").mouseenter(function(){
		$(this).children("div").animate({
			right: "30px"
		},1000);
	});
	$("#rightToolBar ul li").mouseleave(function(){
		$(this).children("div").stop();
		$(this).children("div").animate({
			right: "-92px"
		},10);
	});

	//图片轮播的数字排放
	for(var i = 0 ; i < $(".number").length ; i ++)
	{
		var str = "#number" + (i + 1);
		var l = 250 + (i + 1) * 50;
		$(str).css({
			"left": l + "px"
		});
	}
	intervaId = setInterval(function () {
		imgIndex++;
		if(imgIndex > $(".number").length-1){
			imgIndex = 0;
		}
		moveImg(imgIndex);
	},speed);
	$(".number").mouseenter(function(){
		//alert($(this).html());
		imgIndex = $(this).html() -2;
		$(this).css({
			background: "#705743"
		});
	});
	$(".number").mouseleave(function(){
		//alert($(this).html());
		//imgIndex = $(this).html() -2;
		//$(this).css({
		//	background: "#002535"
		//});
	});


	//简版购物车表格处理
	$("#goodsItem tr:gt(0)").mouseover(function(){
		$(this).css({
			background: "#002535"
		});
	});

	$("#goodsItem tr:gt(0)").mouseleave(function(){
		$(this).css({
			background: "#0C1021"
		});
	});


});

