package com.zjlppz.dao;

import java.sql.SQLException;

import com.zjlppz.bean.Collect;
import com.zjlppz.bean.User;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;

/**
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
public class CollectDaoImpl {

	public int insertCollect(Collect collect) throws SQLException{
		String sql = "insert into collects(collectsid, userid, goodsid)" +
				" values(SEQ_COLLECTSID.nextval,?,?)";
		int resNum = JDBCUtilTemplate.insert(sql, collect.getUserId(),collect.getGoodsId());
		return resNum;
	}
	
	public int deleteCollect(Collect collect) throws SQLException{
		String sql = "delete from collects where userid = ? and goodsid = ?";
		int resNum = JDBCUtilTemplate.delete(sql, collect.getUserId(),collect.getGoodsId());
		return resNum;
	}
	
	/**
	 * ��ҳ��ѯ�û����ղؼ���Ʒ��Ϣ
	 * 
	 * @param pagesize �û������ÿһҳ��ʾ���������� <br/>
	 * @param currentpage �û�����ѯ�ĵ�ǰҳ���ҳ�� <br/>
	 * @param user ����ĸ��û�����
	 * @return PageUtil   collectPageUtil
	 * @throws Exception 
	 */
	public PageUtil<Collect> getUserCollects(int pagesize,int currentpage,User user) throws Exception{
		String sql = "select collects.*,goods.price goodsprice,goodsname,pictureurl from" +
				" collects,goods where collects.goodsid = goods.goodsid  and userid = ?";
		PageUtil<Collect> collectPageUtil = null;
		collectPageUtil = JDBCUtilTemplate.queryDataByPage(sql, new String[]{""+user.getUserId()}, currentpage, pagesize, Collect.class);
		return collectPageUtil;
	}
	
}
