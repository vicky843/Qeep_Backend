package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.BlogCommentDAOImpl;
import com.qeepchat.model.Blog;
import com.qeepchat.model.BlogComment;

@Service
@Transactional
public class BlogCommentService {
	@Autowired(required=true)
	BlogCommentDAOImpl blogCommentDAO;
	
	public boolean addBlogComment(BlogComment blogComment){
	     blogCommentDAO.addBlogComment(blogComment);
        return true; 
}
	
	public void deleteBlogComment(int blogCommentId){
		blogCommentDAO.deleteBlogComment(blogCommentId);
	}
	
	public BlogComment getBlogComment(int blogCommentId){
		return blogCommentDAO.getBlogComment(blogCommentId);
	}
	
	public List<BlogComment> listBlogComments(int c_id){
		return blogCommentDAO.listBlogComments();
	}
	public List<BlogComment> listBlogByCreatedAt(int c_id){
		return blogCommentDAO.listBlogByCreatedAt(c_id);
	}
}
