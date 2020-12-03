package com.example.UserBlog.controller;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserBlog.entity.User;
import com.example.UserBlog.model.UserRequest;
import com.example.UserBlog.service.UserBlogService;
import com.example.UserBlog.validator.UserBlogValidator;

@RestController
public class UserBlogController {
	
	@Autowired 
	private UserBlogService userBlogService;
	
	@Autowired 
	private UserBlogValidator userBlogValidator;
	
    private static final ModelMapper modelMapper = new ModelMapper();

	
	  	@PostMapping("/createUser")
		@ResponseStatus(HttpStatus.CREATED)	    
	    public void createUser(@NotBlank @RequestHeader(value=HttpHeaders.AUTHORIZATION) String token, @RequestBody UserRequest userRequest) {	  		
	  		userBlogValidator.validateUser(token);
	  		userBlogValidator.validate(userRequest);
	        User user = convertToEntity(userRequest);
	        userBlogService.createUser(user);
	    }
	  	
		@GetMapping("/getUser")
		@ResponseStatus(HttpStatus.OK)
	    public UserRequest getUser(@NotBlank @RequestHeader(value=HttpHeaders.AUTHORIZATION) String token, @RequestBody UserRequest userRequest) {
	  		userBlogValidator.validateUser(token);
			userBlogValidator.validate(userRequest);
	        User user = convertToEntity(userRequest);
	        Optional<User> userCreated = userBlogService.getUser(user);
	        return convertToDto(userCreated.get());
	    }
	  	
		@PutMapping("/updateUser")
		@ResponseStatus(HttpStatus.OK)
	    public void updateUser(@NotBlank @RequestHeader(value=HttpHeaders.AUTHORIZATION) String token, @RequestBody UserRequest userRequest) {
	  		userBlogValidator.validateUser(token);
	  		userBlogValidator.validate(userRequest);
	        User user = convertToEntity(userRequest);
	        userBlogService.updateUser(user);
	    }
		
		@DeleteMapping("/deleteUser")
		@ResponseStatus(HttpStatus.OK)
	    public void deleteUser(@NotBlank @RequestHeader(value=HttpHeaders.AUTHORIZATION) String token, @RequestBody UserRequest userRequest) {
	  		userBlogValidator.validateUser(token);
	  		userBlogValidator.validate(userRequest);
	        User user = convertToEntity(userRequest);
	        userBlogService.deleteUser(user);
	    }
	  	
	  	private User convertToEntity(UserRequest userRequest) {	  		
	  		User user = modelMapper.map(userRequest, User.class);
	  		return user;
	  	}
	  	
	  	private UserRequest convertToDto(User user) {
	  		UserRequest userRequest = modelMapper.map(user, UserRequest.class);
	  		return userRequest;
	  	}


}
