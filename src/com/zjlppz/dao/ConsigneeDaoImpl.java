package com.zjlppz.dao;

import java.sql.SQLException;

import com.zjlppz.bean.Consignee;
import com.zjlppz.util.JDBCUtilTemplate;

/**
 * �ջ�����Ϣ��
 * @�������ߣ��ܽ�
 * @����ʱ�䣺2016-8-19
 * @�����汾��1.0
 * 
 * @�޸��ߣ�
 * @�޸İ汾��
 * @�޸�ʱ�䣺
 * @�޸�������
 * @��ʷ�汾��
 */
public class ConsigneeDaoImpl {

	public int insertConsignee(Consignee consignee) throws SQLException{
		String sqlInsert = "insert into consignee(consigneeid, userid, consigneename," +
				" consigneeaddress, consigneephone) values(SEQ_CONSIGNEEID.nextval,?,?,?,?)";
		int resNum = JDBCUtilTemplate.insert(sqlInsert, consignee.getUserId(),
				consignee.getConsigneeName(),consignee.getConsigneeAddress(),
				consignee.getConsigneePhone());
		return resNum;
	}
	
	public int deleteConsignee(Consignee consignee) throws SQLException{
		String sqlDelete = "delete from consignee where consigneeid = ?";
		int resNum = JDBCUtilTemplate.delete(sqlDelete, consignee.getConsigneeId());
		return resNum;
	}
	
}
