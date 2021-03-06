package com.zjlppz.dao;

import java.sql.SQLException;

import com.zjlppz.bean.Collect;
import com.zjlppz.bean.User;
import com.zjlppz.util.JDBCUtilTemplate;
import com.zjlppz.util.PageUtil;

/**
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
	 * 分页查询用户的收藏夹商品信息
	 * 
	 * @param pagesize 用户传入的每一页显示的数据条数 <br/>
	 * @param currentpage 用户所查询的当前页面的页数 <br/>
	 * @param user 传入的该用户对象
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
