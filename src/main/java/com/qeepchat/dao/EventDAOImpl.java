package com.qeepchat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qeepchat.model.Event;
@Repository
public class EventDAOImpl implements EventDAO {
	public EventDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public boolean add(Event event) {
		sessionFactory.getCurrentSession().save(event);
		return false;
	}


	public List<Event> listEvent() {
		@SuppressWarnings("unchecked")
		List<Event> listEvent =(List<Event>)
		sessionFactory.getCurrentSession().createCriteria(Event.class).list();
		return listEvent;
	}


	public Event getEventById(int c_id) {
		String hql = "from Event where c_id=" + "'"+ c_id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Event> listEvent = (List<Event>) query.list();
		
		if (listEvent != null && !listEvent.isEmpty()) {
			return listEvent.get(0);
		}
		return null;
	}


	public void update(Event event) {
		
		sessionFactory.getCurrentSession().update(event);
		
	}


	public void delete(int c_id) {
		Event EventToDelete = new Event();
		EventToDelete.setC_id(c_id);
		sessionFactory.getCurrentSession().delete(EventToDelete);
		
	}
}
