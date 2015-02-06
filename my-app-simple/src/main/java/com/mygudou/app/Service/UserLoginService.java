package com.mygudou.app.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.DAOImp.UserDAOImp;
import com.mygudou.app.Model.User;

/**
 * 用户登录
 */
@Service("UserLoginService")
@Transactional
public class UserLoginService {
    @Resource(name = "UserDAOImp")
    private UserDAOImp userDAOImp;

    public void insertUser(User user) {
        
        if (userDAOImp.isNotExist(user)) {

            userDAOImp.insertUser(user);
        }

    }

}
