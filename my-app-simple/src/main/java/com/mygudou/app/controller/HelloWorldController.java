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
    /**
     * 显示badcause的信息，按照Cluster_score倒序排列
     * @param 
     * @return
     * @throws Exception 
     */    
/*    @RequestMapping(value = "/index")        //②相对于①处的映射进行窄化
    public ModelAndView showFront(String badcause) throws Exception {
        ModelAndView mv = new ModelAndView();
        //拿到badcause名字和代号
        XMLTransDBService.TransXmlToDB();
        mv.addObject("hello","hello");
        //mv.addObject("",List);
        mv.setViewName("hello");
        return mv;
        }*/    
    @RequestMapping(value = "/main")       
    public ModelAndView showItems(String badcause) throws Exception {
       
    	ModelAndView mv = new ModelAndView();
        mv.addObject("items",XMLTransDBService.getList());//读refer data
        mv.addObject("category",XMLTransDBService.getCateogoryList());//读category_name
       // System.out.println(XMLTransDBService.getCateogoryList().size()+"--+++--");
       // int id = XMLTransDBService.getCateogoryList().get(0).getId();
        //System.out.println("\n\n\n id"+id);
        XMLTransDBService.TransXmlToDB();
        mv.setViewName("main");
        return mv;
        }
}
