package com.mygudou.app.DAO;

import org.springframework.stereotype.Repository;

import com.mygudou.app.Model.User;

/**
 * @UserInterface
 */
public interface UserDAO {

    void insertUser(User user);

    public boolean isNotExist(User user);
}
