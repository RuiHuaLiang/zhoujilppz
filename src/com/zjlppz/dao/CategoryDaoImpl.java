package com.zjlppz.dao;

import java.util.List;

import com.zjlppz.bean.Category;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;
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
	 * @throws Exception 
	 */
	public List<Category> getAllCategory() throws Exception{
		String sql = "select * from categories";
		List<Category> categories= null;
			categories = JDBCUtilTemplate.queryData(sql,Category.class);
		return categories;
	}
	

	/**
	 * 获取商品种类信息集合
	 * @author 周健	
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
	
	
	/**
	 * 获取商品种类信息集合
	 * @author 周洁
	 * @param query 
	 * @return
	 * @throws Exception 
	 */

	public PageUtil<Category> getCategory(String[] query,String currentPage,String pageSize) throws Exception{
		Object[] values = null ;

		String sql = "select * from categories where 1=1";
		if(query != null && query.length >0){
				if ("1".equals(query[0])){
					sql +=" and parentid is null";
				}else if("2".equals(query[0])){
					sql +=" and parentid is not null";
					/*if(query[1]!=null && query[1].length()>0){
						sql += " and parentId ="+query[1];	
					}*/
				}
				if(query[1]!=null && query[1].length()>0){
					sql += " and parentId ="+query[1];	
				}
				if(query[2] != null && query[2].length()>0){
					sql += " and categoryname like '%"+query[2]+"%'";				
				}
			}
			
		//System.out.println("dao中"+sql);
		
		PageUtil<Category> pageCate = null;
		//默认当前页为1，size为10
		int current = 1;
		int size = 10;
		if (currentPage != null && currentPage.matches("[0-9]+")){
			current = Integer.parseInt(currentPage);
		}

		if (pageSize!=null && pageSize.matches("[0-9]+")){
			size = Integer.parseInt(pageSize);
		}

		pageCate = JDBCUtilTemplate.queryDataByPage(sql,values,current,size,Category.class);
		
		return pageCate;
	}

	
}
