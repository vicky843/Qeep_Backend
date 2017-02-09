package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.Event;



public interface EventDAO {
	public boolean add(Event event);
	List<Event> listEvent();
	Event getEventById(int c_id);
	void update(Event event);
    void delete(int c_id);

}
