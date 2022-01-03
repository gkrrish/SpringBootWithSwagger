package com.example.app.model;

public class TopOrderResponse {
	private String itemName;
	private int totalOrders;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + totalOrders;
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
		TopOrderResponse other = (TopOrderResponse) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (totalOrders != other.totalOrders)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopOrderResponse [itemName=" + itemName + ", totalOrders="
				+ totalOrders + "]";
	}
	public TopOrderResponse(String itemName, int totalOrders) {
		super();
		this.itemName = itemName;
		this.totalOrders = totalOrders;
	}
	public TopOrderResponse() {
	}

}
