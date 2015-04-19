package com.mygudou.app.controller;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.service.ContractService;
import com.mygudou.app.service.SearchItemService;


/**
 * 合同Word+Download
 */
@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Resource(name = "ContractService")
	private ContractService ContractService;
    
    @Resource(name = "SearchItemService")
    private SearchItemService SearchItemService;
    /**
     * the contract chose page
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/chose")
	public ModelAndView showCategory() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("law", ContractService.getLawList());
		mv.setViewName("contractChose");
		return mv;
	}
	/**
	 * we get the details and chose what we need in the contract, we can generate word in latter steps
	 * @param lawid
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public ModelAndView showItems(@RequestParam("lawid") int lawid) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("category", SearchItemService.getCateogoryList(lawid));
        mv.addObject("lawid", lawid);
        mv.addObject("law", SearchItemService.getLaw(lawid));        
        mv.setViewName("contractGenerate");
        return mv;
    }
    
    /**
     * get the main items of this contract
     * @param lawid
     * @param categoryids
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/searchItem", method = RequestMethod.POST)
    @ResponseBody
    public String searchItem(@RequestParam("lawid") int lawid,
            @RequestParam("categoryids") String categoryids,
            HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        List<Item> list = new ArrayList<Item>();
        List<Category> list1 = new ArrayList<Category>();
        for (String s: categoryids.split(",")) {
            int categoryid = Integer.valueOf(s);
            if (categoryid > 0) {
                list.add(SearchItemService.getItem(lawid, categoryid));
                list1.add(SearchItemService.getCa(lawid, categoryid));
            }
        }
        String jo=JSON.toJSONString(list); 
        response.setContentType("text/html;charset=UTF-8"); // Ajax转码
        response.getWriter().print(jo.toString());
        return null;
    }
    
	/**
	 * Generate a word file
	 * @param param
	 * @param request
	 * @param response
	 */
    @RequestMapping(value = "/toWord")    
    public void toWord(@RequestParam("param") String param,
            HttpServletRequest request, HttpServletResponse response) {
        Document document = new Document(PageSize.A4);
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + "/download/";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String name = sdf.format(new Date());
        try {
            RtfWriter2.getInstance(document, new FileOutputStream(ctxPath
                    + name + ".doc"));
            document.open();
            Font font = new Font(Font.NORMAL, 20, Font.BOLD, new Color(0, 0, 0));
            Paragraph p = new Paragraph("合同", font);
            p.setAlignment(1);
            document.add(p);
            /**
             * <p>
             * 标记，切割 st[0]input st[1]input context st[2]input over
             */
            String[] sa = param.trim().split(",");
            for (String str: sa) {
                System.out.println("str   " + str);
                if (!"".equals(str)) {
                    String st[] = str.split("⋚");
                    Chunk c0 = new Chunk(st[0]);
                    Paragraph para = new Paragraph();
                    para.add(c0);
                    for (int i = 1; i < st.length; i++) {
                        Font f = new Font(Font.UNDERLINE);
                        Chunk c = new Chunk(st[i]);
                        if (i % 2 == 1) {
                            c.setFont(FontFactory.getFont(FontFactory.TIMES,
                                    11, Font.UNDERLINE));
                        }
                        para.add(c);
                    }
                    para.setIndentationLeft(20);
                    para.setFirstLineIndent(5f);
                    para.setSpacingAfter(-5f);
                    para.setSpacingBefore(-5f);
                    document.add(para);
                }
            }
            Font font1 = new Font(Font.NORMAL, 13, Font.BOLD,
                    new Color(0, 0, 0));
            Paragraph para1 = new Paragraph("甲方：", font1);
            Paragraph para2 = new Paragraph("乙方：", font1);
            Paragraph para3 = new Paragraph("日期：", font1);

            para1.setIndentationLeft(20);
            para2.setIndentationLeft(20);
            para3.setIndentationLeft(20);

            para1.setSpacingBefore(5f);
            para2.setSpacingBefore(5f);
            para3.setSpacingBefore(5f);

            para1.setAlignment(3);
            para2.setAlignment(3);
            para3.setAlignment(3);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.close();

        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String fileName = name + ".doc";
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter print = response.getWriter();
            print.print(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * download the file to your own computer
     * @param fileName
     * @param request
     * @param response
     */
    @RequestMapping(value = "/download")   
    public void download(@RequestParam("fileName") String fileName,
            HttpServletRequest request, HttpServletResponse response) {
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + "/download/";
        File downloadFile = new File(ctxPath + fileName);
        response.addHeader("Content-Disposition", "attachment;filename="
                + fileName);
        response.addHeader("Content-Length", "" + downloadFile.length());
        response.setContentType("application/msword");
        response.setCharacterEncoding("utf-8");
        InputStream fis = null;
        OutputStream os = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(downloadFile));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            os = new BufferedOutputStream(response.getOutputStream());
            os.write(buffer);// 输出文件
            os.flush();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fis = null;
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    os = null;
                }
            }

        }
    }

}
