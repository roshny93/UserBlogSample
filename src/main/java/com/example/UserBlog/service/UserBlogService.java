package com.example.UserBlog.service;

import java.util.Optional;

import com.example.UserBlog.entity.User;

public interface UserBlogService {
	
     User createUser(User user) ;

	 Optional<User> getUser(User user);

	 User updateUser(User user);

	 void deleteUser(User user);


}
