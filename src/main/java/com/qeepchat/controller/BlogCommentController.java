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
import com.qeepchat.model.BlogComment;
import com.qeepchat.model.Friend;
import com.qeepchat.service.BlogCommentService;
import com.qeepchat.service.UserService;

@RestController
public class BlogCommentController {
	@Autowired(required=true)
	BlogCommentService blogCommentService;
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping (value="/blogcomment", method = RequestMethod.POST)
	public ResponseEntity<BlogComment> createBlogComment(@RequestBody BlogComment blogComment, HttpSession session){
			int loggedInUserId = (Integer)session.getAttribute("loggedInUserId");
			System.out.println("loggedInUserId is="+loggedInUserId);
			blogComment.setId(loggedInUserId);
			int c_id = (Integer)session.getAttribute("bId");
			System.out.println("blog id id:"+ c_id);
			blogComment.setC_id(c_id);
			blogCommentService.addBlogComment(blogComment);
			
			
		
		return new ResponseEntity<BlogComment> (blogComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogcomment", method = RequestMethod.GET )
	public ResponseEntity<List<BlogComment>> getBlogComment(HttpSession session)
	{
		int c_id = (Integer)session.getAttribute("bId");
		List<BlogComment> blogComment = blogCommentService.listBlogComments(c_id);
		return new ResponseEntity<List<BlogComment>> (blogComment,HttpStatus.OK);
	}
	@RequestMapping(value="/blogcomment/{blogCommentId}", method = RequestMethod.GET )
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("blogCommentId") int blogCommentId) 
	{
		BlogComment blogComment = blogCommentService.getBlogComment(blogCommentId);
		if(blogComment==null)
		{
			blogComment = new BlogComment();
			return new ResponseEntity<BlogComment>(blogComment,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
	}
	
	@RequestMapping(value="/blogcomment/{blogCommentId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("blogCommentId") int blogCommentId) {
		blogCommentService.deleteBlogComment(blogCommentId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
