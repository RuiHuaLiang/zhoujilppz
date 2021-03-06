package com.zjlppz.dao;

import java.sql.SQLException;
import java.util.List;

import com.zjlppz.bean.User;
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
public class UserDaoImpl {
	
	/**
	 * 用户进行注册
	 * @param user <br/>
	 * &nbsp&nbsp&nbsp注册的用户对象
	 * @return
	 * &nbsp&nbsp&nbsp 1表示注册成功。<br/>
	 * &nbsp&nbsp&nbsp 其余表示注册失败。
	 * @throws SQLException 
	 */
	public int register(User user) throws SQLException{
		String sql = "insert into users(userid, username, userpassword," +
				"phonenumber, email, useridcard, headerimgurl) values(seq_usersid.nextval,?,?,?,?,?,?)";
		int resnum = JDBCUtilTemplate.insert(sql,user.getUserName(),
				user.getUserPassword(),user.getPhoneNumber(),user.getEmail(),
				user.getUserIdCard(),user.getHeaderImgUrl());
		return resnum;
	}
	
	/**
	 * 修改用户信息
	 * @param user <br/>
	 * &nbsp&nbsp&nbsp所修改的用户的信息
	 * @return 
	 * &nbsp&nbsp&nbsp 1表示修改成功。<br/>
	 * &nbsp&nbsp&nbsp 其余表示修改失败。
	 * @throws SQLException 
	 */
	public int update(User user) throws SQLException{
		String sql = "update users set username=?,userpassword=?,phonenumber=?,email=?,useridcard=?,headerimgurl=? where userid = ?";
		int resnum = JDBCUtilTemplate.update(sql, user.getUserName(),
				user.getUserPassword(),user.getPhoneNumber(),user.getEmail(),
				user.getUserIdCard(),user.getHeaderImgUrl(),user.getUserId());
		return resnum;
	}
	
	/**
	 * 该方法用于用户登录时从数据库中根据用户名和密码获取用户信息
	 * @param user <br/>
	 * 	&nbsp&nbsp&nbsp 保存了用户的用户名和密码
	 * @return 
	 * &nbsp&nbsp&nbsp 若返回的为null，则说明没有该用户<br/>
	 * &nbsp&nbsp&nbsp 若返回不为null，则数据库中存在该用户
	 */
	public User userLogin(User user){
		List<User> users = null;
		String sql = "select * from users where username=? and userpassword=?";
		try {
			users = JDBCUtilTemplate.queryData(sql, User.class, user.getUserName(),user.getUserPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (users == null || users.size() < 1) {
			return null;
		} else {
			return users.get(0);
		}
	}
	
	/**
	 * 查询所有用户的信息
	 * @return
	 * 		返回所有的用户信息List集合
	 */
	public List<User> getAllUsers(){
		List<User> users = null;
		String sql = "select * from users";
		try {
			users = JDBCUtilTemplate.queryData(sql, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}
