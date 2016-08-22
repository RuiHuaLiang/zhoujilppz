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
public class Consignee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer consigneeId;
	private Integer userId;
	private String consigneeName;// varchar2(15) not null,
	private String consigneeAddress;// varchar2(50) not null,
	private String consigneePhone;// varchar2(20)

	public Consignee() {
	}

	public Consignee(Integer consigneeId, Integer userId, String consigneeName,
			String consigneeAddress, String consigneePhone) {
		super();
		this.consigneeId = consigneeId;
		this.userId = userId;
		this.consigneeName = consigneeName;
		this.consigneeAddress = consigneeAddress;
		this.consigneePhone = consigneePhone;
	}

	public Integer getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(Integer consigneeId) {
		this.consigneeId = consigneeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((consigneeAddress == null) ? 0 : consigneeAddress.hashCode());
		result = prime * result
				+ ((consigneeId == null) ? 0 : consigneeId.hashCode());
		result = prime * result
				+ ((consigneeName == null) ? 0 : consigneeName.hashCode());
		result = prime * result
				+ ((consigneePhone == null) ? 0 : consigneePhone.hashCode());
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
		Consignee other = (Consignee) obj;
		if (consigneeAddress == null) {
			if (other.consigneeAddress != null)
				return false;
		} else if (!consigneeAddress.equals(other.consigneeAddress))
			return false;
		if (consigneeId == null) {
			if (other.consigneeId != null)
				return false;
		} else if (!consigneeId.equals(other.consigneeId))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consignee [consigneeId=" + consigneeId + ", userId=" + userId
				+ ", consigneeName=" + consigneeName + ", consigneeAddress="
				+ consigneeAddress + ", consigneePhone=" + consigneePhone + "]";
	}

}
