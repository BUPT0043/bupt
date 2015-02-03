package com.mygudou.app.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mygudou.app.Model.Matter;

public class MatterRowMapper implements RowMapper<Matter> {

    public Matter mapRow(ResultSet rs, int rowNum) throws SQLException {

        Matter ma = new Matter();
        ma.setId(rs.getInt("id"));
        ma.setTitle(rs.getString("title"));
        ma.setContent(rs.getString("content"));
        return ma;
    }

}
