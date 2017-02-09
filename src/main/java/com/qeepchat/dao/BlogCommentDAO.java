package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.BlogComment;

public interface BlogCommentDAO {

	public boolean addBlogComment(BlogComment blogComment);

	void deleteBlogComment(int blogCommentId);

	BlogComment getBlogComment(int blogCommentId);

	List<BlogComment> listBlogComments();
	
	List<BlogComment> listBlogByCreatedAt(int c_id);
	
		
	
}
