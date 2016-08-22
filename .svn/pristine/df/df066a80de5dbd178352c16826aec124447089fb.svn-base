package com.zjlppz.dao;

import java.util.List;

import com.zjlppz.bean.Admin;
import com.zjlppz.util.JDBCUtilTemplate;

/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
 */
public class AdminDaoImpl {

	/**
	 * 判断管理员账户和密码是否正确
	 * @param admin <br/>
	 * &nbsp&nbsp&nbsp 管理员登录时，保存登录账号和密码的对象
	 * @return admin <br/>
	 * &nbsp&nbsp&nbsp 返回值为null，则表示账号或者密码错误</br>
	 * &nbsp&nbsp&nbsp 返回值不为null，则表示登录成功
	 * @throws Exception 
	 */
	public Admin getAdmin(Admin admin) throws Exception{
		List<Admin> admins = null;
		String sql = "select * from admins where adminaccount=? and adminpassword=?";
			admins = JDBCUtilTemplate.queryData(sql, Admin.class,
					admin.getAdminAccount(), admin.getAdminPassword());
		if (admins == null || admins.size() < 1) {
			return null;
		} else {
			admin.setAdminId(admins.get(0).getAdminId());
			return admin;
		}
	}
	
}
