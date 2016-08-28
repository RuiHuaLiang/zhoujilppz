package com.zjlppz.dao ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Goods ;
import com.zjlppz.util.JDBCUtilTemplate ;
import com.zjlppz.util.PageUtil ;

/**
 * @创建作者：周健
 * @创建时间：2016-8-17
 * @创建版本：1.0
 * 
 * @修改者：梁瑞华
 * @修改版本：1.1
 * @修改时间：2016-8-25
 * @修改描述：添加按照商品一级类别查询商品类
 * @历史版本：1.0
 */
public class GoodsDaoImpl
{

	/**
	 * 在做排序查询的时候，当orderflag = ORDER_DEFAULT 时<br/>
	 * 表示按默认方式排序
	 */
	public static final int ORDER_DEFAULT = 0 ;// 按默认排序
	/**
	 * 在做排序查询的时候，当orderflag = ORDER_PRICE_ASC 时<br/>
	 * 表示按价格升序排序
	 */
	public static final int ORDER_PRICE_ASC = 1 ;// 按价格升序
	/**
	 * 在做排序查询的时候，当orderflag = ORDER_PRICE_DESC 时<br/>
	 * 表示按价格降序排序
	 */
	public static final int ORDER_PRICE_DESC = 2 ;// 按价格降序
	/**
	 * 在做排序查询的时候，当orderflag = ORDER_SALES_ASC 时<br/>
	 * 表示按销量升序排序
	 */
	public static final int ORDER_SALES_ASC = 3 ;// 按销量升序
	/**
	 * 在做排序查询的时候，当orderflag = ORDER_SALES_DESC 时<br/>
	 * 表示按销量降序排序
	 */
	public static final int ORDER_SALES_DESC = 4 ;// 按销量降序

	/**
	 * 保存新商品信息的方法
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp&nbsp&nbsp需要保存的商品对象
	 * @return 返回1，则表示保存成功。
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
	 * 根据商品id删除商品信息的方法。
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp &nbsp &nbsp需要删除的商品对象。
	 * 
	 * @return 返回1，则表示删除成功。
	 * @throws SQLException
	 */
	public int deleteGoods ( Goods goods ) throws SQLException
	{
		String sql = "delete from goods where goodsid = ?" ;
		int resnum = JDBCUtilTemplate.delete ( sql , goods.getGoodsId ( ) ) ;
		return resnum ;
	}

	/**
	 * 根据商品id修改商品信息的方法。
	 * 
	 * @param goods
	 * <br/>
	 *            &nbsp&nbsp&nbsp 需要修改的商品。
	 * 
	 * @return 返回1，则表示修改成功。
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
	 *            传入用户搜索的查询条件 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为null，则查询出所有的商品。<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值不为null，则按照商品名，和描述来模糊查询。<br/>
	 * 
	 * @param orderflag
	 *            传入用户排序条件<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为 GoodsDaoImpl.ORDER_DEFAULT ----按默认排序<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为 GoodsDaoImpl.ORDER_PRICE_ASC ----按价格升序 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为 GoodsDaoImpl.ORDER_PRICE_DESC ----按价格降序<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为 GoodsDaoImpl.ORDER_SALES_ASC ----按销量升序 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为 GoodsDaoImpl.ORDER_SALES_DESC ----按销量降序
	 * 
	 * @return goodses <br/>
	 *         &nbsp&nbsp&nbsp 返回的是查询出来的商品的集合
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
	 * 按条件进行分页查询
	 * 
	 * @param pagesize
	 *            用户传入的每一页显示的数据条数<br/>
	 * 
	 * @param currentpage
	 *            用户所查询的当前页面的页数<br/>
	 * 
	 * @param condt
	 *            传入用户搜索的查询条件 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为null，则查询出所有的商品。<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值不为null，则按照商品名，和描述来模糊查询。<br/>
	 * 
	 * @param orderflag
	 *            传入用户排序条件<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为GoodsDaoImpl.ORDER_DEFAULT----按默认排序<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为GoodsDaoImpl.ORDER_PRICE_ASC----按价格升序 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为GoodsDaoImpl.ORDER_PRICE_DESC----按价格降序<br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为GoodsDaoImpl.ORDER_SALES_ASC----按销量升序 <br/>
	 *            &nbsp&nbsp&nbsp 若传入的值为GoodsDaoImpl.ORDER_SALES_DESC----按销量降序
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
	 * 分页按一级类别Id查询商品
	 * 
	 * @param parentId
	 *            一级商品类别Id
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页容量
	 * @return 返回每一页的商品信息
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
	 * 根据商品类别Id分页查询商品
	 * 
	 * @param categoryId
	 *            商品类别Id
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页容量
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
	 * 根据商品Id查询商品详细信息
	 * 
	 * @param goodsId
	 *            商品Id
	 * @return
	 * @throws Exception
	 */
	public List < Goods > getGoodsInfoById ( Integer goodsId ) throws Exception
	{
		String sql = "select goods.*,parentid, categoryname from goods,categories where goods.goodsid = ? and categories.categoryid = goods.categoryid" ;
		return JDBCUtilTemplate.queryData ( sql , Goods.class , goodsId ) ;
	}

	/**
	 * 根据条件拼接sql语句，以使用不同的字段进行排序
	 * 
	 * @param sql
	 *            sql 语句
	 * @param orderflag
	 *            排序标志
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
