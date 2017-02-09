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

import com.qeepchat.model.BlogLike;
import com.qeepchat.service.BlogCommentService;
import com.qeepchat.service.BlogLikeService;
import com.qeepchat.service.UserService;
@RestController
public class BlogLikeController {
	@Autowired(required=true)
	BlogLikeService blogLikeService;
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping (value="/bloglike", method = RequestMethod.POST)
	public ResponseEntity<BlogLike> createBlogComment(@RequestBody BlogLike blogLike, HttpSession session){
			int loggedInUserId = (Integer)session.getAttribute("loggedInUserId");
			System.out.println("loggedInUserId is="+loggedInUserId);
			blogLike.setId(loggedInUserId);
			int c_id = (Integer)session.getAttribute("bId");
			System.out.println("blog id id:"+ c_id);
			blogLike.setC_id(c_id);
			blogLikeService.addBlogLike(blogLike);
			
			
		
		return new ResponseEntity<BlogLike> (blogLike,HttpStatus.OK);
	}
	
	@RequestMapping(value="/bloglike", method = RequestMethod.GET )
	public ResponseEntity<List<BlogLike>> getBlogLike(HttpSession session)
	{
		int c_id = (Integer)session.getAttribute("bId");
		List<BlogLike> blogLike = blogLikeService.listBlogLikes(c_id);
		return new ResponseEntity<List<BlogLike>> (blogLike,HttpStatus.OK);
	}
	@RequestMapping(value="/bloglike/{bLikeId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("bLikeId") int bLikeId) {
		blogLikeService.deleteBlogLike(bLikeId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
