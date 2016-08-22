package com.zjlppz.dao;

import java.sql.SQLException;

import com.zjlppz.bean.Consignee;
import com.zjlppz.util.JDBCUtilTemplate;

/**
 * 收货人信息类
 * @创建作者：周健
 * @创建时间：2016-8-19
 * @创建版本：1.0
 * 
 * @修改者：
 * @修改版本：
 * @修改时间：
 * @修改描述：
 * @历史版本：
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
