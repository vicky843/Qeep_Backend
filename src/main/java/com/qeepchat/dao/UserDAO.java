package com.qeepchat.dao;

import java.util.List;

import com.qeepchat.model.User;

public interface UserDAO {
	public boolean add(User user);
	List<User> listUser();
	public User getUserById(int id);
	public User getByName(String name);
	void update(User user);
    void delete(int id);
    User authenticate(String username, String password);
    public void setOnline(int id);
    public void setOffline(int id);
}
