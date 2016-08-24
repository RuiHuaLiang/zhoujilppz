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

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
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

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
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
