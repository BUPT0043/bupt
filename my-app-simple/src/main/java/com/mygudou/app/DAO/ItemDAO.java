package com.mygudou.app.DAO;

import java.util.List;

import com.mygudou.app.Model.Category;
import com.mygudou.app.Model.Item;
import com.mygudou.app.Model.Law;
import com.mygudou.app.Model.Matter;

public interface ItemDAO {

    public int insertLaw(Law law);

    // select
    public List<Law> getLaws();

    public List<Item> getItems();

    public List<Category> getCategory(int lawid);

    // 搜索
    public List<Matter> getMatt(String title, int pageIndex, int pageSize);

    public int getMattTotal(String title, int pageIndex, int pageSize);

    public List<Matter> getMattAll(int id);

    // 传值
    public Law getLaw(int lawid);

    public Category getCa(int lawid, int categoryid);

    public Item getItem(int lawid, int categoryid);

    // 判空
    public boolean isNotExist(Law law);

    public boolean isNotExist(Category category);

    public boolean isNotExist(Item item);

}
