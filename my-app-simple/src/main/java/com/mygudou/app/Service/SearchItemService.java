package com.mygudou.app.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.DAOImp.ItemDAOImpl;
import com.mygudou.app.DAOImp.XMLDAOimpl;
import com.mygudou.app.Model.Category;
import com.mygudou.app.Model.Item;
import com.mygudou.app.Model.Law;

/**
 * lawid+categoryid绑定找相关法律项目
 */
@Service("SearchItemService")
@Transactional
public class SearchItemService {
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;

    @Resource(name = "ItemDAO")
    private ItemDAOImpl ItemDAO;

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

    public List<Law> getLawList() {

        return ItemDAO.getLaws();

    }

}
