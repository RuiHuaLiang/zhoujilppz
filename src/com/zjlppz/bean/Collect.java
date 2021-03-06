package com.zjlppz.bean;

import java.io.Serializable;

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
public class Collect implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer collectsId;
	private Integer userId;
	private Integer goodsId;
	
	private double goodsPrice;
	private String goodsName;
	private String pictureUrl;

	public Collect() {
	}


	public Integer getCollectsId() {
		return collectsId;
	}

	public void setCollectsId(Integer collectsId) {
		this.collectsId = collectsId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((collectsId == null) ? 0 : collectsId.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collect other = (Collect) obj;
		if (collectsId == null) {
			if (other.collectsId != null)
				return false;
		} else if (!collectsId.equals(other.collectsId))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Collect [collectsId=" + collectsId + ", userId=" + userId
				+ ", goodsId=" + goodsId + "]";
	}

}
