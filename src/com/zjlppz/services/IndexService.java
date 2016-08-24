package com.zjlppz.services ;

import java.util.ArrayList ;
import java.util.List ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.Category ;
import com.zjlppz.bean.Goods ;
import com.zjlppz.bean.User ;
import com.zjlppz.bean.viewbean.CategoryGoods ;
import com.zjlppz.dao.CarDaoImpl ;
import com.zjlppz.dao.CategoryDaoImpl ;
import com.zjlppz.dao.GoodsDaoImpl ;
import com.zjlppz.util.PageUtil ;

/**
 * 首页初始化业务逻辑类
 * 
 * @author liangruihua
 * 
 */
public class IndexService
{
	CarDaoImpl carDao = new CarDaoImpl ( ) ;
	CategoryDaoImpl categoryDao = new CategoryDaoImpl ( ) ;
	GoodsDaoImpl goodsDao = new GoodsDaoImpl ( ) ;

	/**
	 * 获取购物车的商品数
	 * 
	 * @param user
	 *            用户对象
	 * @return 商品数
	 * @throws Exception
	 */
	public List < Car > getCarItemsCount ( User user ) throws Exception
	{
		return carDao.getUserCars ( user ) ;
	}

	/**
	 * 获取商品类别
	 * 
	 * @param parentId
	 *            商品类别Id
	 * @return
	 * @throws Exception
	 */
	public List < Category > getCategory ( Integer parentId ) throws Exception
	{
		return categoryDao.getCategory ( parentId ) ;
	}

	/**
	 * 根据类别Id分页获取，响应类别下的商品
	 * 
	 * @param parentId
	 *            父类别Id
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页容量
	 * @return 返回类别及其下的当前页的商品
	 * @throws Exception
	 */
	public List < CategoryGoods > getCategoryGoods ( Integer parentId ,
			int currentPage , int pageSize ) throws Exception
	{
		List < Category > categorys = categoryDao.getCategory ( parentId ) ;
		List < Category > secondCategorys = categoryDao.getAllCategory ( ) ;

		List < CategoryGoods > categoryGoodsList = new ArrayList < CategoryGoods > ( ) ;
		for ( Category category : categorys )
		{
			CategoryGoods cg = new CategoryGoods ( ) ;
			cg.setCategoryId ( category.getCategoryId ( ) ) ;
			cg.setParentId ( category.getParentId ( ) ) ;
			cg.setCategoryName ( category.getCategoryName ( ) ) ;
			List < Goods > goods = new ArrayList < Goods > ( ) ;
			for ( Category secondCategory : secondCategorys )
			{
				if ( secondCategory.getParentId ( ).equals (
						category.getCategoryId ( ) ) )
				{
					PageUtil < Goods > goodsPage = goodsDao
							.getGoodsByCategoryIdByPage (
									secondCategory.getCategoryId ( ) ,
									currentPage , pageSize ) ;
					goods.addAll ( goodsPage.getData ( ) ) ;
				}
			}
			cg.setCategoryGoods ( goods ) ;
			categoryGoodsList.add ( cg ) ;
		}
		return categoryGoodsList ;
	}

	/**
	 * 按条件进行分页查询
	 * 
	 * @param pagesize
	 *            页容量
	 * @param currentpage
	 *            当前页
	 * @param condt
	 *            查询条件
	 * @param orderflag
	 *            排序标志
	 * @return 返回当前页的商品信息
	 * @throws Exception 
	 */
	public PageUtil < Goods > getGoodsByPage ( int pagesize , int currentpage ,
			String condt , int orderflag ) throws Exception
	{
		return goodsDao.getGoodsByPage ( pagesize , currentpage , condt , orderflag );
	}

}
