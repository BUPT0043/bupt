package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;
import com.mygudou.app.model.Matter;

public interface ContractDAO {

    public int insertLaw(Law law);

    // select
    public List<Law> getLaws();

    public List<Item> getItems();

    public List<Category> getCategory(int lawid);

    // 传值
    public Law getLaw(int lawid);

    public Category getCa(int lawid, int categoryid);

    public Item getItem(int lawid, int categoryid);

    // 判空
    public boolean isNotExist(Law law);

    public boolean isNotExist(Category category);

    public boolean isNotExist(Item item);

}
