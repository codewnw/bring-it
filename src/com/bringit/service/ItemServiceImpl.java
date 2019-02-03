package com.bringit.service;

import java.util.List;

import com.bringit.dao.ItemDao;
import com.bringit.dao.ItemDaoImpl;
import com.bringit.model.Item;

public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;

	public ItemServiceImpl() {
		itemDao = new ItemDaoImpl();
	}

	@Override
	public int saveItem(Item item) {
		return itemDao.saveItem(item);
	}

	@Override
	public int updateItem(Item item) {
		return itemDao.updateItem(item);
	}

	@Override
	public int deleteItem(String itemId) {
		return itemDao.deleteItem(itemId);
	}

	@Override
	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

}
