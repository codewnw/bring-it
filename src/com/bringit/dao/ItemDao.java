package com.bringit.dao;

import java.util.List;

import com.bringit.model.Item;

public interface ItemDao {
	void createItemTable();
	
	int saveItem(Item item);

	int updateItem(Item item);

	int deleteItem(String itemId);

	Item getItem(String itemId);

	List<Item> getItems();
}
