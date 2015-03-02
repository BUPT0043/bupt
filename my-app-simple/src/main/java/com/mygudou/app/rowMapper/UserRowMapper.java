package com.mygudou.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.model.User;

/**
 * @UserMapper
 */
public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setPwd(rs.getString("pwd"));
        user.setRole(rs.getString("role"));
        user.setSex(rs.getString("sex"));
        return user;
    }

}
