package com.practice.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.unittesting.beans.Item;
import com.practice.unittesting.constants.ControllerMappings;
import com.practice.unittesting.service.ItemService;

/**
 * @author Pattabhi
 *
 */
@RestController
public class ItemController {

	@Autowired
	private ItemService itmSrvc;

	@GetMapping(ControllerMappings.DUMMY_ITEM_GET_URL)
	public Item helloWorld() {
		Item itm = new Item(1, "Orange", 2, 12);
		return itm;
	}

	@GetMapping(ControllerMappings.ITEM_BY_SERVICE_GET_URL)
	public Item getItemfromService() {
		return itmSrvc.getItem();
	}

	@GetMapping(ControllerMappings.FETCH_ALL_ITEMS_BY_SERVICE_GET_URL)
	public List<Item> getAllItemfromService() {
		return itmSrvc.retrieveAllItems();
	}
}
