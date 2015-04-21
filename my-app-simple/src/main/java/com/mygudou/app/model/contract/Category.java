package com.mygudou.app.model.contract;

import java.io.Serializable;


    /**
	 * 分类：categoryname 类名
	 */
public class Category implements Serializable{

	private static final long serialVersionUID = 5023186671218357505L;

    private String categoryname;

    private int id;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
