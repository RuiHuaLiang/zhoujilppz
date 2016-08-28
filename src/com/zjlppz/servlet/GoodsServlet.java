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
import com.zjlppz.bean.Category ;
import com.zjlppz.bean.Goods ;
import com.zjlppz.bean.User ;
import com.zjlppz.bean.viewbean.CategoryGoods ;
import com.zjlppz.dao.GoodsDaoImpl ;
import com.zjlppz.services.GoodsService ;
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
		else if("catGoods".equals ( command ))
		{
			getCategoryGoods ( request , response );
		}
		else if ( "secondLevelMenu".equals ( command ) )
		{
			getSecondLevelMenu ( request , response ) ;
		}
		else if("categoryGoodsPageHandle".equals ( command ))
		{
			getCategoryGoodsPageHandle ( request , response );
		}
		else if("goodsInfo".equals ( command ))
		{
			getGoodsInfoById ( request , response );
		}
	}
	
	/**
	 * 根据商品Id查询商品的详细信息
	 * @param request
	 * @param response
	 */
	public void getGoodsInfoById ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		Integer  goodsId = Integer.parseInt ( request.getParameter ( "goodsId" ));
		GoodsService goodsService = new GoodsService ( );
		IndexService indexService = new IndexService ( ) ;
		//获取登录Session
		HttpSession session = request.getSession ( ) ;
		
		try
		{
			//购物车
			List < Car > carItems ;
			
			carItems = indexService.getCarItems ( ( User ) session.getAttribute ( "user" ) ) ;
			
			request.setAttribute ( "carItems" , carItems ) ;
			
			Goods goodsInfo = goodsService.getGoodsInfoById ( goodsId );
			request.setAttribute ( "goodsInfo" , goodsInfo );
		
			request.getRequestDispatcher ( "/activities/goodsInfo.jsp" ).forward ( request , response );
		} 
		catch ( ServletException e )
		{
			e.printStackTrace();
		} 
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * Ajax按一级类别获取商品的分页处理
	 * @param request
	 * @param response
	 */
	public void getCategoryGoodsPageHandle ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		Integer parentId = Integer.parseInt ( request.getParameter ( "parentId" ) );
		int currentPage = Integer.parseInt ( request.getParameter ( "currentPage" ));
		int pageSize = Integer.parseInt ( request.getParameter ( "pageSize" ));
		String sort = request.getParameter ( "sort" ) ;
		
		GoodsService goodsService = new GoodsService();
		
		try
		{
			PageUtil < Goods > pageCategoryGoods;
			if(parentId < 10 )
			{
				pageCategoryGoods = goodsService.getPageCategoryGoods ( parentId , currentPage , pageSize , sort);
			}
			else
			{
				pageCategoryGoods = goodsService.getGoodsByCategoryIdByPage ( parentId , currentPage , pageSize , sort);
			}
			
			Gson gson = new Gson();
			String goodsPageJsonString = gson.toJson ( pageCategoryGoods );
			System.out.println (goodsPageJsonString) ;
			
			PrintWriter out  = response.getWriter (  ) ;
			out.print ( goodsPageJsonString );
			out.flush ( );
			
		} catch ( IOException e )
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * 按一级类别获取商品
	 * @param request
	 * @param response
	 */
	public void getCategoryGoods ( HttpServletRequest request ,
			HttpServletResponse response )
	{
		Integer parentId = Integer.parseInt ( request.getParameter ( "categoryId" ));
		request.setAttribute ( "parentId" , parentId );
		
		int currentPage = Integer.parseInt ( request.getParameter ( "currentPage" ));
		int pageSize = Integer.parseInt ( request.getParameter ( "pageSize" ));
		String sort = request.getParameter ( "sort" ) ;
		
		String categoryName = request.getParameter ( "categoryName" );
		request.setAttribute ( "categoryName" , categoryName );
		
		
		//获取登录Session
		HttpSession session = request.getSession ( ) ;
		
		GoodsService goodsService = new GoodsService();
		IndexService indexService = new IndexService ( ) ;
		List < Car > carItems;
		
		try
		{
			//购物车
			carItems  = indexService.getCarItems ( ( User ) session.getAttribute ( "user" ) ) ;
			request.setAttribute ( "carItems" , carItems ) ;
			
			//类别商品
			PageUtil < Goods > pageCategoryGoods;
			if(parentId < 10 )
			{
				pageCategoryGoods = goodsService.getPageCategoryGoods ( parentId , currentPage , pageSize , sort);
			}
			else
			{
				pageCategoryGoods = goodsService.getGoodsByCategoryIdByPage ( parentId , currentPage , pageSize , sort);
			}
			
			request.setAttribute ( "pageCategoryGoods" , pageCategoryGoods );
			
			request.getRequestDispatcher ( "/activities/categoryGoodsList.jsp" ).forward ( request , response );
			
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * ajax获取商品类别二级菜单
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


	/**
	 * ajax商品分页处理
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPageHandle ( HttpServletRequest request ,
			HttpServletResponse response ) throws ServletException ,
			IOException
	{
		String search = request.getParameter ( "search" ) ;
		String sort = request.getParameter ( "sort" ) ;
		PageUtil < Goods > goodsPage = getSearchPageGoods(request , response , search , sort);
		
		Gson gson = new Gson();
		String goodsPageJsonString = gson.toJson ( goodsPage );
		System.out.println (goodsPageJsonString) ;
		PrintWriter out = response.getWriter (  );
		out.print ( goodsPageJsonString );
		out.flush ( );
	}

	/**
	 * 商品搜索
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
		
		
		
			String search = request.getParameter ( "search" ) ;
			// System.out.println (search) ;
			request.setAttribute ( "search" , search ) ;
			
			String sort = request.getParameter ( "sort" );
			
			PageUtil < Goods > goodsPage = getSearchPageGoods(request , response , search , sort);
			request.setAttribute ( "goodsPage" , goodsPage ) ;
			
			System.out.println ( goodsPage ) ;
			
			request.getRequestDispatcher ( "/activities/searchGoodsList.jsp" )
			.forward ( request , response ) ;
		} catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	/**
	 * 按条件搜索，获取分页的商品信息
	 * @param request 
	 * @param response
	 * @param search
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public PageUtil < Goods > getSearchPageGoods ( HttpServletRequest request ,
			HttpServletResponse response , String search , String sort) throws ServletException ,
			IOException
	{
		GoodsService goodsService = new GoodsService();
		int pageSize = Integer.parseInt ( request.getParameter ( "pageSize" ) ) ;
		int currentPage = Integer.parseInt ( request
				.getParameter ( "currentPage" ) ) ;
		try
		{
			PageUtil < Goods > goodsPage = goodsService.getGoodsByPage (
					pageSize , currentPage , search , sort) ;
			return goodsPage;

		} catch ( Exception e )
		{
			e.printStackTrace ( ) ;
		}
		return null;
	}

}
