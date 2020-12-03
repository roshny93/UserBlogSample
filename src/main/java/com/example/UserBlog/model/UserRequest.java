package com.example.UserBlog.model;

import java.util.List;

public class UserRequest {
	
	private int userId;
	private String userType;
	private List<PictureRequest> picture;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<PictureRequest> getPicture() {
		return picture;
	}
	public void setPicture(List<PictureRequest> picture) {
		this.picture = picture;
	}

}
