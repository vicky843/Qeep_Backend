package com.qeepchat.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qeepchat.model.User;
import com.qeepchat.service.FriendService;
import com.qeepchat.service.UserService;

@RestController
public class UserController {
	@Autowired(required=true)
	UserService userService;
	@Autowired(required=true)
	FriendService friendService;
	
	/*@RequestMapping(value= "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.add(user);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/
	

	@RequestMapping(value="/user/{id}", method = RequestMethod.PUT )
	public ResponseEntity<User> update(@RequestBody User user) {
		userService.update(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		userService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value= "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listUser() {
		List<User> list = userService.listUser();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET )
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/myProfile", method=RequestMethod.GET)
	public ResponseEntity<User> myProfile(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		User user=userService.getUserById(loggedInUserID);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@RequestMapping(value="/user", method =RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "name")String name,
			@RequestParam(value="email") String email, @RequestParam(value="address")String address, @RequestParam(value="mobile")String mobile,
			@RequestParam(value="username")String username, @RequestParam(value="password")String password, HttpServletRequest request){
	User user= new User();
	if(userService.getUserById(user.getId())==null)
	{
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setMobile(mobile);
		user.setRole("user");
		user.setUsername(username);
		user.setPassword(password);
		userService.add(user);
		
		int Id = user.getId();
		System.out.println("Id"+Id);
		
		String rootDirectory ="F:\\Projectqeep\\Qeep-FrontEnd\\src\\main\\webapp\\resources\\images\\"+Id+".jpg";
		
		 /*String s= user.getName();
		System.out.println("Name"+s);
		
		String rootDirectory ="F:\\Projectqeep\\Qeep-FrontEnd\\src\\main\\webapp\\resources\\images\\"+s+".jpg";
		*/
		File f = new File(rootDirectory);
		System.out.println("Root Directory"+rootDirectory);
		
		if (!file.isEmpty()){
			try{
				byte[] bytes =file.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs =new BufferedOutputStream(fos);
				bs.write(bytes);
				bs.close();
				System.out.println("File successfully upload"+ rootDirectory);
			}
			catch(Exception ex){
				System.out.println("Exception Occured"+ ex);
			}
		}
		else{
			System.out.println("File is empty not uploaded");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	return new ResponseEntity<User>(user, HttpStatus.OK);	
	}

	@RequestMapping(value="/user/authenticate/",method= RequestMethod.POST)
	public ResponseEntity<User> authenticate(@RequestBody User user,HttpSession session){
		user = userService.authenticate(user.getUsername(),user.getPassword());
		if(user==null){
			user= new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invalid Credentials.Please enter valid credentials");
			
			
		}
		else
		{
			user.setErrorCode("200");
			session.setAttribute("loggedInUser",user);
			session.setAttribute("loggedInUserId",user.getId());
			System.out.println("username is"+user.getUsername());
			
			String currentUserName=user.getName();
			session.setAttribute("currentUserName", currentUserName);
			
			System.out.println("password is"+user.getPassword());
			friendService.setOnline(user.getId());
			
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/logout",method = RequestMethod.GET)
	public String logout(HttpSession session){
		@SuppressWarnings("unused")
		int loggedInUserID =(Integer)session.getAttribute("loggedInUserId");
		
	session.invalidate();
	return ("You successfully loggedout");
	}
}
