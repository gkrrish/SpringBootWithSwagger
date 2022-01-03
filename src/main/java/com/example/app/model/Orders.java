package com.example.app.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TX_ORDERS")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private String id;
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Column(name = "SOLD_DATE")
	private Date creationDate;
	@Column(name = "NUMBER_OF_ORDERS_TODAY")
	private int numberOfOrdersToday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getNumberOfOrdersToday() {
		return numberOfOrdersToday;
	}

	public void setNumberOfOrdersToday(int numberOfOrdersToday) {
		this.numberOfOrdersToday = numberOfOrdersToday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + numberOfOrdersToday;
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
		Orders other = (Orders) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (numberOfOrdersToday != other.numberOfOrdersToday)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", itemName=" + itemName + " creationDate=" + creationDate
				+ ", numberOfOrdersToday=" + numberOfOrdersToday + "]";
	}

	public Orders() {
	}

	public Orders(String id, String itemName, int price, Date creationDate,
			int numberOfOrdersToday) {
		this.id = id;
		this.itemName = itemName;
		this.creationDate = creationDate;
		this.numberOfOrdersToday = numberOfOrdersToday;
	}

}
