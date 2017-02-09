package com.qeepchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.qeepchat.model.Event;
import com.qeepchat.service.EventService;


@RestController
public class EventController {
	@Autowired(required=true)
	EventService eventService;
	
	@RequestMapping(value= "/event", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Event event, UriComponentsBuilder builder) {
        boolean flag = eventService.add(event);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/event/{c_id}").buildAndExpand(event.getC_id()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@RequestMapping(value="/event/{c_id}", method = RequestMethod.PUT )
	public ResponseEntity<Event> update(@RequestBody Event event) {
		eventService.update(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	@RequestMapping(value="/event/{c_id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("c_id") int c_id) {
		eventService.delete(c_id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value= "/event", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> listEvent() {
		List<Event> list = eventService.listEvent();
		return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/event/{c_id}", method = RequestMethod.GET )
	public ResponseEntity<Event> getEventById(@PathVariable("c_id") int c_id) {
		Event event = eventService.getEventById(c_id);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

}
