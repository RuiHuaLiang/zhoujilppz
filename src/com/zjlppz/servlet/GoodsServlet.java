package com.zjlppz.servlet ;

import java.io.IOException ;
import java.io.PrintWriter ;
import java.util.List ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import javax.servlet.http.HttpSession ;

import com.zjlppz.bean.Car ;
import com.zjlppz.bean.Goods ;
import com.zjlppz.bean.User ;
import com.zjlppz.dao.GoodsDaoImpl ;
import com.zjlppz.services.IndexService ;
import com.zjlppz.util.PageUtil ;

public class GoodsServlet extends HttpServlet
{

	public GoodsServlet ( )
	{
		super ( ) ;
	}

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
		if ( "search".equals ( command ) )
		{
			doSearch ( request , response ) ;
		}

	}

	public void doSearch ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		HttpSession session = request.getSession ( );
		
		IndexService indexService = new IndexService ( ) ;
		String search = request.getParameter ( "search" ) ;
//		System.out.println (search) ;
		request.setAttribute ( "search" , search );
		int pagesize = Integer.parseInt ( request.getParameter ( "pagesize" ) ) ;
		int currentpage = Integer.parseInt ( request
				.getParameter ( "currentpage" ) ) ;
		

		try
		{
			List < Car > carItems = indexService.getCarItemsCount ( (User)session.getAttribute ( "user" ) ) ;
			request.setAttribute ( "carItems" , carItems );
			
			PageUtil < Goods > goodsPage = indexService.getGoodsByPage (
					pagesize , currentpage , search ,
					GoodsDaoImpl.ORDER_DEFAULT ) ;
			request.setAttribute ( "goodsPage" , goodsPage );
			System.out.println (goodsPage) ;
			request.getRequestDispatcher ( "/activities/goodsList.jsp" ).forward ( request , response );
			
		} catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace ( ) ;
		}

	}

}
