package com.mygudou.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.ItemDAOImpl;
import com.mygudou.app.daoImp.XMLDAOimpl;
import com.mygudou.app.model.Matter;

/**
 * 搜索
 */
@Service("SearchService")
@Transactional
public class SearchService {
    
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;

    @Resource(name = "ItemDAO")
    private ItemDAOImpl ItemDAO;

    public List<Matter> getMattList(String title, int pageIndex, int pageSize) {
       
        return ItemDAO.getMatt(title, pageIndex, pageSize);
    }

    public int getMattTotal(String title, int pageIndex, int pageSize) {

        return ItemDAO.getMattTotal(title, pageIndex, pageSize);
    }

    public List<Matter> getMattAll(int id) {

        return ItemDAO.getMattAll(id);
    }
    
    

}
