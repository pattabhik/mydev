package com.practice.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.unittesting.beans.Item;
import com.practice.unittesting.dao.ItemRepository;

/**
 * @author Pattabhi
 *
 */
@Component
public class ItemService {

	@Autowired
	private ItemRepository itmRepo;

	public List<Item> retrieveAllItems() {
		return itmRepo.findAll();
	}

	/**
	 * @return
	 */
	public Item getItem() {
		System.out.println();
		return new Item(1, "Orange", 2, 12);
	}

}
