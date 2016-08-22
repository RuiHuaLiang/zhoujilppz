package com.zjlppz.dao;

import java.util.List;

import com.zjlppz.bean.Category;
import com.zjlppz.util.JDBCUtilTemplate;
/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 		商品种类信息查询类
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class CategoryDaoImpl {
	
	/**
	 * 获取商品类别表的所有信息集合
	 * @param 
	 * @return
	 */
	public List<Category> getAllCategory(){
		String sql = "select * from categories";
		List<Category> categories= null;
		try {
			categories = JDBCUtilTemplate.queryData(sql,Category.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询所有类别失败。。。");
		}
		return categories;
	}
	

	/**
	 * 获取商品种类信息集合
	 * 		
	 * @param parentId <br/>
	 * &nbsp&nbsp&nbsp当传入值为null时，获取第一级商品种类信息集合。<br/>
	 * &nbsp&nbsp&nbsp当传入值不为null时，根据该传入值获得子级商品种类信息集合。
	 * @return
	 * @throws Exception 
	 */
	public List<Category> getCategory(Integer parentId) throws Exception{
		String sql = "select * from categories where 1=1";
		if (parentId==null || parentId.equals("")){
			sql +=" and parentid is null";
		}else{
			sql +=" and parentid="+parentId;
		}
		List<Category> categories= null;
			categories = JDBCUtilTemplate.queryData(sql,Category.class);
		return categories;
	}
	
}
