package com.mygudou.app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.mygudou.app.model.Message;

public class MessageRowMapper implements RowMapper<Message>{

	public Message mapRow(ResultSet rs, int arg1) throws SQLException {
		Message message = new Message();
		
		
		message.setId(rs.getLong("id"));
		message.setFromId(rs.getInt("fromid"));
		message.setToId(rs.getInt("toid"));
		message.setContent(rs.getString("content"));
		Timestamp time = rs.getTimestamp("time");
		message.setTimeStamp(time);
		message.setTime(time.toString());	
		
		return message;
	}

}
