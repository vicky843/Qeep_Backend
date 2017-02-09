package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.ForumLike;

public interface ForumLikeDAO {
	public boolean addForumLike(ForumLike forumLike);

	void deleteForumLike(int fLikeId);

	ForumLike getForumLike(int fLikeId);

	List<ForumLike> listForumLikes();
	
	List<ForumLike> listForumLikeByCreatedAt(int fLikeId);
}
