package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.BlogDAOImpl;

import com.qeepchat.model.Blog;


@Service
@Transactional
public class BlogService {
	@Autowired(required=true)
	BlogDAOImpl blogDAO;
	
	
public boolean add(Blog blog){
	     blogDAO.add(blog);
         return true; 
}

public void update(Blog blog){
	blogDAO.update(blog);
}

public List<Blog> listBlog(){
	return blogDAO.listBlog();
}

public void delete(Integer c_id) {
	blogDAO.delete(c_id);
	
}
public Blog get(int c_id){
	return blogDAO.get(c_id);
}
public Blog getView(int c_id){
	return blogDAO.getView(c_id);
}

}
