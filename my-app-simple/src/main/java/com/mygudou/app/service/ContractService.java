package com.mygudou.app.service;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 合同生成登录
 */







import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;
import com.mygudou.app.daoImp.ContractDAOImpl;
import com.mygudou.app.daoImp.XMLDAOimpl;
import com.mygudou.app.model.contract.Category;
import com.mygudou.app.model.contract.Item;
import com.mygudou.app.model.contract.Law;

@Service("ContractService")
@Transactional
public class ContractService {
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;

    @Resource(name = "ItemDAO")
    private ContractDAOImpl ItemDAO;

    public List<Law> getLawList() {

        return ItemDAO.getLaws();

    }
    

    public Law getLaw(int lawid) {
        return ItemDAO.getLaw(lawid);
    }

    public Item getItem(int lawid, int categoryid) {
        return ItemDAO.getItem(lawid, categoryid);
    }

    public Category getCa(int lawid, int categoryid) {
        return ItemDAO.getCa(lawid, categoryid);
    }

    public List<Item> getList() {
        return ItemDAO.getItems();
    }

    public List<Category> getCateogoryList(int lawid) {

        return ItemDAO.getCategory(lawid);
    }

    


}
