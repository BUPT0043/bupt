package com.mygudou.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.model.Customer;

/**
 * @UserMapper
 */
public class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Customer user = new Customer();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setPwd(rs.getString("pwd"));
        user.setSex(rs.getString("sex"));
        return user;
    }

}
