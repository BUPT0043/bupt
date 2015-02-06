package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.Model.User;
import com.mygudou.app.Service.UserLoginService;

;
/**
 * 主页用户登录
 */
@Controller
@RequestMapping(value = "/show")
public class UserLoginController {

    @Resource(name = "UserLoginService")
    private UserLoginService UserLoginService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ModelAndView userLogin(String badcause, HttpServletRequest request)
            throws Exception {
        ModelAndView mv = new ModelAndView();

        String userId = request.getParameter("userid");
        String role = request.getParameter("userrole");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        
        User user = new User();
        user.setUserId(userId);
        user.setRole(role);
        user.setPwd(pwd);
        user.setEmail(email);
        user.setSex(sex);
        
        UserLoginService.insertUser(user);
        mv.setViewName("userLogin");
        return mv;
    }
}
