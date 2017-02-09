package com.qeepchat.model;

import java.util.Date;

public class OutputMessage extends Message{
	private Date time;

	public OutputMessage(Message original,Date time){
		super(original.getM_id(), original.getMessage());
		this.time=time;
	}
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

}
