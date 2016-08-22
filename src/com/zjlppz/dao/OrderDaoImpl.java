package com.zjlppz.dao;

import java.sql.SQLException;
import java.util.List;

import com.zjlppz.bean.Goods;
import com.zjlppz.bean.Order;
import com.zjlppz.bean.User;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;

/**
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-20
 * @�����汾��1.0
 * 
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
 */
public class OrderDaoImpl {
	
	/**
	 *	���������ѯ��ʱ�򣬵�orderflag = ORDER_DEFAULT ʱ<br/>
	 *		��ʾ��Ĭ�Ϸ�ʽ����
	 */
	public static final int ORDER_DEFAULT = 0;//��Ĭ������
	/**
	 *	���������ѯ��ʱ�򣬵�orderflag = ORDER_TIME_ASC ʱ<br/>
	 *		��ʾ��ʱ����������
	 */
	public static final int ORDER_TIME_ASC = 1;//��ʱ������
	/**
	 *	���������ѯ��ʱ�򣬵�orderflag = ORDER_TIME_DESC ʱ<br/>
	 *		��ʾ��ʱ�併������
	 */
	public static final int ORDER_TIME_DESC = 2;//��ʱ�併��
	/**
	 *	���������ѯ��ʱ�򣬵�orderflag = ORDER_USERID_ASC ʱ<br/>
	 *		��ʾ���û�id��������
	 */
	public static final int ORDER_USERID_ASC = 3;//���û�id����
	/**
	 *	���������ѯ��ʱ�򣬵�orderflag = ORDER_USERID_DESC ʱ<br/>
	 *		��ʾ���û�id��������
	 */
	public static final int ORDER_USERID_DESC = 4;//���û�id����


	public int insertOrder(Order order) throws SQLException {
		//��������Ĭ�϶�Ϊδ֧��״̬��
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
	 * ��ѯ�û����²��뵽���ݿ��еĶ���
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
	 *  ����ģ����ѯ
	 * 
	 * @param pagesize �����ÿһҳ��ʾ����������<br/>
	 * 
	 * @param currentpage ����ѯ�ĵ�ǰҳ���ҳ��<br/>
	 * 
	 * @param condt �������Ա�����Ĳ�ѯ���� <br/>
	 * 		&nbsp&nbsp&nbsp	�������ֵΪnull�����ѯ�����еĶ�����<br/>
	 * 		&nbsp&nbsp&nbsp	�������ֵ��Ϊnull��
	 * 						���չ���Ա����������������ģ����ѯ��<br/>
	 * 
	 * @param orderstate ����״̬
	 * 			��������ֵΪ��-1,��˵����ѯȫ��״̬�µĶ�����Ϣ
	 * 			��������ֵΪ��Order.ORDER_STATE_NOTPAY�����ѯ����δ֧���Ķ�����Ϣ      
	 *          ��������ֵΪ��Order.ORDER_STATE_NOTSENDOUT�����ѯ����δ�����Ķ�����Ϣ  
	 *          ��������ֵΪ��Order.ORDER_STATE_NOTRECEIVE�����ѯ����δ�ջ��Ķ�����Ϣ
	 *          ��������ֵΪ��Order.ORDER_STATE_RECEIVE�����ѯ�������ջ��Ķ�����Ϣ
	 * 
	 * @param orderflag �������Ա��������<br/>
	 * 		&nbsp&nbsp&nbsp	�������ֵΪ OrderDaoImpl.ORDER_DEFAULT	----��Ĭ������<br/>
	 * 		&nbsp&nbsp&nbsp	�������ֵΪ OrderDaoImpl.ORDER_TIME_ASC ----��ʱ������ <br/>
	 * 		&nbsp&nbsp&nbsp	�������ֵΪ OrderDaoImpl.ORDER_TIME_DESC ----��ʱ�併��<br/>
	 *      &nbsp&nbsp&nbsp �������ֵΪ OrderDaoImpl.ORDER_USERID_ASC ----���û�id���� <br/>
	 *   	&nbsp&nbsp&nbsp	�������ֵΪ OrderDaoImpl.ORDER_USERID_DESC ----���û�id����
	 *   
	 * @return pageutil <br/>
	 * 		&nbsp&nbsp&nbsp ���ص��ǲ�ѯ�����ķ�ҳ����
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
