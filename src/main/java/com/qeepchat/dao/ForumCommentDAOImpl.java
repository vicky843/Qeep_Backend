package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.ForumComment;


@Repository
public class ForumCommentDAOImpl implements ForumCommentDAO {
	public ForumCommentDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public ForumCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addForumComment(ForumComment forumComment) {
		sessionFactory.getCurrentSession().save(forumComment);
		return false;
	}

	
	public void deleteForumComment(int forumCommentId) {
		ForumComment forumCommentToDelete = new ForumComment();
		forumCommentToDelete.setForumCommentId(forumCommentId);
		sessionFactory.getCurrentSession().delete(forumCommentToDelete);

	}

	
public ForumComment getForumComment(int forumCommentId) {
		
		String hql = "from ForumComment where forumCommentId=" + "'" + forumCommentId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<ForumComment> listForumComment = (List<ForumComment>) query.list();

		if (listForumComment != null && !listForumComment.isEmpty()) {
			return listForumComment.get(0);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<ForumComment> listForumComments() {
		String hql = "from ForumComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumComment> listOfForumComments = query.list();
		return listOfForumComments;
	}

	
	public List<ForumComment> listForumByCreatedAt(int forumId) {
		String hql = "from BlogComment where forum.forumId=:forumId ORDER BY commentedAt DESC ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("forumId", forumId);
		@SuppressWarnings("unchecked")
		List<ForumComment> listOfForumComments = query.list();
		return listOfForumComments;
	}

	

}
