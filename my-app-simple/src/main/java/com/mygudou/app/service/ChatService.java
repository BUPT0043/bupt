package com.mygudou.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mygudou.app.daoImp.ChatDAOImpl;
import com.mygudou.app.model.Message;
import com.mygudou.app.rowMapper.MessageRowMapper;

/**
 * 聊天留言
 */
@Service("ChatService")
@Transactional
public class ChatService {


    @Resource(name = "ChatDAO")
    private ChatDAOImpl ChatDAO;

    public void insertMsg(int fromId, int toId,String message) {
    	Timestamp time = new Timestamp(System.currentTimeMillis()); 
    	ChatDAO.insertMsg(fromId, toId, message, time);
		// TODO Auto-generated method stub		
	}

	public void updateUnchecked(List<Message> messages) {
		// TODO Auto-generated method stub
		
	}

	public List<Message> getLeaveMsg(int myId, int friendId, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Message> getChatMsg(int myId, int friendId, int page,
			int pageSize) {
				return null;
		
	}
    
    

}
