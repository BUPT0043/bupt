package com.mygudou.app.model.user;

import java.io.Serializable;

/**
 * 用户身份的基类
 */
public abstract class IUser implements Serializable{


	private static final long serialVersionUID = 1906490180434268100L;

	private int id;

    private String username;

    private String sex;

    private String pwd;

    private String email;

  

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}