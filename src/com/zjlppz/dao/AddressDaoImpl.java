package com.zjlppz.dao;

import java.util.List;

import com.zjlppz.bean.Address;
import com.zjlppz.util.JDBCUtilTemplate;

/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 		城市信息查询类
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class AddressDaoImpl {
	
	/**
	 * 获取城市集合
	 * 		
	 * @param parentId &nbsp&nbsp需要获取的城市集合的父类id<br/>
	 * 	&nbsp&nbsp&nbsp	当传入值为null时，获取第一级城市信息集合。<br/>
	 * 	&nbsp&nbsp&nbsp	当传入值不为null时，根据该传入值获得子级城市信息集合。
	 * @return addresses
	 * 	&nbsp&nbsp&nbsp 返回的所有同一父类的子级城市集合
	 * @throws Exception 
	 */
	public List<Address> getAddress(Integer parentId) throws Exception{
		String sql = "select * from ADDRESS where 1=1";
		if (parentId==null || parentId.equals("")){
			sql +=" and parentid is null";
		}else{
			sql +=" and parentid="+parentId;
		}
		List<Address> addresses= null;
			addresses = JDBCUtilTemplate.queryData(sql,Address.class);
		return addresses;
	}

}
