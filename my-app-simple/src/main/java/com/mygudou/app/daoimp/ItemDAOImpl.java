package com.mygudou.app.daoimp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mygudou.app.dao.ItemDAO;
import com.mygudou.app.model.Category;
import com.mygudou.app.model.Item;
import com.mygudou.app.rowmapper.CategoryRowMapper;
import com.mygudou.app.rowmapper.ItemRowMapper;

@Repository("ItemDAO")
public class ItemDAOImpl implements ItemDAO{
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    String TABLE_NAME="res_category_item";
    String TABLE_NAME1="res_category";

	public int insertItem(Item item) {
		
		int i=0;
		
		try{
			final String data=item.getData();
			final String refer=item.getRefer();

        jdbcTemplate.update("INSERT INTO "+TABLE_NAME+" (data,refer) VALUES(?,?)",  
                new PreparedStatementSetter() {  
                    public void setValues(PreparedStatement ps) throws SQLException {  
                    	//System.out.println(data+">>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        ps.setString(1, data);  
                        ps.setString(2, refer);
                    }
       			}
       );}catch(Exception e){
    	   
    	   e.printStackTrace();
       }
        return i;
	}
	
	public void insertCategroy(Category category) {
	
		final String name=category.getCategoryname();
        jdbcTemplate.update("INSERT INTO "+TABLE_NAME1+" (name) VALUES(?)",  
                new PreparedStatementSetter() {  
                    public void setValues(PreparedStatement ps) throws SQLException {  
                        ps.setString(1, name);  
                    
                    }
       			}
       );
	}	
	public boolean isNotExist(Category category) {
		final String name=category.getCategoryname();
		List list = jdbcTemplate.queryForList("SELECT * FROM "+TABLE_NAME1+" WHERE NAME="+"'"+name+"'");
		System.out.println(list.size()+">>>>>>>");
		boolean b;
		if(list.size()>0){
			b = false;
		}else{
			b = true;
		}
		return b;
	}//方法
		//可以根据categoryid来判断？
		public boolean isNotExist(Item item) {
			final String data=item.getData();
			List list1=jdbcTemplate.queryForList("SELECT * FROM "+TABLE_NAME+" WHERE DATA="+"'"+data+"'");
			System.out.println(list1.size()+"<<<<<<<<<<<");
			boolean b;
			if(list1.size()>0){
				b = false;
			}else{
				b = true;
			}
			System.out.println(b+"<<<<<<<<<<<b");
			return b;
		}
	
/**
 * 这个函数是拿到所有的items
 */
	public List<Item> getItems() {

        String sql = "select * from "+ TABLE_NAME;

        return jdbcTemplate.query(sql, new ItemRowMapper());
	}

	public List<Category> getCategory() {
		
		String sql = "select * from "+ TABLE_NAME1;
        return jdbcTemplate.query(sql, new CategoryRowMapper());
	}





	

}
