package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.ForumLikeDAOImpl;

import com.qeepchat.model.ForumLike;
@Service
@Transactional
public class ForumLikeService {
	@Autowired(required=true)
	ForumLikeDAOImpl forumLikeDAO;
	
	public boolean addForumLike(ForumLike forumLike){
	     forumLikeDAO.addForumLike(forumLike);
        return true; 
}
	
	public void deleteForumLike(int fLikeId){
		forumLikeDAO.deleteForumLike(fLikeId);
	}
	
	public ForumLike getForumLike(int fLikeId){
		return forumLikeDAO.getForumLike(fLikeId);
	}
	
	public List<ForumLike> listForumLikes(int forumId){
		return forumLikeDAO.listForumLikes();
	}
	public List<ForumLike> listForumLikeByCreatedAt(int forumId){
		return forumLikeDAO.listForumLikeByCreatedAt(forumId);
	}
}


