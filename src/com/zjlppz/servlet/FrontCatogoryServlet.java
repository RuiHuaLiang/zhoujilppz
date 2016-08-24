package com.zjlppz.servlet ;

import java.io.IOException ;
import java.io.PrintWriter ;
import java.util.List ;

import javax.servlet.ServletException ;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest ;
import javax.servlet.http.HttpServletResponse ;

import com.google.gson.Gson ;
import com.zjlppz.bean.Category ;
import com.zjlppz.services.IndexService ;

public class FrontCatogoryServlet extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public FrontCatogoryServlet ( )
	{
		super ( ) ;
	}

	
	public void doGet ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		String command = request.getParameter ( "command" ) ;

		if ( "secondLevelMenu".equals ( command ) )
		{
			getSecondLevelMenu ( request , response ) ;
		}

	}

	
	public void doPost ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{

	}

	/**
	 * 获取商品类别二级菜单
	 * 
	 * @param request
	 * @param response
	 */
	public void getSecondLevelMenu ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		response.setContentType("text/html;charset=utf-8");
		IndexService indexService = new IndexService ( ) ;
		Integer categoryId = Integer.parseInt ( request
				.getParameter ( "categoryId" ) ) ;
		List < Category > secondLevelMenu ;
		try
		{
			secondLevelMenu = indexService.getCategory ( categoryId ) ;
		
		Gson gson = new Gson();
		String secondLevelMenuJsonString = gson.toJson ( secondLevelMenu );
//		System.out.println (secondLevelMenuJsonString) ;
			PrintWriter out = response.getWriter ( );
			out.print ( secondLevelMenuJsonString );
			out.flush ( );
			
		} 
		catch ( IOException e )
		{
			e.printStackTrace();
		}catch ( Exception e1 )
		{
			e1.printStackTrace();
		}

	}

}
