package com.qeepchat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qeepchat.service.BlogService;
import com.qeepchat.service.UserService;
@Controller

public class QeepController {
	@Autowired(required=true)
	BlogService blogService;
	@Autowired(required=true)
	UserService userService;
	
	@RequestMapping("/")
	public String getindex(){
		return"index";
	}
		 
}





