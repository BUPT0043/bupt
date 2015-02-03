package com.mygudou.app.Service;

import java.util.List;
/**
 * 合同生成登录
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mygudou.app.DAOImp.ItemDAOImpl;
import com.mygudou.app.DAOImp.XMLDAOimpl;
import com.mygudou.app.Model.Law;

@Service("LoginService")
@Transactional
public class LoginService {
    @Resource(name = "XMLDAO")
    private XMLDAOimpl XMLDAO;

    @Resource(name = "ItemDAO")
    private ItemDAOImpl ItemDAO;

    public List<Law> getLawList() {

        return ItemDAO.getLaws();

    }

}
