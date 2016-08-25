package com.zjlppz.servlet ;

import java.io.IOException ;
import java.io.PrintWriter ;
import java.util.List ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;
import javax.servlet.http.HttpSession ;

import com.google.gson.Gson ;
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
		} else if ( "pageHandle".equals ( command ) )
		{
			doPageHandle ( request , response ) ;
		}

	}

	public void doPageHandle ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		String search = request.getParameter ( "search" ) ;
		PageUtil < Goods > goodsPage = getPageGoods(request , response , search);
		
		Gson gson = new Gson();
		String goodsPageJsonString = gson.toJson ( goodsPage );
		System.out.println (goodsPageJsonString) ;
		PrintWriter out = response.getWriter (  );
		out.print ( goodsPageJsonString );
		out.flush ( );
	}

	public void doSearch ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		HttpSession session = request.getSession ( ) ;
		IndexService indexService = new IndexService ( ) ;
		List < Car > carItems;
		try
		{
			carItems  = indexService
					.getCarItems ( ( User ) session.getAttribute ( "user" ) ) ;
			request.setAttribute ( "carItems" , carItems ) ;
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		
		String search = request.getParameter ( "search" ) ;
		// System.out.println (search) ;
		request.setAttribute ( "search" , search ) ;
		
		PageUtil < Goods > goodsPage = getPageGoods(request , response , search);
		request.setAttribute ( "goodsPage" , goodsPage ) ;
		System.out.println ( goodsPage ) ;
		
		request.getRequestDispatcher ( "/activities/searchGoodsList.jsp" )
		.forward ( request , response ) ;
		
	}

	/**
	 * 获取分页的商品信息
	 * @param request 
	 * @param response
	 * @param search
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public PageUtil < Goods > getPageGoods ( HttpServletRequest request ,
			HttpServletResponse response , String search) throws ServletException ,
			IOException
	{
		IndexService indexService = new IndexService ( ) ;
		int pageSize = Integer.parseInt ( request.getParameter ( "pageSize" ) ) ;
		int currentPage = Integer.parseInt ( request
				.getParameter ( "currentPage" ) ) ;
		try
		{
			PageUtil < Goods > goodsPage = indexService.getGoodsByPage (
					pageSize , currentPage , search ,
					GoodsDaoImpl.ORDER_DEFAULT ) ;
			return goodsPage;

		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null;
	}

}
