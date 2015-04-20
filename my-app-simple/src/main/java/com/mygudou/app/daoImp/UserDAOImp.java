package com.mygudou.app.daoImp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mygudou.app.dao.UserDAO;
import com.mygudou.app.model.Customer;
import com.mygudou.app.model.Lawyer;
import com.mygudou.app.rowMapper.CustomerRowMapper;
import com.mygudou.app.rowMapper.LawyerRowMapper;

/**
 * @UserLogin
 */

@Repository("UserDAOImp")
public class UserDAOImp implements UserDAO {
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    String TABLE_LAWYER = "lawyer";
    String TABLE_CUSTOMER = "customer";
    String TABLE_LAWYER_CUSTOMER = "lawyer_customer";

    public void insertLawyer(Lawyer user) {
        final int id = user.getId();
        final String username = user.getUsername();
        final String sex = user.getSex();
        final String pwd = user.getPwd();
        final String email = user.getEmail();
        jdbcTemplate.update("INSERT INTO " + TABLE_LAWYER
                + "(username,sex,pwd,email) VALUES (?,?,?,?)",
                new PreparedStatementSetter() {

                    public void setValues(PreparedStatement ps)
                            throws SQLException {
                        ps.setString(1, username);
                        ps.setString(3, sex);
                        ps.setString(4, pwd);
                        ps.setString(5, email);
                    }

                });

    }

    public boolean LawyerIsNotExist(int id) {
        
        List list = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_LAWYER
                + " WHERE id = " + id);
        if (list.size() > 0) {
            return false;
        } else {

            return true;
        }
    }


	public List<Lawyer> getLawyerSimpleList() {
		// TODO Auto-generated method stub
        String sql = "select * from " + TABLE_LAWYER;
        return jdbcTemplate.query(sql, new LawyerRowMapper());
	}

	public Lawyer getLawyerDetail(int id) {
		if(LawyerIsNotExist(id))
			return null;
		// TODO Auto-generated method stub
		String sql = "select * from " + TABLE_LAWYER+" where id ="+id;	
		List<Lawyer> lawyer = jdbcTemplate.query(sql, new LawyerRowMapper());
		
        String getCustomers="select customerId from "+TABLE_LAWYER_CUSTOMER +" where lawyerId ="+id;
        
        List<Integer> customers=jdbcTemplate.queryForList(getCustomers,Integer.class);
        
        lawyer.get(0).setCustomer(customers);
        
		return lawyer.get(0);
	}

	public void insertCustomer(Customer user) {
		// TODO Auto-generated method stub
        final int id = user.getId();
        final String username = user.getUsername();
        final String sex = user.getSex();
        final String pwd = user.getPwd();
        final String email = user.getEmail();
        jdbcTemplate.update("INSERT INTO " + TABLE_CUSTOMER
                + "(username,sex,pwd,email) VALUES (?,?,?,?)",
                new PreparedStatementSetter() {

                    public void setValues(PreparedStatement ps)
                            throws SQLException {
                        ps.setString(1, username);
                        ps.setString(3, sex);
                        ps.setString(4, pwd);
                        ps.setString(5, email);
                    }

                });
	}

	public boolean CustomerIsNotExist(int id) {
		// TODO Auto-generated method stub
        List list = jdbcTemplate.queryForList("SELECT * FROM " + TABLE_CUSTOMER
                + " WHERE id = " + id);
        if (list.size() > 0) {
            return false;
        } else {

            return true;
        }
	}


	public Customer getCustomerDetail(int id) {
		// TODO Auto-generated method stub
		if(CustomerIsNotExist(id))
			return null;
		// TODO Auto-generated method stub
		String sql = "select * from " + TABLE_CUSTOMER+" where id ="+id;	
		List<Customer> customer = jdbcTemplate.query(sql, new CustomerRowMapper());
		
        String getLawyers="select lawyerId from "+TABLE_LAWYER_CUSTOMER +" where customerId ="+id;
        
        List<Integer> lawyers=jdbcTemplate.queryForList(getLawyers,Integer.class);
        
        customer.get(0).setLawyer(lawyers);
        
		return customer.get(0);
	}

}
