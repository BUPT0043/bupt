package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;


public interface ItemDAO {
	
	//insert
	public int insertItem(Item item);
//	public void insertCategory(Category category);
	public int insertLaw(Law law);
	
	//select
	public List<Law> getLaws();
	public List<Item> getItems();
	public List<Category> getCategory();
	//判空
	public boolean isNotExist(Law law);
	public boolean isNotExist(Category category);
	public boolean isNotExist(Item item);
	
}
