package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	public UserDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean add(User user) {
		
		user.setRole("user");
		sessionFactory.getCurrentSession().save(user);
		return false;
	}


	public List<User> listUser() {
		@SuppressWarnings("unchecked")
		
	
				List<User> listUser =(List<User>)
		sessionFactory.getCurrentSession().createCriteria(User.class).list();
		return listUser;
	}


	public User getUserById(int id) {
		String hql = "from User where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}


	public void update(User user) {
		User u = getUserById(user.getId());
		u.setName(user.getName());
		u.setAddress(user.getAddress());
		u.setEmail(user.getEmail());
		u.setMobile(user.getMobile());
		u.setRole("user");
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		sessionFactory.getCurrentSession().update(u);
		
	}


	public void delete(int id) {
		User UserToDelete = new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}


	public User authenticate(String username, String password) {
		String hql = "from User where username='"+username+"' and "+"password='"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list =(List<User>) query.list();
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


	public User getByName(String username) {
		Session session=sessionFactory.openSession();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("username", username));
		@SuppressWarnings("unchecked")
		List<User> user = c.list();
		session.flush();
		return user.get(0);
	
	}
	public void setOnline(int id) {
		String hql ="UPDATE Friend SET isOnline='Y' where id='"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}
	public void setOffline(int id) {
		String hql="UPDATE User SET isOnline = 'N' where id='" + id + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();	
	}

}
