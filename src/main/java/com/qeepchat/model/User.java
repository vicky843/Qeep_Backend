package com.qeepchat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="C_User")
public class User extends BaseDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String mobile;
	private String address;
	private String email;
	private String role;
	private String username;
	private String password;
	/*private char isOnline;*/
	@Transient
	private MultipartFile image;
	
		
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}*/
	
	public String toString()
	{
		return "{password :'"+password+"',"+"username :'"+username+"',"+"id : '" + id + "'," + "name : '" + name + "'," + "mobile :'" + mobile + "',"+"address : '" + address + "',"+"email : '" + email + "',"+"role :'"+role+"',"+"img :'resources/images/"+id+".jpg'}";
		/*return "{subcat_id :'"+subcat_id+"',"+"id : '" + id + "'," + "name : '" + name + "'," + "desc :'" + desc + "',qty : '" + qty + "',price : '" + price + "',sup_id :'"+sup_id+"'}";*/
	}

}
