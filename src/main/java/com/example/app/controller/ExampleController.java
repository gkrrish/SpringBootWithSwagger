package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.ItemLastOrderedResponse;
import com.example.app.model.ItemWiseOrdersTodayResponse;
import com.example.app.model.MasterItemResponse;
import com.example.app.model.TopOrderResponse;
import com.example.app.service.ExampleService;

@RestController
@RequestMapping("/example")
public class ExampleController {

	@Autowired
	ExampleService exampleService;

	@GetMapping("/completeMenu")
	public MasterItemResponse getCompletMenu() {

		return exampleService.getCompletMenu();

	}

	@GetMapping(value = "/addNewMenuItem/{itemName}/{costOfItem}")
	public String addNewMenuItem(@PathVariable("itemName") String itemName,
			@PathVariable("costOfItem") String costOfItem) {

		return exampleService.addNewMenuItem(itemName, costOfItem);
	}

	@GetMapping(value = "/updatePriceOfItem/{itemName}/{newCostOfItem}")
	public String updatePriceOfItem(@PathVariable("itemName") String itemName,
			@PathVariable("newCostOfItem") String newCostOfItem) {
		return exampleService.updatePriceOfItem(itemName, newCostOfItem);
	}

	@GetMapping(value = "/order/{itemName}/{quantity}")
	public String order(@PathVariable("itemName") String itemName,
			@PathVariable("quantity") String quantity) {
		return exampleService.order(itemName, quantity);
	}

	@GetMapping(value = "/orderSoldMost")
	public TopOrderResponse orderSoldMost() {
		return exampleService.ordersSoldMost();
	}

	@GetMapping(value = "/timeWhenOrderWasPlaced/{itemName}")
	public ItemLastOrderedResponse timeWhenOrderWasPlaced(
			@PathVariable("itemName") String itemName) {
		return exampleService.timeWhenOrderWasPlaced(itemName);
	}

	@GetMapping(value = "/itemWiseOrdersToday")
	public ItemWiseOrdersTodayResponse itemWiseOrdersToday() {
		return exampleService.itemWiseOrdersToday();
	}

}
