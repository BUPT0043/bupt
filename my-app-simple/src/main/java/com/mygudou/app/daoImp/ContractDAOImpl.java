package com.mygudou.app.daoImp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mygudou.app.dao.ContractDAO;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.model.Law;
import com.mygudou.app.model.Matter;
import com.mygudou.app.rowMapper.CategoryRowMapper;
import com.mygudou.app.rowMapper.ItemRowMapper;
import com.mygudou.app.rowMapper.LawRowMapper;
import com.mygudou.app.rowMapper.MatterRowMapper;

@Repository("ItemDAO")
public class ContractDAOImpl implements ContractDAO {
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    String TABLE_NAME = "res_category_item";

    String TABLE_NAME1 = "res_category";

    String TABLE_NAME2 = "res_law";


    public void insertItem(Item item, String categoryName) {

        final String data = item.getData();
        final String refer = item.getRefer();
        final int categoryid = jdbcTemplate
                .queryForInt("select id from res_category where name=" + "'"
                        + categoryName + "'");
        jdbcTemplate.update("INSERT INTO " + TABLE_NAME
                + " (categoryid,data,refer) VALUES(?,?,?)",
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps)
                            throws SQLException {
                        ps.setInt(1, categoryid);
                        ps.setString(2, data);
                        ps.setString(3, refer);
                    }
                });        
    }

    public void insertCategroy(Category category, String lawName) {

        final String name = category.getCategoryname();
        final int lawid = jdbcTemplate
                .queryForInt("select id from res_law where name=" + "'"
                        + lawName + "'");
        jdbcTemplate.update("INSERT INTO " + TABLE_NAME1
                + " (lawid,name) VALUES(?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, lawid);
                ps.setString(2, name);

            }
        });
    }

    public int insertLaw(Law law) {
        int i = 0;

        try {
            final String name = law.getName();
            final String inform = law.getInform();

            jdbcTemplate.update("INSERT INTO " + TABLE_NAME2
                    + " (name,inform) VALUES(?,?)",
                    new PreparedStatementSetter() {
                        public void setValues(PreparedStatement ps)
                                throws SQLException {
                            System.out.println(name + ">>>>>>lawName>>>>>>>>>");
                            ps.setString(1, name);
                            ps.setString(2, inform);
                            System.out.println(inform
                                    + "<<<<<<<lawInform<<<<<<");
                        }
                    });
        } catch (Exception e) {

            e.printStackTrace();
        }
        return i;
    }

    public boolean isNotExist(Category category) {
        final String name = category.getCategoryname();
        List list = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_NAME1
                + " WHERE NAME=" + "'" + name + "'");
        System.out.println(list.size() + ">>>>>>>");
        boolean b;
        if (list.size() > 0) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }// 方法

    public boolean isNotExist(Item item) {
        final String data = item.getData();
        List list1 = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_NAME
                + " WHERE DATA=" + "'" + data + "'");
        System.out.println(list1.size() + "<<<<<<<<<<<");
        boolean b;
        if (list1.size() > 0) {
            b = false;
        } else {
            b = true;
        }
        System.out.println(b + "<<<<<<<<<<<b");
        return b;
    }

    public boolean isNotExist(Law law) {
        final String name = law.getName();

        List list2 = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_NAME2
                + " WHERE NAME=" + "'" + name + "'");
        System.out.println(list2.size() + "----law.size-----");
        boolean b;
        if (list2.size() > 0) {
            b = false;

        } else {
            b = true;
        }
        return b;
    }

    public List<Item> getItems() {

        String sql = "select * from " + TABLE_NAME;

        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public List<Category> getCategory(int lawid) {

        String sql = "select * from " + TABLE_NAME1 + " where lawid=" + lawid;
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }


    public List<Law> getLaws() {
        String sql = "select * from " + TABLE_NAME2;
        return jdbcTemplate.query(sql, new LawRowMapper());
    }

    public Law getLaw(int lawid) {
        String sql = "select * from " + TABLE_NAME2 + " where id=" + lawid;
        return jdbcTemplate.query(sql, new LawRowMapper()).get(0);

    }

    public Item getItem(int lawid, int categoryid) {
        String sql = "select * from " + TABLE_NAME + " where categoryid="
                + categoryid;
        return jdbcTemplate.query(sql, new ItemRowMapper()).get(0);
    }

    public Category getCa(int lawid, int categoryid) {
        String sql = "select * from " + TABLE_NAME1 + " where id=" + categoryid;
        return jdbcTemplate.query(sql, new CategoryRowMapper()).get(0);
    }


}
