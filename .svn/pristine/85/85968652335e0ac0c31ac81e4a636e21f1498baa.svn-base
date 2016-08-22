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
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer goodsId;//商品id    		number(10) not null,
	private Integer categoryId;//种类id  	number(3),
	private Integer storeNumber;//库存 		number(8) not null,
	private double price;// 售价				number(8,2) not null,
	private double discount;// 折扣率
	private Integer sales;//销售量	 		number(8),
	private String goodsName;//商品名		 	varchar2(20) not null,
	private String description;//商品描述	 	varchar2(500),
	private String pictureUrl;//商品图片路径 	varchar2(32),

	private Integer parentid;//商品父种类 。
	private	String categoryname;//商品种类名。
	 
	public Goods() {
	}

	public Goods(Integer goodsId, Integer categoryId, Integer storeNumber,
			double price, double discount, Integer sales, String goodsName,
			String description, String pictureUrl) {
		this.goodsId = goodsId;
		this.categoryId = categoryId;
		this.storeNumber = storeNumber;
		this.price = price;
		this.discount = discount;
		this.sales = sales;
		this.goodsName = goodsName;
		this.description = description;
		this.pictureUrl = pictureUrl;
	}
	

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result
				+ ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result
				+ ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result
				+ ((storeNumber == null) ? 0 : storeNumber.hashCode());
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
		Goods other = (Goods) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (storeNumber == null) {
			if (other.storeNumber != null)
				return false;
		} else if (!storeNumber.equals(other.storeNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", categoryId=" + categoryId
				+ ", storeNumber=" + storeNumber + ", price=" + price
				+ ", discount=" + discount + ", sales=" + sales
				+ ", goodsName=" + goodsName + ", description=" + description
				+ ", pictureUrl=" + pictureUrl + ", parentid=" + parentid
				+ ", categoryname=" + categoryname + "]";
	}

	

}
