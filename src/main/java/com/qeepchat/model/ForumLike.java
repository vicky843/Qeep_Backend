package com.qeepchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ForumLike extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fLikeId;
	private int forumId;
	private int id;
	public int getfLikeId() {
		return fLikeId;
	}
	public void setfLikeId(int fLikeId) {
		this.fLikeId = fLikeId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
