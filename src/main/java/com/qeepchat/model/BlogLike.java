package com.qeepchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogLike extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bLikeId;
	private int c_id;
	private int id;
	
	public int getbLikeId() {
		return bLikeId;
	}
	public void setbLikeId(int bLikeId) {
		this.bLikeId = bLikeId;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}

