package com.mygudou.app.Model;

public class Law {
    /**
     * 法律：
     * name:法律名称
     * inform:法律相关信息
     * */

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
