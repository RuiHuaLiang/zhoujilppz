package com.zjlppz.services.backServices_zhoujie;

import com.zjlppz.bean.Admin;
import com.zjlppz.dao.AdminDaoImpl;

public class AdminService {
	
	/**
	 * 根据传来的账户和密码判断
	 * 查询结果有就返回Admin对象
	 * 否则返回空
	 * @param adminAccount
	 * @param adminPassword
	 * 
	 */
	public Admin login(String adminAccount, String adminPassword) {
		// TODO Auto-generated method stub
		// 将值set到admin对象
		Admin admin = new Admin();
		admin.setAdminAccount(adminAccount);
		admin.setAdminPassword(adminPassword);
		// 查询数据库
		AdminDaoImpl adminDao = new AdminDaoImpl();
		Admin loginAdmin = null;
		try {
			loginAdmin = adminDao.getAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginAdmin;
	}
	
}
