/**
 * Created by liangruihua on 2016/8/25.
 */
$(function(){
	$("#smallImg ul li img").mouseenter(function(){
		var imgUrl = $(this).attr("src");
		$("#bigImg img").attr("src" , imgUrl);
	});

	//商品数量的加减处理
	$("#sub").click(function(){
		var num = $("#number").val();
		if(parseInt(num) >1) {
			$("#number").val(parseInt(num) - 1 );
		}
	});
	$("#add").click(function(){
		var num = $("#number").val();
		$("#number").val(parseInt(num) + 1 );
	});

	//显示和隐藏
	$("#detailHeader li a:eq(0)").click(function(){
		$("#introduce").css({
			display: "block"
		});
		$("#detailHeader li a").css({
			background: "#83878E"
		});
		$(this).css({
			background: "red"
		});
		$("#tips,#service").css({
			display: "none"
		});
	});
	$("#detailHeader li a:eq(1)").click(function(){
		$("#tips").css({
			display: "block"
		});
		$("#detailHeader li a").css({
			background: "#83878E"
		});
		$(this).css({
			background: "red"
		});
		$("#tips,#introduce,#service").css({
			display: "none"
		});
	});
	$("#detailHeader li a:eq(2)").click(function(){
		$("#tips").css({
			display: "block"
		});
		$("#detailHeader li a").css({
			background: "#83878E"
		});
		$(this).css({
			background: "red"
		});
		$("#introduce,#service").css({
			display: "none"
		});
	});
	$("#detailHeader li a:eq(3)").click(function(){
		$("#service").css({
			display: "block"
		});
		$("#detailHeader li a").css({
			background: "#83878E"
		});
		$(this).css({
			background: "red"
		});
		$("#introduce,#tips").css({
			display: "none"
		});
	});
});