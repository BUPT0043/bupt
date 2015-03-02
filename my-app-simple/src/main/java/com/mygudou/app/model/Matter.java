package com.mygudou.app.model;

public class Matter {
    /**
     * 搜索内事件
     * title:事件标题
     * content:事件内容
     * */
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
