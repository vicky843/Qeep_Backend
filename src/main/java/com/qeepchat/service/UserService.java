package com.qeepchat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qeepchat.dao.UserDAOImpl;
import com.qeepchat.model.User;

@Service
@Transactional
public class UserService {
	@Autowired(required=true)
	UserDAOImpl userDAO;
	
public boolean add(User user){
	     userDAO.add(user);
         return true; 
}

public void update(User user){
	userDAO.update(user);
}

public List<User> listUser(){
	return userDAO.listUser();
}

public void delete(Integer id) {
	userDAO.delete(id);
	
}
public User getUserById(int id){
	return userDAO.getUserById(id);
}
public User getByName(String username){
	   return userDAO.getByName(username);
}
public User authenticate(String username, String password){
	return userDAO.authenticate(username, password);
}
public void setOnline(int id){
	 userDAO.setOnline(id);
}
public void setOffline(int id)
{
	userDAO.setOffline(id);
}
}
