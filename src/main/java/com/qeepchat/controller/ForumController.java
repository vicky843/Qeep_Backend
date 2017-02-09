package com.qeepchat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.qeepchat.model.Blog;
import com.qeepchat.model.Forum;

import com.qeepchat.service.ForumService;
@RestController
public class ForumController {
	
	@Autowired(required=true)
	ForumService forumService;
	
	@RequestMapping(value= "/forum", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Forum forum, UriComponentsBuilder builder) {
        boolean flag = forumService.add(forum);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/forum/{forumId}").buildAndExpand(forum.getForumId()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@RequestMapping(value="/forum/{forumId}", method = RequestMethod.PUT )
	public ResponseEntity<Forum> update(@RequestBody Forum forum) {
		forumService.update(forum);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
	@RequestMapping(value="/forum/{forumId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("forumId") int forumId) {
		forumService.delete(forumId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value= "/forum", method = RequestMethod.GET)
	public ResponseEntity<List<Forum>> listForum() {
		List<Forum> list = forumService.listForum();
		return new ResponseEntity<List<Forum>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/forum/{forumId}", method = RequestMethod.GET )
	public ResponseEntity<Forum> getForumById(@PathVariable("forumId") int forumId,HttpSession session) 
	{
		Forum forum = forumService.getForumById(forumId);
		session.setAttribute("fId",forum.getForumId());
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
	/*@RequestMapping(value="/forum/{forumId}", method = RequestMethod.GET )
	public ResponseEntity<Forum> get(@PathVariable("forumId") int forumId, HttpSession session)
	{
		Forum forum = forumService.getForumById(forumId);
		session.setAttribute("fId",forumId.);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}*/
}
