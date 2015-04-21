package com.mygudou.app.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mygudou.app.dao.CaseDAO;
import com.mygudou.app.model.Matter;
import com.mygudou.app.rowMapper.MatterRowMapper;

/**
 * 关于法律案例展示和搜索的DAO
 * @author gufeng
 *
 */
@Repository("CaseDAO")
public class CaseDAOImpl implements CaseDAO {
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    String TABLE_NAME = "res_matters";





    public List<Matter> getMatt(String title, int pageIndex, int pageSize) {
        String sql = "";
        if ("".equals(title) || null == title) {
            sql = "select * from " + TABLE_NAME + " limit " + pageIndex + ","
                    + pageSize;
        } else {
            sql = "select * from " + TABLE_NAME + " where title like" + "'%"
                    + title + "%'" + " limit " + pageIndex + "," + pageSize;
        }
        return jdbcTemplate.query(sql, new MatterRowMapper());
    }

    public int getMattTotal(String title, int pageIndex, int pageSize) {
        String sql = "";
        if ("".equals(title) || null == title) {
            sql = "select * from " + TABLE_NAME + " limit " + pageIndex + ","
                    + pageSize;
        } else {
            sql = "select * from " + TABLE_NAME + " where title like" + "'%"
                    + title + "%'" + " limit " + pageIndex + "," + pageSize;
        }
        return jdbcTemplate.query(sql, new MatterRowMapper()).size();
    }

    
    public List<Matter> getMattAll(int id) {
        String sql = "select * from " + TABLE_NAME + " where id=" + id;
        return jdbcTemplate.query(sql, new MatterRowMapper());
    }


}
