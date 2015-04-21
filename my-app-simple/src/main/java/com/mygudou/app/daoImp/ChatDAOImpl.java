package com.mygudou.app.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.mygudou.app.dao.ChatDAO;
import com.mygudou.app.model.Message;
import com.mygudou.app.rowMapper.MessageRowMapper;

@Repository("ChatDao")
public class ChatDAOImpl implements ChatDAO{
    @Resource(name = "myjdbcTemplate")
    private JdbcTemplate jdbcTemplate;

	private final String MESSAGE_TABLE = "message";
    


	public int insertMsg(final int fromId, final int toId, final String message,
			final Timestamp timestamp) {
		// TODO Auto-generated method stub
		int affectRows = jdbcTemplate.update(new PreparedStatementCreator(){

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into "+MESSAGE_TABLE+" (fromid,toid,message,time,received) values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, fromId);
				ps.setInt(2, toId);
				ps.setString(3, message);
				ps.setTimestamp(4, timestamp);
				ps.setInt(5, 0);
				return ps;
			}});
		return affectRows;
	}

	public void updateUnchecked(final List<Message> messages) {
		// TODO Auto-generated method stub
		String sql = "update "+MESSAGE_TABLE+" set fromid=?,toid=?,content=?,time=? where id=?";  
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {  
            public int getBatchSize() {  
                return messages.size();  
                //这个方法设定更新记录数，通常List里面存放的都是我们要更新的，所以返回list.size();  
            }  
            public void setValues(PreparedStatement ps, int i)throws SQLException {  
            	Message message =  messages.get(i);  
                ps.setInt(1, message.getFromId());
                ps.setInt(2, message.getToId());
                ps.setString(3, message.getContent());
                ps.setTimestamp(4, message.getTimeStamp());
                 
            }  
        });     
	}

	public List<Message> getLeaveMsg(int myId, int friendId, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from "+MESSAGE_TABLE+" where toid="+myId +" and fromId = "+friendId;
		List<Message> messages = jdbcTemplate.query(sql, new MessageRowMapper());

		return messages;
	}

	public List<Message> getChatMsg(int myId, int friendId, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from "+MESSAGE_TABLE+" where toid="+myId +" and fromId = "+friendId+
				" union all "+ "select * from "+MESSAGE_TABLE+" where fromId="+myId +" and toId = "+friendId+
				" order by timestamp desc";
		List<Message> messages = jdbcTemplate.query(sql, new MessageRowMapper());
		updateUnchecked(messages);
		for(Message msg:messages){
			if(msg.getFromId()==myId)
				msg.setSendOrReceive(false);
		}		
		return null;
	}

}
