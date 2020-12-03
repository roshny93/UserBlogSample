package com.example.UserBlog.model;

import java.util.List;

public class PictureRequest {
	
	private int pictureId;
	private List<TagRequest> tag;
	private List<LikeRequest> like;
	
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public List<TagRequest> getTag() {
		return tag;
	}
	public void setTag(List<TagRequest> tag) {
		this.tag = tag;
	}
	public List<LikeRequest> getLike() {
		return like;
	}
	public void setLike(List<LikeRequest> like) {
		this.like = like;
	}



}
