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
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-16
 * @�����汾��1.0
 * 
 * @�޸��ߣ��ܽ�
 * @�޸İ汾��2.0
 * @�޸�ʱ�䣺2016-8-17
 * @�޸�������������ϣ��������ѯ�ļ��ϲ�ѯ������������ϣ��������ѯ�ķ�ҳ��ѯ����
 * @��ʷ�汾��1.0
 */
public class JDBCUtilTemplate {

	private JDBCUtilTemplate(){
	}

	public static int insert(String sql, Object... values) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(sql);// �˶�����Է���sql�����ݿ�
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
			// Ԫ����
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			//���ݿ��е�ÿһ������Ӧ�÷ŵ���Ӧ��Vo����

			while (rs.next()) {
				HashMap<String, Object> rowData = new HashMap<String, Object>();//һ��Map��һ������
				//����ΪΪkey,����Ϊvalue����һ��HashMap
				for(int i=0;i<columnCount;i++){
					//ȡ������
					String columnName =  metaData.getColumnName(i+1);
					//ȡ���е��������ͣ��ٵ���rs.getXXX����������ת����Ӧ��java����
					String columnType = metaData.getColumnTypeName(i+1);
				//	System.out.println("������"+columnName + "��������:"+columnType +" "+metaData.getScale(i+1));
					//��������ȡ��ֵ
					Object val = null;
					//�������ݿ�����������ͣ�ת�ɳɶ�Ӧ��java��������
					//Ŀ���Ǽ��ٷ�������������ж�
					if (columnType.equals("NUMBER") && metaData.getScale(i+1)>0){//��С��λ
						val = rs.getDouble(columnName);
					}else if (columnType.startsWith("VARCHAR")){
						val = rs.getString(columnName);
					}else if (columnType.equals("NUMBER")){//û��С��λ��
						val = rs.getInt(columnName);
					}else if (columnType.equals("DATE")){
						val = rs.getDate(columnName);
					}
					rowData.put(columnName.toLowerCase(), val);
				}
				T t =   MapToVoDataUtil.setMapValueToVo(rowData, cls);//ʹ�÷��佫���ݷ�װ��Vo��
				data.add(t);//��vo�浽������
			}
		} finally {
			JDBCUtil.freeSource(connection, pstmt, rs);
		}
		return data;
	}

	/**
	 * ���ݲ�ѯ��䷵��list<Object[]>(�����ڶ����ѯ)
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
			// Ԫ����
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			while (rs.next()) {

				// ����columnCount������Ӧ���ȵ�Object[]����
				Object[] rowData = new Object[columnCount];

				// rs.getObject(1);
				for (int i = 1; i <= columnCount; i++) {
					rowData[i - 1] = rs.getObject(i);// ��ȡ���������ݷŵ�Object[]������
				}
				// �����ݼӵ�������
				data.add(rowData);
			}

		} finally {
			JDBCUtil.freeSource(connection, pstmt, rs);
		}
		return data;

	}
	/**
	 * ��ҳ��ѯ
	 * @param sql--��ѯ���
	 * @param values--��ѯ������
	 * @param currentPage--��ǰҳ��
	 * @param pageSize
	 * @param cls--����
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
			// 1���ݴ���SQL���SQL��ѯ���ܼ�¼��
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // �ܼ�¼��
			while (rs.next()) {
				totalRecord = rs.getInt(1);// ȡ����һ�е�ֵ
			}

			// ����pageSize��5����currentPage��2���������ҳ�ĳ�ʼ�����ͽ�������
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

			// 2����ҳ��ѯ
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql����п�����?�ŵ�λ������ҪΪ�䴫�ݲ�������ҳ��ѯ�л�������������Ҫ����

			List<T> listData = null;
				listData = queryData(queryDataSql, cls,values);

			// ȡ��ҳ��ѯ���
			// ������ҳ��:
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
	 * ��ҳ��ѯ(���ط���)
	 * @param sql--��ѯ���
	 * @param values--��ѯ������
	 * @param currentPage--��ǰҳ��
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
			// 1���ݴ���SQL���SQL��ѯ���ܼ�¼��
			String countSql = "select count(*) from (" + sql + ")";

			pstmt = conn.prepareStatement(countSql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					pstmt.setObject(i + 1, values[i]);
				}
			}
			rs = pstmt.executeQuery();
			int totalRecord = 0; // �ܼ�¼��
			while (rs.next()) {
				totalRecord = rs.getInt(1);// ȡ����һ�е�ֵ
			}

			// ����pageSize��5����currentPage��2���������ҳ�ĳ�ʼ�����ͽ�������
			int rn1 = (currentPage - 1) * pageSize;
			int rn2 = currentPage * pageSize;

 			// 2����ҳ��ѯ
			String queryDataSql = " select * from ("
					+ "	select tmp.*,rownum rn from (" + sql
					+ ") tmp) where rn>" + rn1 + " and rn<=" + rn2;
			// sql����п�����?�ŵ�λ������ҪΪ�䴫�ݲ�������ҳ��ѯ�л�������������Ҫ����

			List<Object[]> listData = queryData(queryDataSql, values);

			// ȡ��ҳ��ѯ���
			// ������ҳ��:
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