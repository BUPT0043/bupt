package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import scala.Int;

import com.mygudou.app.model.User;
import com.mygudou.app.service.ContractService;
import com.mygudou.app.service.UserLoginService;

;
/**
 * user login page and register page controller
 */
@Controller
@RequestMapping(value = "/user")
public class UserLoginController {

    @Resource(name = "UserLoginService")
    private UserLoginService UserLoginService;
    
    /**
     * check the user info, and go to the new index after logined
     * @param title
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logined")
    public ModelAndView showfirst(
    		String optionsRadios,String username,String password)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("indexAfterLogin");
        return mv;
    }
    
    /**
     * register a new user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request)
            throws Exception {
        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("username");
        String role = request.getParameter("optionsRadios").toString();
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String sex = request.getParameter("optionsRadiosinline").toString();

        User user = new User();
        user.setUsername(username);
        user.setRole(role);
        user.setPwd(pwd);
        user.setEmail(email);
        user.setSex(sex);

        UserLoginService.insertUser(user);
        mv.setViewName("indexAfterLogin");
        return mv;
    }
    /**
     * go to the register page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/registershow")
    public ModelAndView showRegisterPage() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
    /**
     * go to the login page
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/login")
	public ModelAndView showCategory() throws Exception {
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("login");
		return mv;
	}
}
