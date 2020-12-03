package com.example.UserBlog.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Picture {
	
	@Id
	private Long id;
	
	@OneToMany(mappedBy="picture")
	private List<Tag> tag;
	
	@OneToMany(mappedBy="picture")
	private List<Like> like;
	
	@ManyToOne
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public List<Tag> getTag() {
		return tag;
	}
	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}
	public List<Like> getLike() {
		return like;
	}
	public void setLike(List<Like> like) {
		this.like = like;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
