package com.mygudou.app.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.Service.LoginService;

/**
 * 合同生成-->登录（login）
 * */
@Controller
@RequestMapping(value = "/show")
public class LoginController {
	
	@Resource(name = "LoginService")
	private LoginService LoginService;
	Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login")
	public ModelAndView showCategory(String badcause) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("law", LoginService.getLawList());
		mv.setViewName("login");
		return mv;
	}

}
