package com.john.domain;

public class user {
 String username;
 String password;
 int id;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "user [username=" + username + ", password=" + password
				+ ", id=" + id + "]\n";
	}
	

}
