/**
 * Created by liangruihua on 2016/8/21.
 */

$(function(){
	$("#catList>li").mouseenter(function(){
		var url = $(this).children(".displayNone").html();
		$.get(url , {command:"secondLevelMenu"} , function(data){
			$("#catList>li").children("ul").html("");
			$.each(data , function(index , item){
				$("#catList>li").children("ul").append("<li><a href='#"+item.categoryId+"'>"+item.categoryName+"</a></li>");
				
			});
		},'json');
	});
});