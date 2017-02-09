package com.qeepchat.dao;

import java.util.List;


import com.qeepchat.model.BlogLike;

public interface BlogLikeDAO {
	public boolean addBlogLike(BlogLike blogLike);

	void deleteBlogLike(int bLikeId);

	BlogLike getBlogLike(int bLikeId);

	List<BlogLike> listBlogLikes();
	
	List<BlogLike> listBlogLikeByCreatedAt(int bLikeId);
}
