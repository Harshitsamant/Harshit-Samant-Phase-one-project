package com.simplilearn.firstProject;

public class UserDetails {
	 
	String UserName ;
	String Password ;
	public UserDetails () {}
	public UserDetails(String userName,String password) {
		super();
		
		UserName = userName ;
		Password = password ; 
		
		// Here we have to take Input from user and have to save and protect it , a getter method returns its value while a setter method sets or updates its value. 
		
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
