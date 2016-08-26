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
	public List < Car > getCarItems ( User user ) throws Exception
	{
		if(user != null)
		{
			return carDao.getUserCars ( user ) ;
		}
		return null;
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

	

}
