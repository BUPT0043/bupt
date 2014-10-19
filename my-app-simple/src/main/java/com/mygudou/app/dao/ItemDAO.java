package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;

public interface ItemDAO {
	
	public int insertItem(Item item);
	public List<Item> getItems();
	public List<Category> getCategory();
	//判空
	public boolean isNotExist(Category category);
	public boolean isNotExist(Item item);
	
}
