package com.mygudou.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.ContractDAOImpl;
import com.mygudou.app.daoImp.XMLDAOimpl;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;
import com.mygudou.app.model.Matter;

/**
 * xml-->DB
 * */
@Service("XMLTransDBService")
@Transactional
public class XMLTransDBService {
	@Resource(name = "XMLDAO")
	private XMLDAOimpl XMLDAO;
	@Resource(name = "ItemDAO")
	private ContractDAOImpl ItemDAO;

	public void TransXmlToDB() throws Exception {

		/*
		 * File file = new File("src\\divorce1.xml");// //
		 * System.out.println(file.setReadOnly()+"fileread");
		 * 
		 * InputStream A = new FileInputStream(file); InputStream B = new
		 * FileInputStream(file); InputStream C = new FileInputStream(file);
		 * 
		 * List<Law> xml2 = XMLDAO.getDivorce2(C); Iterator<Law> la =
		 * xml2.iterator(); while (la.hasNext()) {
		 * 
		 * Law law = la.next(); if (ItemDAO.isNotExist(law)) {
		 * ItemDAO.insertLaw(law); }
		 * 
		 * }
		 * 
		 * Map<String, Object> map = XMLDAO.getDivorce1(B);// InputStream只能用一次
		 * List<Category> list = (List<Category>) map.get("category"); String
		 * lawName = (String) map.get("lawName");
		 * 
		 * for (Category ca : list) { if (ItemDAO.isNotExist(ca)) { // 判空
		 * ItemDAO.insertCategroy(ca, lawName);// 插入
		 * 
		 * } }
		 * 
		 * Map<String, Object> map1 = (Map<String, Object>)
		 * XMLDAO.getDivorce(A); List<Item> list1 = (List<Item>)
		 * map1.get("item"); List<String> lst3 = (List<String>)
		 * map1.get("categoryName");
		 * 
		 * for (int i = 0; i < list1.size(); i++) { Item itt = list1.get(i);
		 * String categoryName = lst3.get(i); if (ItemDAO.isNotExist(itt)) {
		 * ItemDAO.insertItem(itt, categoryName); } }
		 */
	}
}
