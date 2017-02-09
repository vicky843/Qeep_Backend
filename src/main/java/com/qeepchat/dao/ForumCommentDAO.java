package com.qeepchat.dao;

import java.util.List;


import com.qeepchat.model.ForumComment;

public interface ForumCommentDAO {
	public boolean addForumComment(ForumComment forumComment);

	void deleteForumComment(int forumCommentId);

	ForumComment getForumComment(int forumCommentId);

	List<ForumComment> listForumComments();
	
	List<ForumComment> listForumByCreatedAt(int forumId);
}
