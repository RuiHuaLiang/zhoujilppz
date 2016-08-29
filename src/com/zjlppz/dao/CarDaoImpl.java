package com.zjlppz.dao ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.User ;
import com.zjlppz.util.JDBCUtilTemplate ;

/**
 * 购物车数据库操作类
 * 
 * @创建作者：周健
 * @创建时间：2016-8-19
 * @创建版本：1.0
 * 
 * @修改者：梁瑞华
 * @修改版本：1.0
 * @修改时间： 2016-08-28
 * @修改描述：添加根据购物车Id删除记录的方法
 * @历史版本：
 */
public class CarDaoImpl
{

	/**
	 * 为用户购物车中插入新的数据 插入该用户新的购物车数据
	 * 
	 * @param car
	 * @return 1 返回1表示插入成功
	 * @throws SQLException
	 */
	public int savecar ( Car car ) throws SQLException
	{

		String sqlinsert = "insert into cars(carid,userid,goodsid,goodsnum)"
				+ " values(SEQ_CARSID.nextval,?,?,?)" ;
		int resNum = JDBCUtilTemplate.insert ( sqlinsert , car.getUserId ( ) ,
				car.getGoodsId ( ) , car.getGoodsNum ( ) ) ;
		return resNum ;
	}

	/**
	 * 删除该用户购物车中某条商品信息
	 * 
	 * @param car
	 * @return
	 * @throws SQLException
	 */
	public int deletCar ( Car car ) throws SQLException
	{
		String sqldelete = "delete  from cars where userid = ? and goodsid = ?" ;
		int resNum = JDBCUtilTemplate.delete ( sqldelete , car.getUserId ( ) ,
				car.getGoodsId ( ) ) ;
		return resNum ;
	}

	/**
	 * 删除用户购物车中所有的商品信息
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int deletAllCar ( User user ) throws SQLException
	{
		String sqlDelete = "delete from cars where userid = ?" ;
		int resNum = JDBCUtilTemplate.delete ( sqlDelete , user.getUserId ( ) ) ;
		return resNum ;
	}

	/**
	 * 修改用户购物车中该商品信息（即修改数量）
	 * 
	 * @param car
	 * @return
	 * @throws SQLException
	 */
	public int updateCar ( Car car ) throws SQLException
	{
		String sqlUpdate = "update cars set goodsnum = ? where userid = ? and goodsid = ?" ;
		int resNum = JDBCUtilTemplate.update ( sqlUpdate , car.getGoodsNum ( ) ,
				car.getUserId ( ) , car.getGoodsId ( ) ) ;
		return resNum ;
	}

	/**
	 * 获取用户的购物车信息
	 * 
	 * @param user
	 * @return List<Car> cars
	 * @throws Exception
	 */
	public List < Car > getUserCars ( User user ) throws Exception
	{
		String sqlcount = "select cars.*,goods.price goodsprice,goodsname,pictureurl "
				+ "from cars,goods where userid = ? and cars.goodsid = goods.goodsid" ;
		List < Car > cars = null ;
		cars = JDBCUtilTemplate.queryData ( sqlcount , Car.class ,
				user.getUserId ( ) ) ;
		return cars ;
	}

	/**
	 * 根据CarId删除购物车记录
	 * 
	 * @param carId
	 *            购物车记录Id
	 * @return 返回结果>0表示删除成功，<=0 表示删除失败
	 * @throws SQLException
	 */
	public int deleteCarItemByCasrId ( Integer carId ) throws SQLException
	{
		String sql = "delete cars where carid = ?" ;
		return JDBCUtilTemplate.delete ( sql , carId ) ;
	}
}
