package com.bringit.service;

import java.util.List;

import com.bringit.model.Item;

public interface ItemService {
	int saveItem(Item item);

	int updateItem(Item item);

	int deleteItem(String itemId);

	Item getItem(String itemId);

	List<Item> getItems();
}
