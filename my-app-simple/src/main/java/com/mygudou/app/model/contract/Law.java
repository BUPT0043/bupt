package com.mygudou.app.model.contract;

import java.io.Serializable;

	/**
     * 法律：
     * name:法律名称
     * inform:法律相关信息
     */

public class Law implements Serializable{

	private static final long serialVersionUID = -3480386325196372741L;

    private int id;

    private String name;

    private String inform;

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
