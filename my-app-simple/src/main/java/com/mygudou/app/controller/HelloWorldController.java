package com.mygudou.app.controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.service.XMLTransDBService;

@Controller
@RequestMapping(value="/show" )  
public class HelloWorldController{
    @Resource(name = "XMLTransDBService")
    private XMLTransDBService XMLTransDBService;	
	Logger logger = Logger.getLogger(HelloWorldController.class); 
	
//	首页
	@RequestMapping(value = "/firstshow")
	 public ModelAndView showfirst(String badcause) throws Exception {
		ModelAndView mv2 = new ModelAndView();
//	    mv2.addObject("items",XMLTransDBService.getList());//读refer data
//	    mv2.addObject("category",XMLTransDBService.getCateogoryList(lawid));//读category_name
//      mv2.addObject("lawid",lawid);
//      mv2.addObject("law",XMLTransDBService.getLaw(lawid));
        XMLTransDBService.TransXmlToDB();
		mv2.setViewName("firstshow");
		return mv2;   
		}

//	项目选择
	@RequestMapping(value = "/login")
	 public ModelAndView showCategory(String badcause) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("law",XMLTransDBService.getLawList());
		mv.setViewName("login");
		
		return mv;    
	}
	
//	主界面登陆
	@RequestMapping(value = "/main" ,method=RequestMethod.GET)       
    public ModelAndView showItems(String badcause,@RequestParam("lawid") int lawid) throws Exception {    
    	ModelAndView mv = new ModelAndView();
       // mv.addObject("items",XMLTransDBService.getList());//读refer data
        mv.addObject("category",XMLTransDBService.getCateogoryList(lawid));//读category_name
        mv.addObject("lawid",lawid);
        mv.addObject("law",XMLTransDBService.getLaw(lawid));
        XMLTransDBService.TransXmlToDB();
        mv.setViewName("main");
        return mv;
        }
	
//	根据协议和分类查找相应的条款
	@RequestMapping(value = "/searchItem" ,method=RequestMethod.POST)   
	@ResponseBody
    public String searchItem(String badcause,@RequestParam("lawid") int lawid,@RequestParam("categoryids") String categoryids,HttpServletResponse response) throws Exception {    
		response.setCharacterEncoding("UTF-8");
		
    	 List<Item> list=new ArrayList<Item>();
    	 List<Category> list1=new ArrayList<Category>();
    	 
    	 for(String s:categoryids.split(",")){
    		 int categoryid=Integer.valueOf(s);
    		 if(categoryid>0){
    			list.add(XMLTransDBService.getItem(lawid,categoryid));
    			list1.add(XMLTransDBService.getCa(lawid, categoryid));
    		 }
    	 }
    	 
    	 net.sf.json.JSONArray jo=net.sf.json.JSONArray.fromObject(list);
    	 response.setContentType("text/html;charset=UTF-8");   //Ajax转码
         response.getWriter().print(jo.toString());    
		 return null;
        }
 
	}


