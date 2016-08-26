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
	public List < Car > getCarItems ( User user ) throws Exception
	{
		if(user != null)
		{
			return carDao.getUserCars ( user ) ;
		}
		return null;
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

	

}
