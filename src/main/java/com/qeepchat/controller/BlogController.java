package com.qeepchat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.qeepchat.model.Blog;
import com.qeepchat.service.BlogService;



@RestController
public class BlogController {
	@Autowired(required=true)
	BlogService blogService;
	
	@RequestMapping(value= "/blog", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody Blog blog, UriComponentsBuilder builder) {
        boolean flag = blogService.add(blog);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/blog/{c_id}").buildAndExpand(blog.getC_id()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.PUT )
	public ResponseEntity<Blog> update(@RequestBody Blog blog) {
		blogService.update(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("c_id") int c_id) {
		blogService.delete(c_id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value= "/blog", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listBlog() {
		List<Blog> list = blogService.listBlog();
		return new ResponseEntity<List<Blog>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.GET )
	public ResponseEntity<Blog> get(@PathVariable("c_id") int c_id, HttpSession session)
	{
		Blog blog = blogService.get(c_id);
		session.setAttribute("bId",blog.getC_id());
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	 
}
