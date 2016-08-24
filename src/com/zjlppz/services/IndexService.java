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
 * ��ҳ��ʼ��ҵ���߼���
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
	 * ��ȡ���ﳵ����Ʒ��
	 * 
	 * @param user
	 *            �û�����
	 * @return ��Ʒ��
	 * @throws Exception
	 */
	public List < Car > getCarItemsCount ( User user ) throws Exception
	{
		return carDao.getUserCars ( user ) ;
	}

	/**
	 * ��ȡ��Ʒ���
	 * 
	 * @param parentId
	 *            ��Ʒ���Id
	 * @return
	 * @throws Exception
	 */
	public List < Category > getCategory ( Integer parentId ) throws Exception
	{
		return categoryDao.getCategory ( parentId ) ;
	}

	/**
	 * �������Id��ҳ��ȡ����Ӧ����µ���Ʒ
	 * 
	 * @param parentId
	 *            �����Id
	 * @param currentPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ҳ����
	 * @return ����������µĵ�ǰҳ����Ʒ
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
		return goodsDao.getGoodsByPage ( pagesize , currentpage , condt , orderflag );
	}

}
