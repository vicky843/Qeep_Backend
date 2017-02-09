package com.qeepchat.dao;

import java.util.List;
import com.qeepchat.model.Forum;

public interface ForumDAO {

	public boolean add(Forum forum);
	
	List<Forum> listForum();
	
	Forum getForumById(int forumId);
	
	void update(Forum forum);
	
    void delete(int forumId);
    public Forum getView(int forumId);
}
