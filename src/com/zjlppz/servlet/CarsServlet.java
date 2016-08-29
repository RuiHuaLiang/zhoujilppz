package com.zjlppz.servlet ;

import java.io.IOException ;
import java.io.PrintWriter ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import com.zjlppz.bean.Car ;
import com.zjlppz.services.CarsService ;

public class CarsServlet extends HttpServlet
{

	public void doGet ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		doPost ( request , response ) ;

	}

	public void doPost ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		request.setCharacterEncoding ( "utf-8" ) ;

		String command = request.getParameter ( "command" ) ;
		if ( "removeItem".equals ( command ) )
		{
			doRemoveItem ( request , response ) ;
		}
		else if ( "addToCar".equals ( command ) )
		{
			doAddToCar ( request , response ) ;
		}

	}

	/**
	 * 添加到购物车
	 * @param request
	 * @param response
	 */
	public void doAddToCar ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		Integer goodsId = Integer.parseInt ( request.getParameter ( "goodsId" ));
		Integer userId = Integer.parseInt (request.getParameter ( "userId" ));
		Integer goodsNumber = Integer.parseInt (request.getParameter ( "goodsNumber" ));
		
		Car car = new Car ( );
		car.setGoodsId ( goodsId );
		car.setUserId ( userId );
		car.setGoodsNum ( goodsNumber );
		
		CarsService carsService = new CarsService ( ) ;
		int result = carsService.addTocar ( car );
		
		
		try
		{
			PrintWriter out  = response.getWriter ( ) ;
			out.print ( result );
			out.flush ( );
			
		} catch ( IOException e )
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 移出购物车
	 * 
	 * @param request
	 * @param response
	 */
	public void doRemoveItem ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		Integer carId = ("".equals ( request.getParameter ( "carId" ) )) ? null : Integer.parseInt ( request.getParameter ( "carId" ) );
		Integer goodsId = Integer.parseInt ( request.getParameter ( "goodsId" ) ) ;
		Integer userId = Integer.parseInt ( request.getParameter ( "userId" ) ) ;

		Car car = new Car ( ) ;
		car.setCarId ( carId ) ;
		car.setGoodsId ( goodsId ) ;
		car.setUserId ( userId ) ;

		CarsService carsService = new CarsService ( ) ;

		try
		{
			int result = carsService.deleteCarItem ( car ) ;

			PrintWriter out = response.getWriter ( ) ;
			out.print ( result ) ;
			out.flush ( ) ;

		} catch ( IOException e )
		{
			e.printStackTrace ( ) ;
		}

	}

}
