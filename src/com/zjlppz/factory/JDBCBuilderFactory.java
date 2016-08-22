package com.zjlppz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.zjlppz.util.ReadXmlUtil;

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
public class JDBCBuilderFactory {

	private static JDBCBuilderFactory builderFactory;
	
	private static String url;
	private static String userName;
	private static String password;
	private static String driver;
	
	static{
		Map<String, String> eleMap = ReadXmlUtil.getElement("property");
		url = eleMap.get("connect.url");
		userName = eleMap.get("connect.username");
		password = eleMap.get("connect.password");
		driver = eleMap.get("connect.driver");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动注册失败！");
			e.printStackTrace();
		}
	}
	
	private JDBCBuilderFactory(){
	}
	
	public static JDBCBuilderFactory newInstance(){
		if(builderFactory==null){
			builderFactory=new JDBCBuilderFactory();
		}
		return builderFactory;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userName, password);
	}
	
}
