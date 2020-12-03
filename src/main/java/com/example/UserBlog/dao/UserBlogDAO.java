package com.example.UserBlog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserBlog.entity.User;

@Repository
public interface UserBlogDAO extends JpaRepository<User , Long>{
}
