package com.epam.businessObjects;

public class User {
	String userName;
	String password;

	public User() {
		userName = "";
		password = "";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
