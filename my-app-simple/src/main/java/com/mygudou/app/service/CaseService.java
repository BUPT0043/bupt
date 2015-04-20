package com.mygudou.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.CaseDAOImpl;
import com.mygudou.app.daoImp.ContractDAOImpl;
import com.mygudou.app.daoImp.XMLDAOimpl;
import com.mygudou.app.model.Matter;

/**
 * 搜索
 */
@Service("SearchService")
@Transactional
public class CaseService {
    
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;

    @Resource(name = "CaseDAO")
    private CaseDAOImpl CaseDAO;

    public List<Matter> getMattList(String title, int pageIndex, int pageSize) {
       
        return CaseDAO.getMatt(title, pageIndex, pageSize);
    }

    public int getMattTotal(String title, int pageIndex, int pageSize) {

        return CaseDAO.getMattTotal(title, pageIndex, pageSize);
    }

    public List<Matter> getMattAll(int id) {

        return CaseDAO.getMattAll(id);
    }
    
    

}
