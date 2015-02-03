package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.Service.DownloadService;
import com.mygudou.app.Service.PrintToWordService;
import com.mygudou.app.Service.SearchItemService;
import com.mygudou.app.Service.SearchService;
import com.mygudou.app.Service.XMLTransDBService;

/**
 * 首页+主界面
 */
@Controller
@RequestMapping(value = "/show")
public class FirstShowController {
    @Resource(name = "XMLTransDBService")
    private XMLTransDBService XMLTransDBService;

    @Resource(name = "SearchService")
    private SearchService SearchService;

    @Resource(name = "SearchItemService")
    private SearchItemService SearchItemService;
    Logger logger = Logger.getLogger(FirstShowController.class);
    
    @RequestMapping(value = "/firstshow")
    public ModelAndView showfirst(String badcause,
            @RequestParam(value = "title", required = false) String title)
            throws Exception {
        ModelAndView mv2 = new ModelAndView();
        mv2.addObject("matter", SearchService.getMattList(title, 0, 3));
        XMLTransDBService.TransXmlToDB();
        mv2.setViewName("firstshow");
        return mv2;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView showItems(String badcause,
            @RequestParam("lawid") int lawid) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("category", SearchItemService.getCateogoryList(lawid));
        mv.addObject("lawid", lawid);
        mv.addObject("law", SearchItemService.getLaw(lawid));
        XMLTransDBService.TransXmlToDB();
        mv.setViewName("main");
        return mv;
    }

}
