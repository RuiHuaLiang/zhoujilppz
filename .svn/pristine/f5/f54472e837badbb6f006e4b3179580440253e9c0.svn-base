package com.zjlppz.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class Order implements Serializable {
	
	// 0 ---未支付
	public static int ORDER_STATE_NOTPAY = 0;
	// 1---未发货
	public static int ORDER_STATE_NOTSENDOUT = 1;
	// 2---已发货未收到
	public static int ORDER_STATE_NOTRECEIVE = 2;
	// 3---已收货
	public static int ORDER_STATE_RECEIVE = 3;

	private static final long serialVersionUID = 1L;

	private String orderId;// number(20) not null,********
	private Integer userId;// number(15),
	private Integer orderState;// number(2) not null,********
	private Date orderTime;// date not null,
	private double total;// number(10,2),
	private String consigneeName;// varchar2(15) not null,********
	private String consigneePhone;// varchar2(20) not null,
	private String consigneeAddress;// varchar2(50) not null,******

	private List<Orderitem> orderItems;

	public Order() {
	}

	public List<Orderitem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Orderitem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Date getOrderTime() {
		return orderTime;
	}
	
	//获取字符串形式的时间格式
	public String getOrderTimeParseString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String dateString = dateFormat.format(this.orderTime);
		return dateString;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((consigneeAddress == null) ? 0 : consigneeAddress.hashCode());
		result = prime * result
				+ ((consigneeName == null) ? 0 : consigneeName.hashCode());
		result = prime * result
				+ ((consigneePhone == null) ? 0 : consigneePhone.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((orderState == null) ? 0 : orderState.hashCode());
		result = prime * result
				+ ((orderTime == null) ? 0 : orderTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Order other = (Order) obj;
		if (consigneeAddress == null) {
			if (other.consigneeAddress != null)
				return false;
		} else if (!consigneeAddress.equals(other.consigneeAddress))
			return false;
		if (consigneeName == null) {
			if (other.consigneeName != null)
				return false;
		} else if (!consigneeName.equals(other.consigneeName))
			return false;
		if (consigneePhone == null) {
			if (other.consigneePhone != null)
				return false;
		} else if (!consigneePhone.equals(other.consigneePhone))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderState == null) {
			if (other.orderState != null)
				return false;
		} else if (!orderState.equals(other.orderState))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (Double.doubleToLongBits(total) != Double
				.doubleToLongBits(other.total))
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
		return "Order [orderId=" + orderId + ", userId=" + userId
				+ ", orderState=" + orderState + ", orderTime=" + orderTime
				+ ", total=" + total + ", consigneeName=" + consigneeName
				+ ", consigneePhone=" + consigneePhone + ", consigneeAddress="
				+ consigneeAddress + "]";
	}

}
