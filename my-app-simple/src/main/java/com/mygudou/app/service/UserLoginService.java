package com.mygudou.app.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.UserDAOImp;
import com.mygudou.app.model.user.Customer;
import com.mygudou.app.model.user.IUser;
import com.mygudou.app.model.user.Lawyer;

/**
 * 用户登录
 */
@Service("UserLoginService")
@Transactional
public class UserLoginService {
    @Resource(name = "UserDAO")
    private UserDAOImp userDAOImp;

    public void insertLawyer(Lawyer user) {
        
        if (userDAOImp.LawyerIsNotExist(user.getUsername())) {

            userDAOImp.insertLawyer(user);
        }

    }
    
    public void insertCustomer(Customer user) {
        
        if (userDAOImp.CustomerIsNotExist(user.getUsername())) {

            userDAOImp.insertCustomer(user);
        }

    }

	public void insertUser(IUser user) {
		// TODO Auto-generated method stub
		if(user instanceof Lawyer)
			insertLawyer((Lawyer)user);
		else 
			insertCustomer((Customer)user);
			
	}
    
    

}
