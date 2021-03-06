package com.zjlppz.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @创建作者：周健
 * @创建时间：2016-8-16
 * @创建版本：1.0
 * 
 * @修改者：周洁
 * @修改版本：2.0
 * @修改时间：2016-8-17
 * @修改描述：增加组合（多表）查询的集合查询方法，增加组合（多表）查询的分页查询方法
 * @历史版本：1.0
 */
public class JDBCUtilTemplate {

	private JDBCUtilTemplate(){
	}

	public static int insert(String sql, Object... values) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);// 此对象可以发送sql到数据库
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					stmt.setObject(i + 1, values[i]);
				}
			}
			int res = stmt.executeUpdate();
			return res;
		} finally {
			JDBCUtil.freeSource(conn, stmt, null);
		}
	}

	public static int delete(String sql, Object... values) throws SQLException {
		return insert(sql, values);
	}

	public static int update(String sql, Object... values) throws SQLException{
		return insert(sql, values);
	}
	

	public static<T> List<T> queryData(String sql,Class<T> cls, Object ... values) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			connection = JDBCUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			// 元数据
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			//数据库中的每一条数据应该放到对应的Vo类中

			while (rs.next()) {
				HashMap<String, Object> rowData = new HashMap<String, Object>();//一个Map存一行数据
				//以列为为key,数据为value构造一个HashMap
				for(int i=0;i<columnCount;i++){
					//取得列名
					String columnName =  metaData.getColumnName(i+1);
					//取得列的数据类型，再调用rs.getXXX方法将数据转换对应的java类型
					String columnType = metaData.getColumnTypeName(i+1);
				//	System.out.println("列名："+columnName + "数据类型:"+columnType +" "+metaData.getScale(i+1));
					//根据列名取列值
					Object val = null;
					//根据数据库表的数据类型，转成成对应的java数据类型
					//目的是减少反射的数据类型判断
					if (columnType.equals("NUMBER") && metaData.getScale(i+1)>0){//有小数位
						val = rs.getDouble(columnName);
					}else if (columnType.startsWith("VARCHAR")){
						val = rs.getString(columnName);
					}else if (columnType.equals("NUMBER")){//没有小数位的
						val = rs.getInt(columnName);
					}else if (columnType.equals("DATE")){
						val = rs.getDate(columnName);
					}
					rowData.put(columnName.toLowerCase(), val);
				}
				T t =   MapToVoDataUtil.setMapValueToVo(rowData, cls);//使用反射将数据封装到Vo中
				data.add(t);//将vo存到集合中
			}
		} finally {
			JDBCUtil.freeSource(connection, pstmt, rs);
		}
		return data;
	}

	/**
	 * 根据查询语句返回list<Object[]>(可用于多表查询)
	 * @throws SQLException 
	 */
	public static List<Object[]> queryData(String sql, Object ... values) throws SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object[]> data = new ArrayList<Object[]>();
		try {
			connection = JDBCUtil.getConnection();
			pstmt = connection.prepareStatement(sql);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			// 元数据
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {

				// 根据columnCount创建相应长度的Object[]数组
				Object[] rowData = new Object[columnCount];

				// rs.getObject(1);
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);// 把取出来的数据放到Object[]数组中
				}
				// 将数据加到集合中
				data.add(rowData);
			}

		} finally {
			JDBCUtil.freeSource(connection, pstmt, rs);
		}
		return data;

	}
	/**
	 * 分页查询
	 * @param sql--查询语句
	 * @param values--查询的条件
	 * @param currentPage--当前页面
	 * @param pageSize
	 * @param cls--泛型
	 * @return
	 * @throws Exception 
	 */
	public static<T> PageUtil<T> queryDataByPage(String sql, Object[] values,
			int currentPage, int pageSize,Class<T> cls) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try { 
			conn = JDBCUtil.getConnection();
			// 1根据传入SQL求出SQL查询的总记录数
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // 总记录数
			while (rs.next()) {
				totalRecord = rs.getInt(1);// 取出第一列的值
			}

			// 根据pageSize（5）和currentPage（2）计算出分页的初始索引和结束索引
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

			// 2做分页查询
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql语句中可能有?号点位符，需要为其传递参数，分页查询中还有两个参数需要传递

			List<T> listData = null;
				listData = queryData(queryDataSql, cls,values);

			// 取分页查询结果
			// 计算总页数:
			int pageCount = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				pageCount = totalRecord / pageSize + 1;
			}
			PageUtil<T> pageUtil = new PageUtil<T>(currentPage, pageSize,
					totalRecord, pageCount, listData);
			return pageUtil;
		} finally {
			JDBCUtil.freeSource(conn, pstmt, rs);
		}
	}
	
	/**
	 * 分页查询(重载方法)
	 * @param sql--查询语句
	 * @param values--查询的条件
	 * @param currentPage--当前页面
	 * @param pageSize
	 * @param 
	 * @return PageUtil
	 */
	public static PageUtil<Object[]> queryDataByPage(String sql, Object[] values,
			int currentPage, int pageSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			// 1根据传入SQL求出SQL查询的总记录数
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // 总记录数
			while (rs.next()) {
				totalRecord = rs.getInt(1);// 取出第一列的值
			}

			// 根据pageSize（5）和currentPage（2）计算出分页的初始索引和结束索引
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

 			// 2做分页查询
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql语句中可能有?号点位符，需要为其传递参数，分页查询中还有两个参数需要传递

			List<Object[]> listData = queryData(queryDataSql, values);

			// 取分页查询结果
			// 计算总页数:
			int pageCount = totalRecord / pageSize;
			if (totalRecord % pageSize != 0) {
				pageCount = totalRecord / pageSize + 1;
			}

			PageUtil<Object[]> pageUtil = new PageUtil<Object[]>(currentPage, pageSize,
					totalRecord, pageCount, listData);

			return pageUtil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.freeSource(conn, pstmt, rs);
		}
		return null;
	}
}
