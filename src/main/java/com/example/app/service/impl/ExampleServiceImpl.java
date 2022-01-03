package com.example.app.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.exception.ItemNotAvailableInMasterMenuException;
import com.example.app.exception.ItemWasRegisteredPreviousException;
import com.example.app.exception.NoOrdersYetException;
import com.example.app.model.ItemLastOrderedResponse;
import com.example.app.model.ItemWiseOrdersTodayResponse;
import com.example.app.model.MasterItemResponse;
import com.example.app.model.MasterItems;
import com.example.app.model.Orders;
import com.example.app.model.TopOrderResponse;
import com.example.app.repository.ExampleOrderRepository;
import com.example.app.repository.ExampleRepository;
import com.example.app.service.ExampleService;

@Service
public class ExampleServiceImpl implements ExampleService {
	@Autowired
	ExampleRepository exampleRepository;
	@Autowired
	ExampleOrderRepository exampleOrderRepository;

	@Override
	public MasterItemResponse getCompletMenu() {

		List<MasterItems> masterItemsList = (List<MasterItems>) exampleRepository
				.findAll();

		MasterItemResponse masterResponse = new MasterItemResponse();
		masterResponse.setMasterItemList(masterItemsList);

		return masterResponse;
	}

	@Override
	public String addNewMenuItem(String itemName, String costOfItem) {
		String response;
		itemName.toUpperCase();
		MasterItems masterItemsObject = new MasterItems();
		masterItemsObject.setCreationDate(new Date(System.currentTimeMillis()));
		masterItemsObject.setItemName(itemName.toUpperCase());
		masterItemsObject.setPrice(Integer.parseInt(costOfItem));
		List<MasterItems> masterItemsList = exampleRepository
				.findMenuItemName(itemName.toUpperCase());

		if (masterItemsList.size() == 0) {

			exampleRepository.save(masterItemsObject);
			response = itemName.toUpperCase()
					+ " has been placed successfully!";
		} else {
			response = itemName.toUpperCase()
					+ " already available in menu list ! Thanks";
			throw new ItemWasRegisteredPreviousException(
					"already available in menu list ! Thanks");
		}
		return response;
	}

	@Override
	public String updatePriceOfItem(String itemName, String newCostOfItem) {
		String response;
		itemName.toUpperCase();
		MasterItems masterItemsObject = new MasterItems();
		masterItemsObject.setCreationDate(new Date(System.currentTimeMillis()));
		masterItemsObject.setItemName(itemName.toUpperCase());
		masterItemsObject.setPrice(Integer.parseInt(newCostOfItem));
		List<MasterItems> masterItemsList = exampleRepository
				.findMenuItemName(itemName.toUpperCase());

		if (!(masterItemsList.get(0).getPrice() == Integer
				.parseInt(newCostOfItem))) {
			exampleRepository.updatePriceOfItem(
					masterItemsObject.getItemName(),
					masterItemsObject.getPrice());
			response = itemName.toUpperCase() + " price " + newCostOfItem
					+ " has been placed successfully!";
		} else {
			response = itemName.toUpperCase() + " price " + newCostOfItem
					+ " already have same price of the item ! Thanks";
			throw new ItemWasRegisteredPreviousException(
					" already have same price of the item ! Thanks");
		}
		return response;
	}

	@Override
	public String order(String itemName, String quantity) {
		String response;
		itemName.toUpperCase();
		List<MasterItems> masterItemsList = exampleRepository
				.findMenuItemName(itemName.toUpperCase());

		if (masterItemsList.size() > 0
				&& masterItemsList.get(0).getItemName()
						.equalsIgnoreCase(itemName)) {

			int countOfOrders = exampleOrderRepository.findTotalOrders(itemName
					.toUpperCase());
			countOfOrders = countOfOrders + (Integer.parseInt(quantity));

			// if item is not there transaction table then create new item from
			// masterItems
			Orders orders = new Orders();
			orders.setCreationDate(new Date(System.currentTimeMillis()));
			orders.setNumberOfOrdersToday(countOfOrders);
			orders.setItemName(masterItemsList.get(0).getItemName());

			exampleOrderRepository.order(orders.getItemName().toUpperCase(),
					orders.getNumberOfOrdersToday(), orders.getCreationDate());
			countOfOrders = 0;
			int priceOfEachItem = masterItemsList.get(0).getPrice();
			response = itemName + " has been placed successfully! Bill is : "
					+ priceOfEachItem * Integer.parseInt(quantity);
			priceOfEachItem = 0;
		} else {
			response = itemName
					+ " has not listed in Master Menu please add ! ";
			throw new ItemNotAvailableInMasterMenuException(
					"Please add this item into master menu table !");

		}

		return response;
	}

	@Override
	public TopOrderResponse ordersSoldMost() {
		List<Orders> ordersList = (List<Orders>) exampleOrderRepository
				.findAll();
		String itemFlagName = null;
		TopOrderResponse topOrderResponse = new TopOrderResponse();
		int flag = 0;
		if (!ordersList.isEmpty()) {
			for (int i = 0; i < ordersList.size(); i++) {
				if (ordersList.get(i).getNumberOfOrdersToday() > flag) {
					flag = flag + ordersList.get(i).getNumberOfOrdersToday();
					itemFlagName = ordersList.get(i).getItemName();
				}

			}
			topOrderResponse.setItemName(itemFlagName);
			topOrderResponse.setTotalOrders(flag);

		} else {
			topOrderResponse
					.setItemName("No orders has been placed up to now ! ");
			topOrderResponse.setTotalOrders(flag);
			throw new NoOrdersYetException(
					"No orders has been placed up to now !");
		}
		return topOrderResponse;
	}

	@Override
	public ItemLastOrderedResponse timeWhenOrderWasPlaced(String itemName) {
		Date dateOrderPlacedLast = exampleOrderRepository
				.findTimeOrderedLast(itemName.toUpperCase());
		ItemLastOrderedResponse response = new ItemLastOrderedResponse();
		response.setItemName(itemName.toUpperCase());
		response.setLastOrderedTime(dateOrderPlacedLast);

		return response;
	}

	@Override
	public ItemWiseOrdersTodayResponse itemWiseOrdersToday() {
		List<Orders> totalOrders = (List<Orders>) exampleOrderRepository
				.findAll();
		ItemWiseOrdersTodayResponse itemWiseOrdersTodayreponse = new ItemWiseOrdersTodayResponse();

		Map<String, Integer> localMap = new HashMap<>();
		if (!totalOrders.isEmpty()) {
			for (int i = 0; i < totalOrders.size(); i++) {
				Integer intObjectValue = new Integer(totalOrders.get(i)
						.getNumberOfOrdersToday());
				localMap.put(totalOrders.get(i).getItemName(), intObjectValue);
			}
			itemWiseOrdersTodayreponse.setTotalOrders(localMap);
		}
		return itemWiseOrdersTodayreponse;
	}

}
