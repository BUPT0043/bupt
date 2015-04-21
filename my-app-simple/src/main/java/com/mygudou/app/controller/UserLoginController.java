package com.mygudou.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.model.Customer;
import com.mygudou.app.model.Lawyer;
import com.mygudou.app.model.User;
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
        System.out.println(username);
        String role = request.getParameter("optionsRadios").toString();
        System.out.println(username);
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String sex = request.getParameter("optionsRadiosinline").toString();

        User user;
        if(role.equals("0"))
        	user=new Customer();
        else 
        	user=new Lawyer();
        user.setUsername(username);
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
