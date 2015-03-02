package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mygudou.app.service.SearchItemService;
import com.mygudou.app.service.SearchService;
import com.mygudou.app.service.XMLTransDBService;

/**
 * we can use this url to translate date from XML to database, and check if it work in the database
 */
@Controller
@RequestMapping(value = "/transfer")
public class DateFormatController {
    @Resource(name = "XMLTransDBService")
    private XMLTransDBService XMLTransDBService;

    @Resource(name = "SearchService")
    private SearchService SearchService;

    @Resource(name = "SearchItemService")
    private SearchItemService SearchItemService;
    Logger logger = Logger.getLogger(DateFormatController.class);
    
    @RequestMapping(value = "/start")
    public ModelAndView showfirst(String badcause,
            @RequestParam(value = "title", required = false) String title)
            throws Exception {
        ModelAndView mv2 = new ModelAndView();
        mv2.addObject("matter", SearchService.getMattList(title, 0, 3));
        XMLTransDBService.TransXmlToDB();
        mv2.setViewName("");
        return mv2;
    }



}
