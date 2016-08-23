package com.zjlppz.services.backServices_zhoujie;

import java.util.List;

import com.zjlppz.bean.Category;
import com.zjlppz.dao.CategoryDaoImpl;
import com.zjlppz.util.PageUtil;

public class CategoryService {

	public PageUtil<Category> queryType(String type, String parentId, String name,String currentPage,String pageSize) {
		// TODO Auto-generated method stub
		
		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		String[] query = new String[]{type,parentId,name};
		
		//获得类别信息的分页查询结果
		PageUtil<Category> pageCate = null;
		try {
			pageCate = cateDao.getCategory(query,currentPage,pageSize);
			//return pageCate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return pageCate;
		return pageCate;
	}
	/**
	 * 
	 * @param 查询所有的父类别的信息（不分页）
	 * @return
	 */
	public List<Category> queryParent() {
		
		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		//获得所有父类别信息
		List<Category> parent=null;
		try {
			parent = cateDao.getCategory(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		return parent;
	}
	
}
