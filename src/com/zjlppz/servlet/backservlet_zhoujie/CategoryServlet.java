package com.zjlppz.servlet.backservlet_zhoujie;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjlppz.bean.Category;
import com.zjlppz.services.backServices_zhoujie.CategoryService;
import com.zjlppz.util.PageUtil;

public class CategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/**
	 * service
	 * ������Ʒ�����й�����
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��ú�̨����������
		String command = request.getParameter("command");
		System.out.println(command);
		if("queryType".equals(command)){
			queryType(request,response);
		}else if("addType".equals(command)){
			addType(request,response);
		}else if("updateType".equals(command)){
			updateType(request,response);
		}
	}
	
	
	private void updateType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void addType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void queryType(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		//��ñ�������
		String type = request.getParameter("type");
		String parentId = request.getParameter("parentId");
		String name = request.getParameter("name");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(name !=null && name.length()>0){
			try {
				name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		System.out.println(currentPage+"/"+type+"/"+parentId+"/"+name);
		//
		CategoryService services = new CategoryService();
		//��ò�ѯ��ҳ����
		PageUtil<Category> allCate = services.queryType(type,parentId,name,currentPage,pageSize);
		//������и�������Ϣ
		List<Category> parentCate = services.queryParent();
		
		request.setAttribute("allCate",allCate);
		request.setAttribute("parentCate",parentCate);
		request.setAttribute("type", type);
		request.setAttribute("parentId", parentId);
		request.setAttribute("name",name);
			try {
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