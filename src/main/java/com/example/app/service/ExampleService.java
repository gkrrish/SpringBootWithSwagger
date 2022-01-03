package com.example.app.service;

import com.example.app.model.ItemLastOrderedResponse;
import com.example.app.model.ItemWiseOrdersTodayResponse;
import com.example.app.model.MasterItemResponse;
import com.example.app.model.TopOrderResponse;

public interface ExampleService {
	public MasterItemResponse getCompletMenu();

	public String addNewMenuItem(String itemName, String costOfItem);

	public String updatePriceOfItem(String itemName, String newCostOfItem);

	public String order(String itemName, String quantity);

	public TopOrderResponse ordersSoldMost();

	public ItemLastOrderedResponse timeWhenOrderWasPlaced(String itemName);

	public ItemWiseOrdersTodayResponse itemWiseOrdersToday();

}
