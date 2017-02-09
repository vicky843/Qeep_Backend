package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.BlogLikeDAOImpl;

import com.qeepchat.model.BlogLike;
@Service
@Transactional
public class BlogLikeService {
	@Autowired(required=true)
	BlogLikeDAOImpl blogLikeDAO;
	
	public boolean addBlogLike(BlogLike blogLike){
	     blogLikeDAO.addBlogLike(blogLike);
        return true; 
}
	
	public void deleteBlogLike(int bLikeId){
		blogLikeDAO.deleteBlogLike(bLikeId);
	}
	
	public BlogLike getBlogLike(int bLikeId){
		return blogLikeDAO.getBlogLike(bLikeId);
	}
	
	public List<BlogLike> listBlogLikes(int c_id){
		return blogLikeDAO.listBlogLikes();
	}
	public List<BlogLike> listBlogLikeByCreatedAt(int c_id){
		return blogLikeDAO.listBlogLikeByCreatedAt(c_id);
	}
}


