package com.qeepchat.model;

public class Message {
	private int m_id;
	private  String message;
	
	
	public Message(){
		
	}
	public Message(int m_id,String message){
		this.m_id= m_id;
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	
}

