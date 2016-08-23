package com.zjlppz.dao;

import java.util.List;

import com.zjlppz.bean.Category;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;
/**
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-16
 * @�����汾��1.0
 * 		��Ʒ������Ϣ��ѯ��
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
 */
public class CategoryDaoImpl {
	
	/**
	 * ��ȡ��Ʒ������������Ϣ����
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
	 * ��ȡ��Ʒ������Ϣ����
	 * @author �ܽ�	
	 * @param parentId <br/>
	 * &nbsp&nbsp&nbsp������ֵΪnullʱ����ȡ��һ����Ʒ������Ϣ���ϡ�<br/>
	 * &nbsp&nbsp&nbsp������ֵ��Ϊnullʱ�����ݸô���ֵ����Ӽ���Ʒ������Ϣ���ϡ�
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
	 * ��ȡ��Ʒ������Ϣ����
	 * @author �ܽ�
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
			
		//System.out.println("dao��"+sql);
		
		PageUtil<Category> pageCate = null;
		//Ĭ�ϵ�ǰҳΪ1��sizeΪ10
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