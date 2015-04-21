package com.mygudou.app.model;

import java.io.Serializable;

	/**
     * 搜索内事件
     * title:事件标题
     * content:事件内容
     * */

public class Matter implements Serializable{

	private static final long serialVersionUID = 3565767215481715236L;


    private int id;

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
