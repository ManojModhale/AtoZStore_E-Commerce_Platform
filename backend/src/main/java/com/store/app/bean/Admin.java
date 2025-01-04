package com.store.app.bean;

public class Admin 
{
	private String username;
	private String password;	
	private String role="Admin";
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}
