package com.zjlppz.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.zjlppz.util.ReadXmlUtil;

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
			System.out.println("����ע��ʧ�ܣ�");
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
