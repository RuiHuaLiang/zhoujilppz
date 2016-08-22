package com.zjlppz.bean;

import java.io.Serializable;
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
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;// 用户id
	private String userName;// 用户账号
	private String userPassword;// 用户密码：32位md5
	private String phoneNumber;// 用户电话号码
	private String email;// 用户email
	private String userIdCard;// 用户身份证号码
	private String headerImgUrl;// 用户头像信息

	private List<Car> cars;// 购物车商品列表
	private List<Order> orders;// 订单信息
	private List<Consignee> consignees;// 收货人信息
	private List<Collect> collects;// 收藏夹商品条目信息

	public User() {
	}

	public User(Integer userId, String userName, String userPassword,
			String phoneNumber, String email, String userIdCard,
			String headerImgUrl, List<Car> cars, List<Order> orders,
			List<Consignee> consignees, List<Collect> collects) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userIdCard = userIdCard;
		this.headerImgUrl = headerImgUrl;
		this.cars = cars;
		this.orders = orders;
		this.consignees = consignees;
		this.collects = collects;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getHeaderImgUrl() {
		return headerImgUrl;
	}

	public void setHeaderImgUrl(String headerImgUrl) {
		this.headerImgUrl = headerImgUrl;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Consignee> getConsignees() {
		return consignees;
	}

	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}

	public List<Collect> getCollects() {
		return collects;
	}

	public void setCollects(List<Collect> collects) {
		this.collects = collects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result
				+ ((collects == null) ? 0 : collects.hashCode());
		result = prime * result
				+ ((consignees == null) ? 0 : consignees.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((headerImgUrl == null) ? 0 : headerImgUrl.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userIdCard == null) ? 0 : userIdCard.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((userPassword == null) ? 0 : userPassword.hashCode());
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
		User other = (User) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (collects == null) {
			if (other.collects != null)
				return false;
		} else if (!collects.equals(other.collects))
			return false;
		if (consignees == null) {
			if (other.consignees != null)
				return false;
		} else if (!consignees.equals(other.consignees))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (headerImgUrl == null) {
			if (other.headerImgUrl != null)
				return false;
		} else if (!headerImgUrl.equals(other.headerImgUrl))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userIdCard == null) {
			if (other.userIdCard != null)
				return false;
		} else if (!userIdCard.equals(other.userIdCard))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", userIdCard="
				+ userIdCard + ", headerImgUrl=" + headerImgUrl + ", cars="
				+ cars + ", orders=" + orders + ", consignees=" + consignees
				+ ", collects=" + collects + "]";
	}

}
