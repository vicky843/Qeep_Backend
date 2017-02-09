package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.Blog;
import com.qeepchat.model.BlogComment;

@Repository
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	public BlogCommentDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addBlogComment(BlogComment blogComment) {
		sessionFactory.getCurrentSession().save(blogComment);
		return false;
	}

	
	public void deleteBlogComment(int blogCommentId) {
		BlogComment blogCommentToDelete = new BlogComment();
		blogCommentToDelete.setBlogCommentId(blogCommentId);
		sessionFactory.getCurrentSession().delete(blogCommentToDelete);

	}

	
public BlogComment getBlogComment(int blogCommentId) {
		
		String hql = "from BlogComment where blogCommentId=" + "'" + blogCommentId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<BlogComment> listBlogComment = (List<BlogComment>) query.list();

		if (listBlogComment != null && !listBlogComment.isEmpty()) {
			return listBlogComment.get(0);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<BlogComment> listBlogComments() {
		String hql = "from BlogComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listOfBlogComments = query.list();
		return listOfBlogComments;
	}

	
	public List<BlogComment> listBlogByCreatedAt(int c_id) {
		String hql = "from BlogComment where blog.blogId=:blogId ORDER BY commentedAt DESC ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("c_id", c_id);
		@SuppressWarnings("unchecked")
		List<BlogComment> listOfBlogComments = query.list();
		return listOfBlogComments;
	}

	

}
