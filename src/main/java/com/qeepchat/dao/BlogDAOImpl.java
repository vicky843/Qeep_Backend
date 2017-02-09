package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.Blog;


@Repository
public class BlogDAOImpl implements BlogDAO {
	


	public BlogDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean add(Blog blog) {
		sessionFactory.getCurrentSession().save(blog);
		return false;
	}


	public List<Blog> listBlog() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog =(List<Blog>)
		sessionFactory.getCurrentSession().createCriteria(Blog.class).list();
		return listBlog;
	}


public Blog get(int c_id) {
		
		String hql = "from Blog where c_id=" + "'" + c_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}


	public void update(Blog blog) {
		Blog b = get(blog.getC_id());
		b.setC_title(blog.getC_title());
		b.setC_desc(blog.getC_desc());
		sessionFactory.getCurrentSession().update(b);
		
	}


	public void delete(int c_id) {
		Blog BlogToDelete = new Blog();
		BlogToDelete.setC_id(c_id);
		sessionFactory.getCurrentSession().delete(BlogToDelete);
		
	}
  public Blog getView(int c_id) {
		
	  String hql = "from Blog where c_id=" + "'" + c_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();

		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}
}
