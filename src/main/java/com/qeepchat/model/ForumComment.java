package com.qeepchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ForumComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumCommentId;
	private int id; //user id
	private int forumId;
	private String forumCommentContent;
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getForumCommentContent() {
		return forumCommentContent;
	}
	public void setForumCommentContent(String forumCommentContent) {
		this.forumCommentContent = forumCommentContent;
	}
	
	
}
