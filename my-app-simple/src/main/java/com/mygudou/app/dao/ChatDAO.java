package com.mygudou.app.dao;

import java.sql.Timestamp;
import java.util.List;

import com.mygudou.app.model.Message;

/**
 * chat分為兩個部分，在自己主頁上可以查看對方留言，若想看詳細信息可去對方留言板，此時可看到雙方的聊天記錄
 * @author gufeng
 *
 */
public interface ChatDAO {
	
	public int insertMsg(int fromId,int toId,String message,Timestamp timestamp);
	/**
	 * 标记这些信息已读
	 * @param messages
	 */
	public void updateUnchecked(List<Message> messages);
	/**
	 * 表示留言信息
	 * @param myId
	 * @param friendId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Message> getLeaveMsg (int myId,int friendId,int page,int pageSize);
	/**
	 * 表示詳細記錄
	 * @param myId
	 * @param friendId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<Message> getChatMsg(int myId,int friendId,int page,int pageSize);
	
}
