package com.zjlppz.dao;

import java.sql.SQLException;
import java.util.List;

import com.zjlppz.bean.Order;
import com.zjlppz.bean.Orderitem;
import com.zjlppz.util.JDBCUtilTemplate;

public class OrderItemDaoImpl {

	public int insertOrderItem(Orderitem orderitem) throws SQLException{
		String sql = "insert into orderitem(itemid, orderid, goodsid, goodsnum, saleprice) " +
				"values(SEQ_ORDERITEMID.nextval,?,?,?,?)";
		int resnum = JDBCUtilTemplate.insert(sql, orderitem.getOrderId(),orderitem.getGoodsId(),
				orderitem.getGoodsNum(),orderitem.getSalePrice());
		return 0;
	}
	
	public List<Orderitem> getOrderItem(Order order) throws Exception{
		String sql = "select * from orderitem where orderid = ?";
		List<Orderitem> orderitems = JDBCUtilTemplate.queryData(sql, Orderitem.class, order.getOrderId());
		return orderitems;
	}
	
}
