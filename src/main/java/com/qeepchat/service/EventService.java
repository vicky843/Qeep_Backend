package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.EventDAOImpl;
import com.qeepchat.model.Event;


@Service
@Transactional
public class EventService {
	@Autowired(required=true)
	EventDAOImpl eventDAO;
	
	
public boolean add(Event event){
	     eventDAO.add(event);
         return true; 
}

public void update(Event event){
	eventDAO.update(event);
}

public List<Event> listEvent(){
	return eventDAO.listEvent();
}

public void delete(int c_id) {
	eventDAO.delete(c_id);
	
}
public Event getEventById(int c_id){
	return eventDAO.getEventById(c_id);
}
}
