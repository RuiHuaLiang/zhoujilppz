package com.zjlppz.services ;

import java.sql.SQLException ;
import java.util.List ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.User ;
import com.zjlppz.dao.CarDaoImpl ;

/**
 * �빺�ﳵ��ص�ҵ���߼���
 * 
 * @author liangruihua
 * 
 */
public class CarsService
{
	CarDaoImpl carDao = new CarDaoImpl ( ) ;

	/**
	 * ɾ�����ﳵ��¼
	 * 
	 * @param carId
	 *            ���ﳵ��¼Id
	 * @return ���ؽ��>0��ʾɾ���ɹ���<=0 ��ʾɾ��ʧ��
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
	 * ���빺�ﳵ
	 * 
	 * @param car
	 *            ���ﳵ����
	 * @return ���ؽ��>0��ʾ��ӳɹ���<=0 ��ʾ���ʧ��
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
	 * ���¹��ﳵ��Ʒ������
	 * 
	 * @param car
	 *            ���ﳵ����
	 * @return ���ؽ��>0��ʾ���³ɹ���<=0 ��ʾ����ʧ��
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
	 * ��չ��ﳵ
	 * 
	 * @param user
	 *            �û�����
	 * @return ���ؽ��>0��ʾ��ճɹ���<=0 ��ʾ���ʧ��
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
	 * ��ȡ���ﳵ����Ʒ
	 * 
	 * @param user
	 *            �û�����
	 * @return ��Ʒ��
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
