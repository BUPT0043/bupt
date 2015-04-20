package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mygudou.app.service.ContractService;
import com.mygudou.app.service.UserLoginService;

;
/**
 * user login page and register page controller
 */
@Controller
@RequestMapping(value = "/message")
public class MessageBoardController {



    /**
     * show the message board for the user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    public ModelAndView showRegisterPage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("message");
        return mv;
    }
    
}
