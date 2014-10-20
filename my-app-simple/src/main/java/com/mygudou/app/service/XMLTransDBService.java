package com.mygudou.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoimp.ItemDAOImpl;
import com.mygudou.app.daoimp.XMLDAOimpl;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;
@Service("XMLTransDBService")
@Transactional
public class XMLTransDBService {
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;
    @Resource(name = "ItemDAO")
    private ItemDAOImpl ItemDAO;
    
    public void TransXmlToDB() throws Exception{
    	
    	File file = new File("src\\divorce.xml");
		InputStream A =  new FileInputStream(file);
		InputStream B =  new FileInputStream(file);
		InputStream C =  new FileInputStream(file);
		List<Item> xmls=XMLDAO.getDivorce(A);		
		
		Iterator<Item> it=xmls.iterator();
    	while(it.hasNext()){
    		Item item=it.next();
    		
    		if(ItemDAO.isNotExist(item)){
    			ItemDAO.insertItem(item);
    		}
    		else{
    			
    		}
    	}
    	
		List<Category> xml1=XMLDAO.getDivorce1(B);//InputStream只能用一次
    	Iterator<Category> ca=xml1.iterator();
    	while(ca.hasNext()){
    		
    		Category category=ca.next();
    		if(ItemDAO.isNotExist(category)){	//判空
    			ItemDAO.insertCategroy(category);//插入
    		}
    		else{
    		
    		}
    		
    		
    	}
    	List<Law> xml2=XMLDAO.getDivorce2(C);
    	Iterator<Law> la=xml2.iterator();
    	while(la.hasNext()){
    		
    		Law law=la.next();
    		if(ItemDAO.isNotExist(law)){	
    			ItemDAO.insertLaw(law);
    		}
    		else{
    		
    		}
    		
    		
    	}
    	
    }
    //jsp获取Item\Category\Law
    public List<Item> getList(){
    	return ItemDAO.getItems();
    }
    public List<Category> getCateogoryList(){
    	
    	return ItemDAO.getCategory();
    }
//    public List<Law> getLawList(){
//    	
//		return ItemDAO.getLaws();
//    	
//    }
    
}
