package com.zjlppz.dao ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Goods ;
import com.zjlppz.util.JDBCUtilTemplate ;
import com.zjlppz.util.PageUtil ;

/**
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-17
 * @�����汾��1.0
 * 
 * @�޸��ߣ�����
 * @�޸İ汾��1.1
 * @�޸�ʱ�䣺2016-8-25
 * @�޸���������Ӱ�����Ʒһ������ѯ��Ʒ��
 * @��ʷ�汾��1.0
 */
public class GoodsDaoImpl
{

	/**
	 * ���������ѯ��ʱ�򣬵�orderflag = ORDER_DEFAULT ʱ<br/>
	 * ��ʾ��Ĭ�Ϸ�ʽ����
	 */
	public static final int ORDER_DEFAULT = 0 ;// ��Ĭ������
	/**
	 * ���������ѯ��ʱ�򣬵�orderflag = ORDER_PRICE_ASC ʱ<br/>
	 * ��ʾ���۸���������
	 */
	public static final int ORDER_PRICE_ASC = 1 ;// ���۸�����
	/**
	 * ���������ѯ��ʱ�򣬵�orderflag = ORDER_PRICE_DESC ʱ<br/>
	 * ��ʾ���۸�������
	 */
	public static final int ORDER_PRICE_DESC = 2 ;// ���۸���
	/**
	 * ���������ѯ��ʱ�򣬵�orderflag = ORDER_SALES_ASC ʱ<br/>
	 * ��ʾ��������������
	 */
	public static final int ORDER_SALES_ASC = 3 ;// ����������
	/**
	 * ���������ѯ��ʱ�򣬵�orderflag = ORDER_SALES_DESC ʱ<br/>
	 * ��ʾ��������������
	 */
	public static final int ORDER_SALES_DESC = 4 ;// ����������

	/**
	 * ��������Ʒ��Ϣ�ķ���
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp&nbsp&nbsp��Ҫ�������Ʒ����
	 * @return ����1�����ʾ����ɹ���
	 * @throws SQLException
	 */
	public int saveGoods ( Goods goods ) throws SQLException
	{
		String sql = "insert into goods(goodsid, categoryid, goodsname, storenumber,"
				+ " price, description, pictureurl, sales, discount)"
				+ "values(seq_goodsid.nextval,?,?,?,?,?,?,?,?)" ;
		int resnum = JDBCUtilTemplate.insert ( sql , goods.getCategoryId ( ) ,
				goods.getGoodsName ( ) , goods.getStoreNumber ( ) ,
				goods.getPrice ( ) , goods.getDescription ( ) ,
				goods.getPictureUrl ( ) , goods.getSales ( ) ,
				goods.getDiscount ( ) ) ;
		return resnum ;
	}

	/**
	 * ������Ʒidɾ����Ʒ��Ϣ�ķ�����
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp &nbsp &nbsp��Ҫɾ������Ʒ����
	 * 
	 * @return ����1�����ʾɾ���ɹ���
	 * @throws SQLException
	 */
	public int deleteGoods ( Goods goods ) throws SQLException
	{
		String sql = "delete from goods where goodsid = ?" ;
		int resnum = JDBCUtilTemplate.delete ( sql , goods.getGoodsId ( ) ) ;
		return resnum ;
	}

	/**
	 * ������Ʒid�޸���Ʒ��Ϣ�ķ�����
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp&nbsp&nbsp ��Ҫ�޸ĵ���Ʒ��
	 * 
	 * @return ����1�����ʾ�޸ĳɹ���
	 * @throws SQLException
	 */
	public int updateGoods ( Goods goods ) throws SQLException
	{
		String sql = "update goods set categoryid=?, goodsname=?, storenumber=?,"
				+ " price=?, description=?, pictureurl=?, sales=?, discount=? where goodsid = ?" ;
		int resnum = JDBCUtilTemplate.update ( sql , goods.getCategoryId ( ) ,
				goods.getGoodsName ( ) , goods.getStoreNumber ( ) ,
				goods.getPrice ( ) , goods.getDescription ( ) ,
				goods.getPictureUrl ( ) , goods.getSales ( ) ,
				goods.getDiscount ( ) , goods.getGoodsId ( ) ) ;
		return resnum ;
	}

	/**
	 * @param condt
	 *            �����û������Ĳ�ѯ���� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪnull�����ѯ�����е���Ʒ��<br/>
	 *            &nbsp&nbsp&nbsp �������ֵ��Ϊnull��������Ʒ������������ģ����ѯ��<br/>
	 * 
	 * @param orderflag
	 *            �����û���������<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪ GoodsDaoImpl.ORDER_DEFAULT ----��Ĭ������<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪ GoodsDaoImpl.ORDER_PRICE_ASC ----���۸����� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪ GoodsDaoImpl.ORDER_PRICE_DESC ----���۸���<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪ GoodsDaoImpl.ORDER_SALES_ASC ----���������� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪ GoodsDaoImpl.ORDER_SALES_DESC ----����������
	 * 
	 * @return goodses <br/>
	 *         &nbsp&nbsp&nbsp ���ص��ǲ�ѯ��������Ʒ�ļ���
	 * @throws Exception
	 */
	public List < Goods > queryAllGoods ( String condt , int orderflag )
			throws Exception
	{
		String condition ;
		if ( condt == null )
		{
			condition = "%" + "%" ;
		} else
		{
			condition = "%" + condt + "%" ;
		}
		String sql = "select goods.*,parentid, categoryname from goods,categories where goodsname like ? or description like ? and categories.CATEGORYID = goods.categoryid " ;
		List < Goods > goodses = null ;
		switch ( orderflag )
		{
		case ORDER_DEFAULT :
			break ;
		case ORDER_PRICE_ASC :
			sql = sql + "order by price asc" ;
			break ;
		case ORDER_PRICE_DESC :
			sql = sql + "order by price desc" ;
			break ;
		case ORDER_SALES_ASC :
			sql = sql + "order by sales asc" ;
			break ;
		case ORDER_SALES_DESC :
			sql = sql + "order by sales desc" ;
			break ;
		default :
			break ;
		}
		goodses = JDBCUtilTemplate.queryData ( sql , Goods.class , condition ,
				condition ) ;
		return goodses ;
	}

	/**
	 * ���������з�ҳ��ѯ
	 * 
	 * @param pagesize
	 *            �û������ÿһҳ��ʾ����������<br/>
	 * 
	 * @param currentpage
	 *            �û�����ѯ�ĵ�ǰҳ���ҳ��<br/>
	 * 
	 * @param condt
	 *            �����û������Ĳ�ѯ���� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪnull�����ѯ�����е���Ʒ��<br/>
	 *            &nbsp&nbsp&nbsp �������ֵ��Ϊnull��������Ʒ������������ģ����ѯ��<br/>
	 * 
	 * @param orderflag
	 *            �����û���������<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪGoodsDaoImpl.ORDER_DEFAULT----��Ĭ������<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪGoodsDaoImpl.ORDER_PRICE_ASC----���۸����� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪGoodsDaoImpl.ORDER_PRICE_DESC----���۸���<br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪGoodsDaoImpl.ORDER_SALES_ASC----���������� <br/>
	 *            &nbsp&nbsp&nbsp �������ֵΪGoodsDaoImpl.ORDER_SALES_DESC----����������
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageUtil < Goods > getGoodsByPage ( int pagesize , int currentpage ,
			String condt , int orderflag ) throws Exception
	{
		String condition ;
		if ( condt == null )
		{
			condition = "%" + "%" ;
		} else
		{
			condition = "%" + condt + "%" ;
		}
		String sql = "select goods.*,parentid, categoryname from goods,categories where goodsname like ? or description like ? and categories.categoryid = goods.categoryid " ;

		switch ( orderflag )
		{
		case ORDER_DEFAULT :
			break ;
		case ORDER_PRICE_ASC :
			sql = sql + "order by price asc" ;
			break ;
		case ORDER_PRICE_DESC :
			sql = sql + "order by price desc" ;
			break ;
		case ORDER_SALES_ASC :
			sql = sql + "order by sales asc" ;
			break ;
		case ORDER_SALES_DESC :
			sql = sql + "order by sales desc" ;
			break ;
		default :
			break ;
		}
		PageUtil < Goods > pageutil = null ;
		pageutil = JDBCUtilTemplate.queryDataByPage ( sql , new String [ ] {
				condition , condition } , currentpage , pagesize , Goods.class ) ;
		return pageutil ;
	}

	/**
	 * ��ҳ��һ�����Id��ѯ��Ʒ
	 * 
	 * @param parentId
	 *            һ����Ʒ���Id
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
	 * @return ����ÿһҳ����Ʒ��Ϣ
	 * @throws Exception
	 * 
	 */
	public PageUtil < Goods > getGoodsByParentIdByPage ( Integer parentId ,
			int currentPage , int pageSize , int orderflag) throws Exception
	{
		String sql = "select * from goods where categoryid in(select categoryid from categories where parentid = ?)  " ;
		sql = concatSqlString ( sql , orderflag );
		return JDBCUtilTemplate.queryDataByPage ( sql ,
				new Object [ ] { parentId } , currentPage , pageSize ,
				Goods.class ) ;
	}

	/**
	 * ������Ʒ���Id��ҳ��ѯ��Ʒ
	 * 
	 * @param categoryId
	 *            ��Ʒ���Id
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
	 * @return
	 * @throws Exception
	 */
	public PageUtil < Goods > getGoodsByCategoryIdByPage ( Integer categoryId ,
			int currentPage , int pageSize , int orderflag ) throws Exception
	{
		String sql = "select * from goods where categoryid = ?  " ;
		sql = concatSqlString ( sql , orderflag );

		return JDBCUtilTemplate.queryDataByPage ( sql ,
				new Object [ ] { categoryId } , currentPage , pageSize ,
				Goods.class ) ;
	}

	/**
	 * ������ƷId��ѯ��Ʒ��ϸ��Ϣ
	 * 
	 * @param goodsId
	 *            ��ƷId
	 * @return
	 * @throws Exception
	 */
	public List < Goods > getGoodsInfoById ( Integer goodsId ) throws Exception
	{
		String sql = "select goods.*,parentid, categoryname from goods,categories where goods.goodsid = ? and categories.categoryid = goods.categoryid" ;
		return JDBCUtilTemplate.queryData ( sql , Goods.class , goodsId ) ;
	}

	/**
	 * ��������ƴ��sql��䣬��ʹ�ò�ͬ���ֶν�������
	 * 
	 * @param sql
	 *            sql ���
	 * @param orderflag
	 *            �����־
	 * @return
	 */
	public String concatSqlString ( String sql , int orderflag )
	{
		switch ( orderflag )
		{
		case ORDER_DEFAULT :
			break ;
		case ORDER_PRICE_ASC :
			sql = sql + "order by price asc" ;
			break ;
		case ORDER_PRICE_DESC :
			sql = sql + "order by price desc" ;
			break ;
		case ORDER_SALES_ASC :
			sql = sql + "order by sales asc" ;
			break ;
		case ORDER_SALES_DESC :
			sql = sql + "order by sales desc" ;
			break ;
		default :
			break ;
		}
		return sql ;
	}

}
