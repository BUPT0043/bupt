package com.mygudou.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.model.ItemInfo;

public class ItemInfoRowMapper   implements RowMapper<ItemInfo>{

	
	public ItemInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		ItemInfo itemInfo=new ItemInfo();
		
		itemInfo.setId(rs.getInt("id"));
		itemInfo.setData(rs.getString("data"));
		itemInfo.setRefer(rs.getString("refer"));
		return null;
	}
	

}
