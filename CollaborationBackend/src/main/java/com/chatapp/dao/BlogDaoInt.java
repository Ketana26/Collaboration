package com.chatapp.dao;

import java.util.List;

import com.chatapp.model.Blog;

public interface BlogDaoInt {
	 boolean addBlog(Blog blog);
	 public void deleteBlog(int blogId);
	 public void editBlog(Blog blog);
	 public Blog getBlog(int blogId);
	 public List<Blog> getAllBlogs();
	 public List<Blog> waitingforApproval();
	}