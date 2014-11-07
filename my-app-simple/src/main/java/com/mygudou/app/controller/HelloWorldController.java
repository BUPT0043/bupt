package com.mygudou.app.controller;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		mv2.setViewName("firstshow");
		return mv2;   }

//	项目选择
	@RequestMapping(value = "/login")
	 public ModelAndView showCategory(String badcause) throws Exception {
		ModelAndView mv1 = new ModelAndView();
		mv1.setViewName("login");
		
		return mv1;    
	}
//	主界面登陆
	@RequestMapping(value = "/main")       
    public ModelAndView showItems(String badcause) throws Exception {    
    	ModelAndView mv = new ModelAndView();
        mv.addObject("items",XMLTransDBService.getList());//读refer data
        mv.addObject("category",XMLTransDBService.getCateogoryList());//读category_name
        mv.addObject("law",XMLTransDBService.getLawList());
        XMLTransDBService.TransXmlToDB();
        mv.setViewName("main");
        return mv;
        }
 
	}


