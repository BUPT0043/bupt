package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;
import com.mygudou.app.model.Matter;

public interface CaseDAO {

    
    // 搜索
    public List<Matter> getMatt(String title, int pageIndex, int pageSize);

    public int getMattTotal(String title, int pageIndex, int pageSize);

    public List<Matter> getMattAll(int id);

    

}
