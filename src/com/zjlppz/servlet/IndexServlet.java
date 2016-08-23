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
import com.zjlppz.bean.User ;
import com.zjlppz.services.IndexService ;

public class IndexServlet extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public IndexServlet ( )
	{
		super ( ) ;
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy ( )
	{
		super.destroy ( ) ; // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		doPost ( request , response );
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
		List < Car > carItems ;
		try
		{
			carItems = indexService.getCarItemsCount ( user ) ;
			System.out.println (carItems) ;
			request.setAttribute ( "carItems" , carItems );
			
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
		
		
		
		request.getRequestDispatcher ( "/activities/index.jsp" ).forward ( request , response );

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init ( ) throws ServletException
	{
		// Put your code here
	}

}