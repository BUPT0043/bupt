package com.mygudou.app.daoimp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.mygudou.app.dao.XMLDAO;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
@Repository("XMLDAO")
public class XMLDAOimpl implements XMLDAO{


	public List<Item> getDivorce(InputStream xml) throws Exception {
		
		List<Item> lst = null;
		Item it = null;
		XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
		XmlPullParser pullParser = pullParserFactory.newPullParser();
		pullParser.setInput(xml, "UTF-8");
		int event = pullParser.getEventType();// 调用方法，产生q事件
		String str="";
		
		while (event != XmlPullParser.END_DOCUMENT) {

			String nodeName = pullParser.getName();
			//System.out.println(nodeName+"=====");
			switch (event) {
			case XmlPullParser.START_DOCUMENT://文档开始
				lst = new LinkedList<Item>();
				break;
			case XmlPullParser.START_TAG:
				
			 if ("Data".equals(nodeName)) {
					it =new Item();
					String data = pullParser.nextText();
					it.setData(data.trim());
					//System.out.println(it.getData());	
				} 
			 if ("p".equals(nodeName)) {
					str+=pullParser.nextText()+"<br/>";	//换行
					//System.out.println(str+"------1---------");
					it.setRefer(str);	 
				}
			 //System.out.println(str+"------1---------");
			 //it.setRefer(str);
			 break;
			case XmlPullParser.END_TAG:
				if("Item".equals(nodeName)){
					it.setRefer(str);	
					lst.add(it);
					it=null;
					str="";
				}
				break;    
			}
			event=pullParser.next();
		}
		return lst;
	}
	public List<Category> getDivorce1(InputStream xml) throws Exception {
		List<Category> lst1 = null;
		List<Item> lst2=null;
		Item it=null;
		Category ca=null;
		XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
		XmlPullParser pullParser = pullParserFactory.newPullParser();
		pullParser.setInput(xml, "UTF-8");
		int event1 = pullParser.getEventType();// 调用方法，产生q事件
		String str="";
		
		while (event1 != XmlPullParser.END_DOCUMENT) {

			String nodeName = pullParser.getName();
			switch (event1) {
			case XmlPullParser.START_DOCUMENT://文档开始
				lst1 = new LinkedList<Category>();
				break;
			case XmlPullParser.START_TAG:
				
			 if ("Category".equals(nodeName)) {
				 ca=new Category();
				 it=new Item();
				 String name=pullParser.nextText(); 
				 ca.setCategoryname(name);
				 //it.setId(id);
				} 
			case XmlPullParser.END_TAG:
				if("Category".equals(nodeName)){
					lst1.add(ca);
					ca=null;
				}
				break;    
			}
			event1=pullParser.next();
		}
		System.out.println(lst1.size()+"=================");
		return lst1;
	}

}
