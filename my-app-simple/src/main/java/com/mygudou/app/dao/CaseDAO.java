package com.mygudou.app.dao;

import java.util.List;

import com.mygudou.app.model.Matter;
import com.mygudou.app.model.contract.Category;
import com.mygudou.app.model.contract.Item;
import com.mygudou.app.model.contract.Law;

public interface CaseDAO {

    
    // 搜索
    public List<Matter> getMatt(String title, int pageIndex, int pageSize);

    public int getMattTotal(String title, int pageIndex, int pageSize);

    public List<Matter> getMattAll(int id);

    

}
