package com.mygudou.app.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.UserDAOImp;
import com.mygudou.app.model.Customer;
import com.mygudou.app.model.Lawyer;
import com.mygudou.app.model.User;

/**
 * 用户登录
 */
@Service("UserLoginService")
@Transactional
public class UserLoginService {
    @Resource(name = "UserDAOImp")
    private UserDAOImp userDAOImp;

    public void insertLawyer(Lawyer user) {
        
        if (userDAOImp.LawyerIsNotExist(user.getId())) {

            userDAOImp.insertLawyer(user);
        }

    }
    
    public void insertCustomer(Customer user) {
        
        if (userDAOImp.CustomerIsNotExist(user.getId())) {

            userDAOImp.insertCustomer(user);
        }

    }

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		if(user instanceof Lawyer)
			insertLawyer((Lawyer)user);
		else 
			insertCustomer((Customer)user);
			
	}
    
    

}
