package com.example.app.model;

import java.sql.Date;

public class ItemLastOrderedResponse {
	private String itemName;
	private Date lastOrderedTime;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getLastOrderedTime() {
		return lastOrderedTime;
	}
	public void setLastOrderedTime(Date lastOrderedTime) {
		this.lastOrderedTime = lastOrderedTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((lastOrderedTime == null) ? 0 : lastOrderedTime.hashCode());
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
		ItemLastOrderedResponse other = (ItemLastOrderedResponse) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (lastOrderedTime == null) {
			if (other.lastOrderedTime != null)
				return false;
		} else if (!lastOrderedTime.equals(other.lastOrderedTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItemLastOrderedResponse [itemName=" + itemName
				+ ", lastOrderedTime=" + lastOrderedTime + "]";
	}
	public ItemLastOrderedResponse(String itemName, Date lastOrderedTime) {
		super();
		this.itemName = itemName;
		this.lastOrderedTime = lastOrderedTime;
	}
	public ItemLastOrderedResponse() {
		// TODO Auto-generated constructor stub
	}

}
