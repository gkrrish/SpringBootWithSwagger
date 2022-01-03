package com.example.app.model;

import java.util.List;

public class MasterItemResponse {
	private List<MasterItems> masterItemList;

	public List<MasterItems> getMasterItemList() {
		return masterItemList;
	}

	public void setMasterItemList(List<MasterItems> masterItemList) {
		this.masterItemList = masterItemList;
	}

	public MasterItemResponse() {
	}

	public MasterItemResponse(List<MasterItems> masterItemList) {
		super();
		this.masterItemList = masterItemList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((masterItemList == null) ? 0 : masterItemList.hashCode());
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
		MasterItemResponse other = (MasterItemResponse) obj;
		if (masterItemList == null) {
			if (other.masterItemList != null)
				return false;
		} else if (!masterItemList.equals(other.masterItemList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MasterItemResponse [masterItemList=" + masterItemList + "]";
	}

}
