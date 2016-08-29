package com.zjlppz.dao ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.User ;
import com.zjlppz.util.JDBCUtilTemplate ;

/**
 * ���ﳵ���ݿ������
 * 
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-19
 * @�����汾��1.0
 * 
 * @�޸��ߣ�����
 * @�޸İ汾��1.0
 * @�޸�ʱ�䣺 2016-08-28
 * @�޸���������Ӹ��ݹ��ﳵIdɾ����¼�ķ���
 * @��ʷ�汾��
 */
public class CarDaoImpl
{

	/**
	 * Ϊ�û����ﳵ�в����µ����� ������û��µĹ��ﳵ����
	 * 
	 * @param car
	 * @return 1 ����1��ʾ����ɹ�
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
	 * ɾ�����û����ﳵ��ĳ����Ʒ��Ϣ
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
	 * ɾ���û����ﳵ�����е���Ʒ��Ϣ
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
	 * �޸��û����ﳵ�и���Ʒ��Ϣ�����޸�������
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
	 * ��ȡ�û��Ĺ��ﳵ��Ϣ
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
	 * ����CarIdɾ�����ﳵ��¼
	 * 
	 * @param carId
	 *            ���ﳵ��¼Id
	 * @return ���ؽ��>0��ʾɾ���ɹ���<=0 ��ʾɾ��ʧ��
	 * @throws SQLException
	 */
	public int deleteCarItemByCasrId ( Integer carId ) throws SQLException
	{
		String sql = "delete cars where carid = ?" ;
		return JDBCUtilTemplate.delete ( sql , carId ) ;
	}
}
