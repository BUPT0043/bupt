package com.mygudou.app.model;

import java.io.Serializable;

public class Item implements Serializable {
    /**
     * 条款内项目： data:项目条款 
     *            refer:条款相关内容
     */
    private static final long serialVersionUID = -3203827476568975742L;

    private int id;

    private String data;

    private String refer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", data=" + data + ", refer=" + refer + "]";
    }

}
