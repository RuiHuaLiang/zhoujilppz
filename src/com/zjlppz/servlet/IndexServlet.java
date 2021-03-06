package com.zjlppz.servlet;

import java.io.IOException ;
import java.io.PrintWriter ;
import java.util.List ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import javax.servlet.http.HttpSession ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.Category ;
import com.zjlppz.bean.User ;
import com.zjlppz.bean.viewbean.CategoryGoods ;
import com.zjlppz.services.CarsService ;
import com.zjlppz.services.GoodsService ;
import com.zjlppz.services.IndexService ;

public class IndexServlet extends HttpServlet
{

	
	
	public void doGet ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		doPost ( request , response );
	
	}

	
	public void doPost ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		HttpSession session = request.getSession ( );
		User user = new User();
		user.setUserId ( 1 );
		user.setUserName ( "xiaoliang" );
		
		session.setAttribute ( "user" , user);
		IndexService indexService = new IndexService ( );
		GoodsService goodsService = new GoodsService();
		CarsService carsService = new CarsService ( );
		
		List < Car > carItems ;
		try
		{
			Object sessionUser = request.getSession ( ).getAttribute ( "user" );
			User sUser = null;
			if(sessionUser != null)
			{
				sUser = (User)sessionUser;
			}
			carItems = carsService.getCarItems ( sUser ) ;
//			System.out.println (carItems) ;
			
			request.setAttribute ( "carItems" , carItems );
			
			List<Category> categorys = indexService.getCategory ( null );
			request.setAttribute ( "categorys" , categorys );
			
			String sort = request.getParameter ( "sort" ) ;
			
			List<CategoryGoods> categoryGoods = goodsService.getCategoryGoods ( null , 1 , 5 , sort);
			request.setAttribute ( "categoryGoods" , categoryGoods );
			
		} catch ( Exception e )  
		{
			e.printStackTrace();
		}
		
		
		
		request.getRequestDispatcher ( "/activities/index.jsp" ).forward ( request , response );

	}

	
}
