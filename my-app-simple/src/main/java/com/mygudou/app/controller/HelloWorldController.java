package com.mygudou.app.controller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import com.lowagie.text.Document;  
import com.lowagie.text.DocumentException;  
import com.lowagie.text.Element;  
import com.lowagie.text.Font;  
import com.lowagie.text.PageSize;  
import com.lowagie.text.Paragraph;  
import com.lowagie.text.Table;  
import com.lowagie.text.pdf.BaseFont;  
import com.lowagie.text.rtf.RtfWriter2;  
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

//	打印word
	@RequestMapping(value = "/toWord" ,method=RequestMethod.GET)       
	public ModelAndView toWord(@RequestParam("param")String param){
		ModelAndView mv = new ModelAndView();
		com.lowagie.text.Document doc = new com.lowagie.text.Document();

        try {

            // 定义输出位置并把文档对象装入输出对象中

            
            RtfWriter2.getInstance(doc, new FileOutputStream("d://合同.doc"));

            // 打开文档对象
            doc.open();
            
            // 加入文字
//            	System.out.println(param);
        	   String []sa = param.trim().split(",（");
        	   String content = "";
               for(String str : sa){
            	   System.out.println("str   "+str);
               	if(!"".equals(str)){
               		content+=str+"\n（";
               	}
               	
               }
               System.out.println("content "+content);
               doc.add(new Paragraph(content.substring(0,content.length()-1)));

            // 关闭文档对象，释放资源

            doc.close();

        } catch (com.lowagie.text.DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		mv.setViewName("toWord");
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


