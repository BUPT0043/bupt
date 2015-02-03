package com.mygudou.app.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mygudou.app.Model.Law;

public class LawRowMapper implements RowMapper<Law> {

    public Law mapRow(ResultSet rs, int arg1) throws SQLException {

        Law la = new Law();
        la.setId(rs.getInt("id"));
        la.setName(rs.getString("name"));
        la.setInform(rs.getString("inform"));
        return la;
    }

}
