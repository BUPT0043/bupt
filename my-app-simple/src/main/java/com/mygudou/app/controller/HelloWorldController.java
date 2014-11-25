package com.mygudou.app.controller;
import java.awt.Color;
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

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
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
		 Document document = new Document(PageSize.A4); 
		ModelAndView mv = new ModelAndView();
//		com.lowagie.text.Document doc = new com.lowagie.text.Document();

        try {
            RtfWriter2.getInstance(document, new FileOutputStream("C://Users//Administrator//Desktop//合同.doc"));
            // 打开文档对象
            document.open();
//            设置文本格式
            Font font = new Font(Font.NORMAL, 20, Font.BOLD, new Color(0, 0, 0)); 
            // 设置新的段落，使其字体为font  
            Paragraph p = new Paragraph("合同", font); 
            // 设置段落居中，其中1为居中对齐，2为右对齐，3为左对齐  
            p.setAlignment(1); 
            // 文档中加入该段落  
            document.add(p); 
            
    	    String []sa = param.trim().split(",");
//    	     用特殊字符 进行<p>标记，然后切割，st[0]input st[1]input context st[2]input over st[3]next inputs
    	    for(String str : sa){
        	    System.out.println("str   "+str);
            	if(!"".equals(str)){
           		 String st[] = str.split("⋚");
           		 Chunk c0 = new Chunk(st[0]);
           		 Paragraph para=new Paragraph();
           		 para.add(c0);
           		 for(int i=1;i<st.length;i++){
           			 Font f = new Font(Font.UNDERLINE);
           			 
           			Chunk c=new Chunk(st[i]);
               		 if(i%2==1){
               			 c.setFont(FontFactory.getFont(FontFactory.TIMES,12,Font.UNDERLINE));
               		 }
               		para.add(c);
           		 }
           		
                para.setIndentationLeft(20); 
                // 设置首行缩进  
                para.setFirstLineIndent(5f); 
                // 设置段后距和段前距  
                para.setSpacingAfter(10f); 
                para.setSpacingBefore(10f); 
                document.add(para);
            	}
            }
    	    
    	    
            Font font1 = new Font(Font.NORMAL, 13, Font.BOLD, new Color(0, 0, 0)); 
            Paragraph para1=new Paragraph("甲方：",font1);
            Paragraph para2=new Paragraph("乙方：",font1);
            Paragraph para3=new Paragraph("日期：",font1);
            
            para1.setIndentationLeft(20);
            para2.setIndentationLeft(20);
            para3.setIndentationLeft(20);
//          段后间距
            para1.setSpacingBefore(10f);
            para2.setSpacingBefore(10f);
            para3.setSpacingBefore(10f);
            
            para1.setAlignment(3); 
            para2.setAlignment(3); 
            para3.setAlignment(3); 
//          文档中加入该段落  
            document.add(para1); 
            document.add(para2); 
            document.add(para3); 
//          关闭文档对象，释放资源
           document.close();

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


