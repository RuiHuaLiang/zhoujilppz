package com.zjlppz.servlet.backservlet_zhoujie;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjlppz.bean.Category;
import com.zjlppz.dao.CategoryDaoImpl;

public class CategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/**
	 * service
	 * 处理商品类别的有关请求
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得后台的请求内容
		String command = request.getParameter("command");
		if("getType".equals(command)){
			getType(request,response);
		}
	}
	/**
	 * 查询类别表获得类别名称和父类别名称
	 * @param request
	 * @param response
	 */
	private void getType(HttpServletRequest request,
			HttpServletResponse response) {
		//获得所有类别信息（包括一级类别和二级类别）
		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		List<Category> cateList = cateDao.getAllCategory();
		
		if(cateList != null && cateList.size()>0){
			request.setAttribute("allType", cateList);
			//request.
			try {
				System.out.println("转发成功！");
				request.getRequestDispatcher("/manageview/category/getAllCategory.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
