package com.qeepchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="C_Blog")
public class Blog {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int c_id;
private String c_title;
private String c_desc;
private int id;
@ManyToOne
@JoinColumn(name="id",insertable=false,updatable=false,nullable=false)
User user;
public int getC_id() {
	return c_id;
}
public void setC_id(int c_id) {
	this.c_id = c_id;
}
public String getC_title() {
	return c_title;
}
public void setC_title(String c_title) {
	this.c_title = c_title;
}
public String getC_desc() {
	return c_desc;
}
public void setC_desc(String c_desc) {
	this.c_desc = c_desc;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public String toString()
{
	return "{c_id :'"+c_id+"',"+"id : '" + id + "'," + "c_title : '" + c_title + "'," + "c_desc :'" + c_desc + "'}";
	/*return "{subcat_id :'"+subcat_id+"',"+"id : '" + id + "'," + "name : '" + name + "'," + "desc :'" + desc + "',qty : '" + qty + "',price : '" + price + "',sup_id :'"+sup_id+"'}";*/
}
}