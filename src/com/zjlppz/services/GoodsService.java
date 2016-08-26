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
 * ����Ʒ��ص�ҵ���߼���
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
	 * ������ƷId��ѯ��Ʒ����ϸ��Ϣ
	 * 
	 * @param goodsId
	 *            ��ƷId
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
	 * ������Ʒ���Id��ҳ��ѯ��Ʒ
	 * 
	 * @param categoryId
	 *            ��Ʒ���Id
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
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
	 * �������Id���ֱ��ȡ�����������ķ�ҳ��Ʒ��Ϣ
	 * 
	 * @param parentId
	 *            ������ƷId
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
	 * @return
	 */
	public List < CategoryGoods > getCategoryGoods ( Integer parentId ,
			int currentPage , int pageSize )
	{
		List < CategoryGoods > categoryGoodses = new ArrayList < CategoryGoods > ( ) ;
		try
		{
			// ���ݸ������Id���õ�����𼯺�
			List < Category > categories = categoryDao.getCategory ( parentId ) ;

			for ( Category category : categories )
			{
				// �õ��������Ʒ�ķ�ҳ���ݼ���
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
	 * ������Ʒ���Id��ҳ��ȡ��������µ����������ķ�ҳ��Ʒ��Ϣ
	 * 
	 * @param categoryId
	 *            ��Ʒ���Id
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
	 * @return ����������µĵ�ǰҳ����Ʒ
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
	 * ���������з�ҳ��ѯ
	 * 
	 * @param pagesize
	 *            ҳ����
	 * @param currentpage
	 *            ��ǰҳ
	 * @param condt
	 *            ��ѯ����
	 * @param orderflag
	 *            �����־
	 * @return ���ص�ǰҳ����Ʒ��Ϣ
	 * @throws Exception
	 */
	public PageUtil < Goods > getGoodsByPage ( int pagesize , int currentpage ,
			String condt , int orderflag ) throws Exception
	{
		return goodsDao.getGoodsByPage ( pagesize , currentpage , condt ,
				orderflag ) ;
	}

}
