package com.icms.party.entity;

public class UserInfo {
    private String password;
    private String email;
    private String phone;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	 public User getUser(){
	        User user = new User();
	        user.setPassword(password);
	        user.setEmail(email);
	        user.setPhone(phone);
	        
	        return user;
	    }
}
