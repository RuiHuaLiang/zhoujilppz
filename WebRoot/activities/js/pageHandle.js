/**
 * Created by liangruihua on 2016/8/24.
 */
$(function(){
	var url = $("#page input:eq(0)").val();
	console.log(url);
	$("#page a:eq(0)").click(function(){
		$.get(url , {currentPage: "1"} , function(data){
			console.log(data.currentPage);
			$("#cur").html(data.currentPage);
			$("#pCout").html(data.pageCount);
			$.each(data.data , function(index , item){
				
			});
		},'json');
	});
});