package com.example.UserBlog.exception;

public class UserBlogException extends RuntimeException{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserBlogException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UserBlogException(String arg0) {
		super(arg0);
	}

}
