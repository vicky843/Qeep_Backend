package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.ForumLike;
@Repository
public class ForumLikeDAOImpl {

	public ForumLikeDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public ForumLikeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addForumLike(ForumLike forumLike) {
		sessionFactory.getCurrentSession().save(forumLike);
		return false;
	}

	
	public void deleteForumLike(int fLikeId) {
		ForumLike forumLikeToDelete = new ForumLike();
		forumLikeToDelete.setfLikeId(fLikeId);
		sessionFactory.getCurrentSession().delete(forumLikeToDelete);

	}

	
public ForumLike getForumLike(int fLikeId) {
		
		String hql = "from ForumLike where fLikeId=" + "'" + fLikeId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<ForumLike> listForumLike = (List<ForumLike>) query.list();

		if (listForumLike != null && !listForumLike.isEmpty()) {
			return listForumLike.get(0);
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<ForumLike> listForumLikes() {
		String hql = "from ForumLike";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumLike> listOfForumLikes = query.list();
		return listOfForumLikes;
	}

	
	public List<ForumLike> listForumLikeByCreatedAt(int fLikeId) {
		String hql = "from ForumLike where forum.fLikeId=:fLikeId ORDER BY commentedAt DESC ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("fLikeId", fLikeId);
		@SuppressWarnings("unchecked")
		List<ForumLike> listOfForumLikes = query.list();
		return listOfForumLikes;
	}


	

}
