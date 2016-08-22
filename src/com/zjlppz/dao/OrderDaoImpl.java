package com.zjlppz.dao;

import java.sql.SQLException;
import java.util.List;

import com.zjlppz.bean.Goods;
import com.zjlppz.bean.Order;
import com.zjlppz.bean.User;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;

/**
 * @创建作者：周健
 * @创建时间：2016-8-20
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class OrderDaoImpl {
	
	/**
	 *	在做排序查询的时候，当orderflag = ORDER_DEFAULT 时<br/>
	 *		表示按默认方式排序
	 */
	public static final int ORDER_DEFAULT = 0;//按默认排序
	/**
	 *	在做排序查询的时候，当orderflag = ORDER_TIME_ASC 时<br/>
	 *		表示按时间升序排序
	 */
	public static final int ORDER_TIME_ASC = 1;//按时间升序
	/**
	 *	在做排序查询的时候，当orderflag = ORDER_TIME_DESC 时<br/>
	 *		表示按时间降序排序
	 */
	public static final int ORDER_TIME_DESC = 2;//按时间降序
	/**
	 *	在做排序查询的时候，当orderflag = ORDER_USERID_ASC 时<br/>
	 *		表示按用户id升序排序
	 */
	public static final int ORDER_USERID_ASC = 3;//按用户id升序
	/**
	 *	在做排序查询的时候，当orderflag = ORDER_USERID_DESC 时<br/>
	 *		表示按用户id降序排序
	 */
	public static final int ORDER_USERID_DESC = 4;//按用户id降序


	public int insertOrder(Order order) throws SQLException {
		//新增订单默认都为未支付状态。
		String sqlInsert = "insert into orders(orderid,userid, orderstate, ordertime,total,"+
			" consigneename, consigneeaddress,consigneephone) " +
			"values(TO_NUMBER(TO_CHAR(sysdate,'YYYYMMDDHHMISS'))*100000+ SEQ_ORDERSID.nextval,"+
			"?,0,sysdate,?,?,?,?)";
		int resnum = JDBCUtilTemplate.insert(sqlInsert, order.getUserId(),order.getTotal(),
				order.getConsigneeName(),order.getConsigneeAddress(),order.getConsigneePhone());
		return resnum;
	}
	
	public int updateOrder(Order order) throws SQLException{
		String sqlUpdate = "update orders set orderstate=? where orderid = ?";
		int resnum = JDBCUtilTemplate.update(sqlUpdate, order.getOrderState(),order.getOrderId());
		return resnum;
	}
	
	/**
	 * 查询用户最新插入到数据库中的订单
	 * @param user
	 * @return
	 */
	public Order getUserNewOrder(User user){
		String sql = "select * from orders where orderid=(select max(orderid) from orders where userid = ?)";
		List<Order> orders = null;
		try {
			orders = JDBCUtilTemplate.queryData(sql, Order.class, user.getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(orders!=null && orders.size()>0){
			return orders.get(0);
		}
		return null;
	}
	
	/**
	 *  订单模糊查询
	 * 
	 * @param pagesize 传入的每一页显示的数据条数<br/>
	 * 
	 * @param currentpage 所查询的当前页面的页数<br/>
	 * 
	 * @param condt 传入管理员搜索的查询条件 <br/>
	 * 		&nbsp&nbsp&nbsp	若传入的值为null，则查询出所有的订单。<br/>
	 * 		&nbsp&nbsp&nbsp	若传入的值不为null，
	 * 						则按照管理员搜索的条件（）来模糊查询。<br/>
	 * 
	 * @param orderstate 订单状态
	 * 			如果传入的值为：-1,则说明查询全部状态下的订单信息
	 * 			如果传入的值为：Order.ORDER_STATE_NOTPAY，则查询所有未支付的订单信息      
	 *          如果传入的值为：Order.ORDER_STATE_NOTSENDOUT，则查询所有未发货的订单信息  
	 *          如果传入的值为：Order.ORDER_STATE_NOTRECEIVE，则查询所有未收货的订单信息
	 *          如果传入的值为：Order.ORDER_STATE_RECEIVE，则查询所有已收货的订单信息
	 * 
	 * @param orderflag 传入管理员排序条件<br/>
	 * 		&nbsp&nbsp&nbsp	若传入的值为 OrderDaoImpl.ORDER_DEFAULT	----按默认排序<br/>
	 * 		&nbsp&nbsp&nbsp	若传入的值为 OrderDaoImpl.ORDER_TIME_ASC ----按时间升序 <br/>
	 * 		&nbsp&nbsp&nbsp	若传入的值为 OrderDaoImpl.ORDER_TIME_DESC ----按时间降序<br/>
	 *      &nbsp&nbsp&nbsp 若传入的值为 OrderDaoImpl.ORDER_USERID_ASC ----按用户id升序 <br/>
	 *   	&nbsp&nbsp&nbsp	若传入的值为 OrderDaoImpl.ORDER_USERID_DESC ----按用户id降序
	 *   
	 * @return pageutil <br/>
	 * 		&nbsp&nbsp&nbsp 返回的是查询出来的分页对象。
	 */
	public PageUtil<Order> queryOrdersByPage(int pagesize,int currentpage,int orderstate,String condt,int orderflag){
		String condition;
		if(condt==null){
			condition = "%"+"%";
		}else{
			condition = "%"+condt+"%";
		}
		String sql = "select orders.* from orders,users where orders.userid = users.userid " +
				"and consigneename like '%zhou%' or consigneeaddress like '?' " +
				"or orderid like '%20168%' " +
				"or (to_char(ordertime,'yyyy-MM-dd hh24:mi:ss')) like '%2016-08-20%'";
//		String sql = "select goods.*,parentid, categoryname from goods,categories " +
//				"where goodsname like ? or description like ? " +
//				"and categories.CATEGORYID = goods.categoryid ";
		PageUtil<Order> pageutil = null;
		switch (orderflag) {
		case ORDER_DEFAULT:
			break;
		case ORDER_TIME_ASC:
			sql = sql +"order by ordertime asc";
			break;
		case ORDER_TIME_DESC:
			sql = sql +"order by ordertime desc";
			break;
		case ORDER_USERID_ASC:
			sql = sql + "order by userid asc";
			break;
		case ORDER_USERID_DESC:
			sql = sql + "order by userid desc";
			break;
		default:
			break;
		}
//			pageutil = JDBCUtilTemplate.queryData(sql, Order.class,condition,condition);
//		return pageutil;
		return null;
	}
	
}
