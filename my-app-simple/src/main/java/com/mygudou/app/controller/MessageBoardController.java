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

/**
 * 留言板，简单的实现是个人只能看到未读消息list，并可以去关注者的主页查看两人的聊天记录
 * @author gufeng
 *
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
