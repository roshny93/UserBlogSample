package com.example.UserBlog.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserBlog.dao.UserBlogDAO;
import com.example.UserBlog.entity.User;
import com.example.UserBlog.service.UserBlogService;

@Service
public class UserBlogServiceImpl implements  UserBlogService{
	
	@Autowired
	private UserBlogDAO userBlogDAO;

	@Override
	public User createUser(User user) {
		User userResult = userBlogDAO.save(user);
		return userResult;
	}

	@Override
	public Optional<User> getUser(User user) {
		Optional<User> userResult = userBlogDAO.findById(user.getId());
		return userResult;
	}

	@Override
	public User updateUser(User user) {
		User userResult = userBlogDAO.save(user);
		return userResult;
	}

	@Override
	public void deleteUser(User user) {
		userBlogDAO.delete(user);	
	}

}
