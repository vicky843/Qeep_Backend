package com.qeepchat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qeepchat.model.ForumLike;
import com.qeepchat.service.ForumLikeService;
import com.qeepchat.service.UserService;
@RestController
public class ForumLikeController {
	@Autowired(required=true)
	ForumLikeService forumLikeService;
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping (value="/forumlike", method = RequestMethod.POST)
	public ResponseEntity<ForumLike> createForumComment(@RequestBody ForumLike forumLike, HttpSession session){
			int loggedInUserId = (Integer)session.getAttribute("loggedInUserId");
			System.out.println("loggedInUserId is="+loggedInUserId);
			forumLike.setId(loggedInUserId);
			int forumId = (Integer)session.getAttribute("fId");
			System.out.println("forum id id:"+ forumId);
			forumLike.setForumId(forumId);
			forumLikeService.addForumLike(forumLike);
			
			
		
		return new ResponseEntity<ForumLike> (forumLike,HttpStatus.OK);
	}
	
	@RequestMapping(value="/forumlike", method = RequestMethod.GET )
	public ResponseEntity<List<ForumLike>> getForumLike(HttpSession session)
	{
		int forumId = (Integer)session.getAttribute("fId");
		List<ForumLike> forumLike = forumLikeService.listForumLikes(forumId);
		return new ResponseEntity<List<ForumLike>> (forumLike,HttpStatus.OK);
	}
	@RequestMapping(value="/forumlike/{fLikeId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("fLikeId") int fLikeId) {
		forumLikeService.deleteForumLike(fLikeId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
