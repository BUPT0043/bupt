package com.mygudou.app.dao;

import org.springframework.stereotype.Repository;

import com.mygudou.app.model.User;

/**
 * @UserInterface
 */
public interface UserDAO {

    void insertUser(User user);

    public boolean isNotExist(User user);
}
