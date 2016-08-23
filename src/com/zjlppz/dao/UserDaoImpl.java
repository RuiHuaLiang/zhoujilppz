package com.zjlppz.dao;

import java.sql.SQLException;
import java.util.List;

import com.zjlppz.bean.User;
import com.zjlppz.util.JDBCUtilTemplate;

/**
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-16
 * @�����汾��1.0
 * 
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
 */
public class UserDaoImpl {
	
	/**
	 * �û�����ע��
	 * @param user <br/>
	 * &nbsp&nbsp&nbspע����û�����
	 * @return
	 * &nbsp&nbsp&nbsp 1��ʾע��ɹ���<br/>
	 * &nbsp&nbsp&nbsp �����ʾע��ʧ�ܡ�
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
	 * �޸��û���Ϣ
	 * @param user <br/>
	 * &nbsp&nbsp&nbsp���޸ĵ��û�����Ϣ
	 * @return 
	 * &nbsp&nbsp&nbsp 1��ʾ�޸ĳɹ���<br/>
	 * &nbsp&nbsp&nbsp �����ʾ�޸�ʧ�ܡ�
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
	 * �÷��������û���¼ʱ�����ݿ��и����û����������ȡ�û���Ϣ
	 * @param user <br/>
	 * 	&nbsp&nbsp&nbsp �������û����û���������
	 * @return 
	 * &nbsp&nbsp&nbsp �����ص�Ϊnull����˵��û�и��û�<br/>
	 * &nbsp&nbsp&nbsp �����ز�Ϊnull�������ݿ��д��ڸ��û�
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
	 * ��ѯ�����û�����Ϣ
	 * @return
	 * 		�������е��û���ϢList����
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