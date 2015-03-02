package com.mygudou.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.service.IndexService;

/**
 * 首页登录
 */
@Controller
@RequestMapping(value = "/show")
public class IndexController {

    @Resource(name = "IndexService")
    private IndexService IndexService;

    @RequestMapping(value = "/index")
    public ModelAndView showfirst() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
