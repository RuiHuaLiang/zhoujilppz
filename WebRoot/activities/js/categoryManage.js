/**
 * Created by liangruihua on 2016/8/21.
 */

$(function(){
	path = $("#path").val().trim();
	$("#catList>li").mouseenter(function(){
		var url = $(this).children(".displayNone").html();
		$.get(url , {command:"secondLevelMenu",sort:"default"} , function(data){
			$("#catList>li").children("ul").html("");
			$.each(data , function(index , item){
				$("#catList>li").children("ul").append("<li><a href='"+path+"/GoodsServlet?command=catGoods&categoryId="+item.categoryId+"&categoryName="+item.categoryName+"&currentPage=1&pageSize=16'>"+item.categoryName+"</a></li>");
			});
		},'json');
	});
});