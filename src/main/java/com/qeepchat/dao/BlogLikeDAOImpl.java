package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.BlogLike;
@Repository
public class BlogLikeDAOImpl implements BlogLikeDAO {

	public BlogLikeDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public BlogLikeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addBlogLike(BlogLike blogLike) {
		sessionFactory.getCurrentSession().save(blogLike);
		return false;
	}

	
	public void deleteBlogLike(int bLikeId) {
		BlogLike blogLikeToDelete = new BlogLike();
		blogLikeToDelete.setbLikeId(bLikeId);
		sessionFactory.getCurrentSession().delete(blogLikeToDelete);

	}

	
public BlogLike getBlogLike(int bLikeId) {
		
		String hql = "from BlogLike where bLikeId=" + "'" + bLikeId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<BlogLike> listBlogLike = (List<BlogLike>) query.list();

		if (listBlogLike != null && !listBlogLike.isEmpty()) {
			return listBlogLike.get(0);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<BlogLike> listBlogLikes() {
		String hql = "from BlogLike";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogLike> listOfBlogLikes = query.list();
		return listOfBlogLikes;
	}

	
	public List<BlogLike> listBlogLikeByCreatedAt(int bLikeId) {
		String hql = "from BlogLike where blog.bLikeId=:bLikeId ORDER BY commentedAt DESC ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("bLikeId", bLikeId);
		@SuppressWarnings("unchecked")
		List<BlogLike> listOfBlogLikes = query.list();
		return listOfBlogLikes;
	}


	

}
