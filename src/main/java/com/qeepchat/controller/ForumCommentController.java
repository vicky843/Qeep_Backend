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

import com.qeepchat.model.ForumComment;
import com.qeepchat.service.ForumCommentService;
import com.qeepchat.service.UserService;

@RestController
public class ForumCommentController {
	@Autowired(required=true)
	ForumCommentService forumCommentService;
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping (value="/forumcomment", method = RequestMethod.POST)
	public ResponseEntity<ForumComment> createBlogComment(@RequestBody ForumComment forumComment, HttpSession session){
			int loggedInUserId = (Integer)session.getAttribute("loggedInUserId");
			System.out.println("loggedInUserId is="+loggedInUserId);
			forumComment.setId(loggedInUserId);
			int forumId = (Integer)session.getAttribute("fId");
			System.out.println("forum id id:"+ forumId);
			forumComment.setForumId(forumId);
			forumCommentService.addForumComment(forumComment);
			
			
		
		return new ResponseEntity<ForumComment> (forumComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/forumcomment", method = RequestMethod.GET )
	public ResponseEntity<List<ForumComment>> getForumComment(HttpSession session)
	{
		int forumId = (Integer)session.getAttribute("fId");
		List<ForumComment> forumComment = forumCommentService.listForumComments(forumId);
		return new ResponseEntity<List<ForumComment>> (forumComment,HttpStatus.OK);
	}
	@RequestMapping(value="/forumcomment/{forumCommentId}", method = RequestMethod.GET )
	public ResponseEntity<ForumComment> getForumComment(@PathVariable("forumCommentId") int forumCommentId) 
	{
		ForumComment forumComment = forumCommentService.getForumComment(forumCommentId);
		if(forumComment==null)
		{
			forumComment = new ForumComment();
			return new ResponseEntity<ForumComment>(forumComment,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumComment>(forumComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/forumcomment/{forumCommentId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("forumCommentId") int forumCommentId) {
		forumCommentService.deleteForumComment(forumCommentId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
