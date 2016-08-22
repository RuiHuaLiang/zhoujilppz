package com.zjlppz.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zjlppz.factory.JDBCBuilderFactory;

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
public class JDBCUtil {

	private JDBCUtil() {
	}

	//获取数据库连接
	public static Connection getConnection() {
		JDBCBuilderFactory builderFactory = JDBCBuilderFactory.newInstance();
		Connection connection = null;
		try {
			connection = builderFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	//释放资源
	public static void freeSource(Connection conn, Statement stm, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
		} catch (SQLException e) {
			rst = null;
			e.printStackTrace();
		}

		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			stm = null;
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			conn = null;
			e.printStackTrace();
		}

	}

}
