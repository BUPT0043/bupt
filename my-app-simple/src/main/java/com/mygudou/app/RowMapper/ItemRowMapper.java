package com.mygudou.app.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.Model.Item;

public class ItemRowMapper implements RowMapper<Item> {

    public Item mapRow(ResultSet rs, int arg1) throws SQLException {
        Item item = new Item();

        item.setId(rs.getInt("id"));
        item.setData(rs.getString("data"));
        item.setRefer(rs.getString("refer"));
        return item;
    }

}
