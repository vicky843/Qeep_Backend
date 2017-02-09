package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qeepchat.model.Forum;
@Repository
public class ForumDAOImpl implements ForumDAO {

	public ForumDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean add(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
		return false;
	}


	public List<Forum> listForum() {
		@SuppressWarnings("unchecked")
		List<Forum> listForum =(List<Forum>)
		sessionFactory.getCurrentSession().createCriteria(Forum.class).list();
		return listForum;
	}


	public Forum getForumById(int forumId) {
		String hql = "from Forum where forumId=" + "'"+ forumId +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) query.list();
		
		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		return null;
	}


	public void update(Forum forum) {
		Forum f = getForumById(forum.getForumId());
		f.setForumTitle(forum.getForumTitle());;
		f.setForumDescription(forum.getForumDescription());;
		sessionFactory.getCurrentSession().update(f);
		
	}


	public void delete(int forumId) {
		Forum ForumToDelete = new Forum();
		ForumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(ForumToDelete);
	}
	 public Forum getView(int forumId) {
			
		  String hql = "from Forum where forumId=" + "'" + forumId + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			@SuppressWarnings("unchecked")
			List<Forum> listForum = (List<Forum>) query.list();

			if (listForum != null && !listForum.isEmpty()) {
				return listForum.get(0);
			}
			return null;
		}

}
