package com.example.app.model;

import java.util.Map;

public class ItemWiseOrdersTodayResponse {
	private Map<String, Integer> totalOrders;

	public Map<String, Integer> getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(Map<String, Integer> totalOrders) {
		this.totalOrders = totalOrders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((totalOrders == null) ? 0 : totalOrders.hashCode());
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
		ItemWiseOrdersTodayResponse other = (ItemWiseOrdersTodayResponse) obj;
		if (totalOrders == null) {
			if (other.totalOrders != null)
				return false;
		} else if (!totalOrders.equals(other.totalOrders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemWiseOrdersTodayResponse [totalOrders=" + totalOrders + "]";
	}

	public ItemWiseOrdersTodayResponse(Map<String, Integer> totalOrders) {
		super();
		this.totalOrders = totalOrders;
	}

	public ItemWiseOrdersTodayResponse() {
	}



	
}
