package com.mygudou.app.dao;

import java.io.InputStream;
import java.util.List;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;


public interface XMLDAO {
	
	public List<Item> getDivorce(InputStream xml) throws Exception; 
	public List<Category> getDivorce1(InputStream xml) throws Exception; 
	public List<Law> getDivorce2(InputStream xml) throws Exception; 

}
