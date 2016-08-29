/**
 * Created by liangruihua on 2016/8/28.
 */

$(function() {
	path = $("#path").val().trim();
	userId = $("#userId").val().trim();

	$("body").on('click','.deleteCarItem',function() {
		var thisLink = $(this);

		if (confirm("确定要移出购物车吗？")) {
			var car = $(this).siblings("input").val();
			var cars = car.split(":");
			
			var goodsNum = cars[3];
			var goodsPrice = cars[4];
			
			// alert(carId);
			$.post(path + "/CarsServlet", {
				command : "removeItem",
				carId : cars[0].trim(),
				goodsId : cars[1].trim(),
				userId : cars[2].trim()
			}, function(data) {
				var result = parseInt(data);
				if (result > 0) {
					thisLink.parent().parent().remove();
					var sum = parseInt($("#carItemSize").html().trim());
					$("#carItemSize").html(sum - 1);
					$("#carSize").html(sum - 1);
					
					var newNum = parseInt($("#goodsItemNum").html().trim())-parseInt(goodsNum);
					$("#goodsItemNum").html(newNum);
					
					var newCount = parseInt($("#goodsCount").html().trim())-(parseInt(goodsNum)*parseInt(goodsPrice));
					$("#goodsCount").html(newCount);
					
					
					alert("成功移出购物车！");
				}
			}, 'text');
		}
	});

	$("body").on('click','.addToCar',function() {
		var thisCar = $(this);
		var addUrl = $(this).siblings("input:eq(0)").val();
		$.get(addUrl, {}, function(data) {
			if (parseInt(data) > 0) {
				var sum = parseInt($("#carItemSize").html().trim());
				$("#carItemSize").html(sum + 1);
				$("#carSize").html(sum + 1);
				
				//收集数据
				var goodsId = thisCar.siblings("input:eq(1)").val().trim();
				var pictureUrl = thisCar.siblings("input:eq(2)").val().trim();
				var goodsName = thisCar.siblings("input:eq(3)").val().trim();
				var goodsNumber = thisCar.siblings("input:eq(4)").val().trim();
				var price = thisCar.siblings("input:eq(5)").val().trim();
				var userId = thisCar.siblings("input:eq(6)").val().trim();
				
				//追加字符串
				var str = "<tr>" +
						"<th><a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+goodsId+"'><img src='"+pictureUrl+"' alt='decount'/></a></th>" +
							"<th><a href='"+path+"/GoodsServlet?command=goodsInfo&goodsId="+goodsId+"'>"+goodsName+"</a></th>" +
							"<th><span class='redColor inline'>"+goodsNumber+"</span></th>" +
							"<th><span class='redColor inline'>￥"+price+"</span></th>" +
							"<th><input type='hidden' value=' :"+goodsId+":"+userId+"'/><a href='javascript:;' class='deleteCarItem'>移除</a></th>" +
						"</tr>";
				$("#goodsItem").append(str);
				
				
				var newNum = parseInt(goodsNumber) + parseInt($("#goodsItemNum").html());
				$("#goodsItemNum").html(newNum);
				
				var newCount = parseInt(goodsNumber*price) + parseInt($("#goodsCount").html());
				$("#goodsCount").html(newCount);
				
			}
		}, "text");
	});

});