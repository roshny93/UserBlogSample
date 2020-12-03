package com.example.UserBlog.validator;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.UserBlog.exception.UserBlogException;
import com.example.UserBlog.model.PictureRequest;
import com.example.UserBlog.model.UserRequest;

@Service
public class UserBlogValidator {
	
	@Value("auth.user")
	private String userid;
	@Value("auth.password")
	private String password;


	public void validate(UserRequest userRequest)  {
		if ("Resource Owner".equals(userRequest.getUserType())) {
			for (PictureRequest pic : userRequest.getPicture()) {
				if (pic.getTag().size() > 10) {
					throw new UserBlogException("Tag Limit exceeded");
				}
			}

		} else if ("Non-Resource Owner".equals(userRequest.getUserType())) {

			for (PictureRequest pic : userRequest.getPicture()) {
				if (pic.getTag().size() > 0) {
					throw new UserBlogException("Tags are not valid for this user");
				}
			}

		} else {
			throw new UserBlogException("Invalid user type");
		}
	}
	
	public void validateUser(String token)  {
		String plainToken = new String( Base64.decodeBase64(token), StandardCharsets.UTF_8);
		if(StringUtils.isNotBlank(plainToken)) {
			String[] tokenSplit = plainToken.split(":");
			if(tokenSplit.length!=2) {
			throw new UserBlogException("Invalid User");
			}else if(!tokenSplit[0].equals(userid) || !tokenSplit[1].equals(password)) {
			throw new UserBlogException("Invalid User");
			}
		} else {
		throw new UserBlogException("Invalid User");

		}

	}
	
}
