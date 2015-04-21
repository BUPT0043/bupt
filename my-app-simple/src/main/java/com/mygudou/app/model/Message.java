package com.mygudou.app.model;

import java.io.Serializable;
import java.sql.Timestamp;


	/**
	 * 用户之间的留言，其中received中false表示沒讀過.sendOrReceive中false表示發送true表接收
	 */
public class Message implements Serializable{


	private static final long serialVersionUID = 4998654489878737907L;
	private long id;
	private String content;
	private int fromId;
	private int toId;
	private boolean received; 
	private boolean sendOrReceive=true;
	private String time;
	private Timestamp timeStamp;
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isReceived() {
		return received;
	}
	public void setReceived(boolean received) {
		this.received = received;
	}
	public boolean isSendOrReceive() {
		return sendOrReceive;
	}
	public void setSendOrReceive(boolean sendOrReceive) {
		this.sendOrReceive = sendOrReceive;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	
}
