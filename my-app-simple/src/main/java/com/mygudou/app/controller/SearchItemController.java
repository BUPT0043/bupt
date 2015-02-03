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

import com.mygudou.app.Model.Category;
import com.mygudou.app.Model.Item;
import com.mygudou.app.Service.SearchItemService;

/**
 * 根据协议和分类查找相应条款
 */
@Controller
@RequestMapping(value = "/show")
public class SearchItemController {
    @Resource(name = "SearchItemService")
    private SearchItemService SearchItemService;

    Logger logger = Logger.getLogger(SearchItemController.class);

    @RequestMapping(value = "/searchItem", method = RequestMethod.POST)
    @ResponseBody
    public String searchItem(String badcause, @RequestParam("lawid") int lawid,
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
        net.sf.json.JSONArray jo = net.sf.json.JSONArray.fromObject(list);
        response.setContentType("text/html;charset=UTF-8"); // Ajax转码
        response.getWriter().print(jo.toString());
        return null;
    }

}
