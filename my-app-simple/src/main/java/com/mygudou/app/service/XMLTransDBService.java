package com.mygudou.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    	
    	File file = new File("src\\divorce.xml");//
    	System.out.println(file.setReadOnly()+"fileread");
    	
		InputStream A =  new FileInputStream(file);
		InputStream B =  new FileInputStream(file);
		InputStream C =  new FileInputStream(file);
		
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
		
		Map<String,Object> map=XMLDAO.getDivorce1(B);//InputStream只能用一次
    	List<Category> list=(List<Category>) map.get("category");
    	System.out.println(list.size()+"---list---");
    	String lawName=(String) map.get("lawName");
    	
    	for(Category ca:list){
    		if(ItemDAO.isNotExist(ca)){	//判空
    			ItemDAO.insertCategroy(ca,lawName);//插入
    		}
    	}
		
    	Map<String,Object> map1=(Map<String, Object>) XMLDAO.getDivorce(A);
    	List<Item> list1=(List<Item>) map1.get("item");
    	List<String> lst3=(List<String>) map1.get("categoryName");
    	//String categoryName=(String) map1.get("categoryName");
    	//有问题？存的两个都是2.
    	for(int i=0;i<list1.size();i++){
    		Item itt=list1.get(i);
    		String categoryName=lst3.get(i);
    		if(ItemDAO.isNotExist(itt)){
    			ItemDAO.insertItem(itt,categoryName);
    		}

    	}
    	}
  //jsp获取Item\Category\Law
    public List<Item> getList(){
    	return ItemDAO.getItems();
    }
    public List<Category> getCateogoryList(int lawid){
    	
    	return ItemDAO.getCategory(lawid);
    }
    
   public List<Law> getLawList(){
   	
	return ItemDAO.getLaws();
    	
   }
   public Law getLaw(int lawid){
	   	
		return ItemDAO.getLaw(lawid);
	    	
	   }
    
   public Item getItem(int lawid,int categoryid){
	   return ItemDAO.getItem(lawid,categoryid);
   }
   public Category getCa(int lawid,int categoryid){
	   return ItemDAO.getCa(lawid,categoryid);
  
   }
}
