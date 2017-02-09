package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.ForumCommentDAOImpl;

import com.qeepchat.model.ForumComment;
@Service
@Transactional
public class ForumCommentService {
	@Autowired(required=true)
	ForumCommentDAOImpl forumCommentDAO;
	
	public boolean addForumComment(ForumComment forumComment){
	     forumCommentDAO.addForumComment(forumComment);
        return true; 
}
	
	public void deleteForumComment(int forumCommentId){
		forumCommentDAO.deleteForumComment(forumCommentId);
	}
	
	public ForumComment getForumComment(int forumCommentId){
		return forumCommentDAO.getForumComment(forumCommentId);
	}
	
	public List<ForumComment> listForumComments(int forumId){
		return forumCommentDAO.listForumComments();
	}
	public List<ForumComment> listForumByCreatedAt(int forumId){
		return forumCommentDAO.listForumByCreatedAt(forumId);
	}
}
