/**
 * Created by liangruihua on 2016/8/21.
 */

$(function(){
	$("#catList>li").mouseenter(function(){
		var url = $(this).children(".displayNone").html();
		$.get(url , {command:"secondLevelMenu"} , function(data){
			$("#catList>li").children("ul").html("");
			$.each(data , function(index , item){
				//"categoryId":10,"parentId":1,"categoryName":"à¾¿Ç¼á¹û"
//				console.log("categoryId:"+item.categoryId +"parentId:"+item.parentId+"categoryName"+item.categoryName);
				$("#catList>li").children("ul").append("<li><a href='#"+item.categoryId+"'>"+item.categoryName+"</a></li>");
				
			});
		},'json');
	});
});