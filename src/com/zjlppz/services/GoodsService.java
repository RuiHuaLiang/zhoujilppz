package com.zjlppz.services ;

import java.util.ArrayList ;
import java.util.List ;

import com.zjlppz.bean.Category ;
import com.zjlppz.bean.Goods ;
import com.zjlppz.bean.viewbean.CategoryGoods ;
import com.zjlppz.dao.CarDaoImpl ;
import com.zjlppz.dao.CategoryDaoImpl ;
import com.zjlppz.dao.GoodsDaoImpl ;
import com.zjlppz.util.PageUtil ;

/**
 * 与商品相关的业务逻辑类
 * 
 * @author liangruihua
 * 
 */
public class GoodsService
{
	CarDaoImpl carDao = new CarDaoImpl ( ) ;
	CategoryDaoImpl categoryDao = new CategoryDaoImpl ( ) ;
	GoodsDaoImpl goodsDao = new GoodsDaoImpl ( ) ;

	/**
	 * 根据商品Id查询商品的详细信息
	 * 
	 * @param goodsId
	 *            商品Id
	 * @return
	 */
	public  Goods  getGoodsInfoById ( Integer goodsId )
	{
		try
		{
			List<Goods> goodses =  goodsDao.getGoodsInfoById ( goodsId ) ;
			Goods goodsInfo = new Goods();
			for(Goods goods : goodses)
			{
				goodsInfo = goods;
			}
			return goodsInfo;
		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null ;
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
	 */
	public PageUtil < Goods > getGoodsByCategoryIdByPage ( Integer categoryId ,
			int currentPage , int pageSize )
	{
		try
		{
			return goodsDao.getGoodsByCategoryIdByPage ( categoryId ,
					currentPage , pageSize ) ;
		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null ;
	}

	/**
	 * 根据类别Id，分别获取该类别的子类别的分页商品信息
	 * 
	 * @param parentId
	 *            父类商品Id
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页容量
	 * @return
	 */
	public List < CategoryGoods > getCategoryGoods ( Integer parentId ,
			int currentPage , int pageSize )
	{
		List < CategoryGoods > categoryGoodses = new ArrayList < CategoryGoods > ( ) ;
		try
		{
			// 根据父级类别Id，得到子类别集合
			List < Category > categories = categoryDao.getCategory ( parentId ) ;

			for ( Category category : categories )
			{
				// 得到子类别商品的分页数据集合
				CategoryGoods categoryGoods = new CategoryGoods ( ) ;
				categoryGoods.setCategoryId ( category.getCategoryId ( ) ) ;
				categoryGoods.setCategoryName ( category.getCategoryName ( ) ) ;
				categoryGoods.setParentId ( category.getParentId ( ) ) ;

				PageUtil < Goods > pageCategoryGoods = getPageCategoryGoods (
						category.getCategoryId ( ) , currentPage , pageSize ) ;
				categoryGoods.setPageCategoryGoods ( pageCategoryGoods ) ;

				categoryGoodses.add ( categoryGoods ) ;
			}

			return categoryGoodses ;

		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null ;
	}

	/**
	 * 根据商品类别Id分页获取，该类别下的所有子类别的分页商品信息
	 * 
	 * @param categoryId
	 *            商品类别Id
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页容量
	 * @return 返回类别及其下的当前页的商品
	 * @throws Exception
	 */
	public PageUtil < Goods > getPageCategoryGoods ( Integer categoryId ,
			int currentPage , int pageSize )
	{
		try
		{
			return goodsDao.getGoodsByParentIdByPage ( categoryId ,
					currentPage , pageSize ) ;
		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null ;
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
		return goodsDao.getGoodsByPage ( pagesize , currentpage , condt ,
				orderflag ) ;
	}

}
