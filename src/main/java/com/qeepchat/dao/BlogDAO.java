package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.Blog;



public interface BlogDAO {
	public boolean add(Blog blog);
	List<Blog> listBlog();
	public Blog get(int c_id);
	void update(Blog blog);
    void delete(int c_id);
    public Blog getView(int c_id);
}
