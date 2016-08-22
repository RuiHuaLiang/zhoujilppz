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
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer addressId;
	private Integer parentId;
	private String addressName;

	public Address() {
	}

	public Address(Integer addressId, Integer parentId, String addressName) {
		super();
		this.addressId = addressId;
		this.parentId = parentId;
		this.addressName = addressName;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result
				+ ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
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
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", parentId=" + parentId
				+ ", addressName=" + addressName + "]";
	}

}
