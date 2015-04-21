package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Matter;
import com.mygudou.app.model.contract.Category;
import com.mygudou.app.model.contract.Item;
import com.mygudou.app.model.contract.Law;

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
