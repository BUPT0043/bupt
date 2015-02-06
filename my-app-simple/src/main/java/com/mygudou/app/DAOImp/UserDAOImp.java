package com.mygudou.app.DAOImp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mygudou.app.DAO.UserDAO;
import com.mygudou.app.Model.User;

/**
 * @UserLogin
 */

@Repository("UserDAOImp")
public class UserDAOImp implements UserDAO {
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    String TABLE_NAME = "res_user";

    public void insertUser(User user) {
        final int id = user.getId();
        final String userId = user.getUserId();
        final String role = user.getRole();
        final String sex = user.getSex();
        final String pwd = user.getPwd();
        final String email = user.getEmail();
        jdbcTemplate.update("INSERT INTO " + TABLE_NAME
                + "(userId,role,sex,pwd,email) VALUES (?,?,?,?,?)",
                new PreparedStatementSetter() {

                    public void setValues(PreparedStatement ps)
                            throws SQLException {
                        ps.setString(1, userId);
                        ps.setString(2, role);
                        ps.setString(3, sex);
                        ps.setString(4, pwd);
                        ps.setString(5, email);
                    }

                });

    }

    public boolean isNotExist(User user) {
        final String userId2 = user.getUserId();
        List list = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_NAME
                + " WHERE userId = " + userId2);
        if (list.size() > 0) {
            return false;
        } else {

            return true;
        }
    }

}
