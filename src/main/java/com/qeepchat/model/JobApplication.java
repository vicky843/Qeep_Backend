package com.qeepchat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobApplication {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobAppId;
	private int id;
	private int jobId;
    private Date dateTime;
    private String remarks;
    private char status;
	public int getJobAppId() {
		return jobAppId;
	}
	public void setJobAppId(int jobAppId) {
		this.jobAppId = jobAppId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public void setDateTime(Object dateTime2) {
		
		
	}
	
	

}
