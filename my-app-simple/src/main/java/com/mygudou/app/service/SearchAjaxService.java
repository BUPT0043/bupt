package com.mygudou.app.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.mygudou.app.daoImp.ItemDAOImpl;
import com.mygudou.app.daoImp.XMLDAOimpl;
import com.mygudou.app.model.Matter;

/**
 * 项目查询-->Ajax刷新
 */
@Service("SearchAjaxService")
@Transactional
public class SearchAjaxService {
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
