package com.mygudou.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.Service.RegisterService;;

/**
 * 用户注册
 */
@Controller
@RequestMapping(value = "/show")
public class RegisterController {
    @Resource(name = "RegisterService")
    private RegisterService RegisterService;

    @RequestMapping(value = "/register")
    public ModelAndView showfirst(String badcause) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

}
