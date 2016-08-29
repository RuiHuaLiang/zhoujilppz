package com.zjlppz.services ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.User ;
import com.zjlppz.dao.CarDaoImpl ;

/**
 * 与购物车相关的业务逻辑类
 * 
 * @author liangruihua
 * 
 */
public class CarsService
{
	CarDaoImpl carDao = new CarDaoImpl ( ) ;

	/**
	 * 删除购物车记录
	 * 
	 * @param carId
	 *            购物车记录Id
	 * @return 返回结果>0表示删除成功，<=0 表示删除失败
	 */
	public int deleteCarItem ( Car car )
	{
		try
		{
			if(car.getCarId ( ) != null)
			{
				return carDao.deleteCarItemByCasrId ( car.getCarId ( ) ) ;
			}
			else
			{
				return carDao.deletCar ( car );
			}

		} catch ( SQLException e )
		{
			e.printStackTrace ( ) ;
		}
		return - 1 ;
	}

	/**
	 * 加入购物车
	 * 
	 * @param car
	 *            购物车对象
	 * @return 返回结果>0表示添加成功，<=0 表示添加失败
	 */
	public int addTocar ( Car car )
	{
		try
		{
			return carDao.savecar ( car ) ;

		} catch ( SQLException e )
		{
			e.printStackTrace ( ) ;
		}
		return - 1 ;
	}

	/**
	 * 更新购物车商品的数量
	 * 
	 * @param car
	 *            购物车对象
	 * @return 返回结果>0表示更新成功，<=0 表示更新失败
	 */
	public int updateCarItemNumber ( Car car )
	{
		try
		{
			return carDao.updateCar ( car ) ;

		} catch ( SQLException e )
		{
			e.printStackTrace ( ) ;
		}
		return - 1 ;
	}

	/**
	 * 清空购物车
	 * 
	 * @param user
	 *            用户对象
	 * @return 返回结果>0表示清空成功，<=0 表示清空失败
	 */
	public int clearCar ( User user )
	{
		try
		{
			return carDao.deletAllCar ( user ) ;

		} catch ( SQLException e )
		{
			e.printStackTrace ( ) ;
		}
		return - 1 ;
	}

	/**
	 * 获取购物车的商品
	 * 
	 * @param user
	 *            用户对象
	 * @return 商品数
	 * @throws Exception
	 */
	public List < Car > getCarItems ( User user ) throws Exception
	{
		if ( user != null )
		{
			return carDao.getUserCars ( user ) ;
		}
		return null ;
	}

}
