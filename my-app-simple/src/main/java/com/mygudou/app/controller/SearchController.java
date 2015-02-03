package com.mygudou.app.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.Model.Matter;
import com.mygudou.app.Service.SearchAjaxService;
import com.mygudou.app.Service.SearchService;

/**
 * 条款查询 Search+SearchAjax+SearchResult
 */
@Controller
@RequestMapping(value = "/show")
public class SearchController {
    @Resource(name = "SearchService")
    private SearchService SearchService;
    @Resource(name = "SearchAjaxService")
    private SearchAjaxService SearchAjaxService;

    Logger logger = Logger.getLogger(SearchController.class);

    // 搜索界面
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(String badcause,
            @RequestParam(value = "title", required = false) String title,
            HttpServletRequest request) throws Exception {

        System.out.println("HelloWorldController.search()");
        ModelAndView mv3 = new ModelAndView();
        mv3.addObject("title", title);
        mv3.addObject("matter", SearchService.getMattList(title, 0, 3));
        mv3.addObject("total", (SearchService.getMattTotal(title, 0, 3) + 1)/3);
        // SearchService.TransXmlToDB();
        mv3.setViewName("search");
        return mv3;
    }
    @RequestMapping(value = "/searchajax", method = RequestMethod.POST)
    public void searchAJAX(@RequestParam(value = "p") int p,
            @RequestParam(value = "curr") int curr,
            @RequestParam(value = "title") String title,
            HttpServletResponse response) throws Exception {
        List<Matter> list = SearchAjaxService.getMattList(title, p * 3, 3);
        try {
            net.sf.json.JSONArray jo = net.sf.json.JSONArray.fromObject(list);
            response.setContentType("text/html;charset=UTF-8"); // Ajax转码
            response.getWriter().print(jo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/searchresult", method = RequestMethod.GET)
    public ModelAndView searchresult(String badcause,
            @RequestParam(value = "id", required = false) String title, int id,
            HttpServletRequest request) throws Exception {
        ModelAndView mv4 = new ModelAndView();
        mv4.addObject("title", title);
        mv4.addObject("content", title);
        mv4.addObject("matter", SearchService.getMattAll(id));
        mv4.setViewName("searchresult");
        return mv4;
    }
}
