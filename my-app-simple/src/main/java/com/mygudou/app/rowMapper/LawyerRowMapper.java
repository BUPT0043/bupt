package com.mygudou.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.model.user.Lawyer;

/**
 * @UserMapper
 */
public class LawyerRowMapper implements RowMapper<Lawyer> {

    public Lawyer mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Lawyer user = new Lawyer();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setPwd(rs.getString("pwd"));
        user.setSex(rs.getString("sex"));
        return user;
    }

}
