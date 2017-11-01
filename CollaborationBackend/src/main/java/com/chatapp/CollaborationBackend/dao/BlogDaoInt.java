package com.chatapp.CollaborationBackend.dao;

import java.util.List;

import com.chatapp.CollaborationBackend.model.Blog;

public interface BlogDaoInt {
	 boolean addBlog(Blog blog);
	 public void deleteBlog(String blogId);
	 public void editBlog(Blog blog);
	 public Blog getBlog(String blogId);
	 public List<Blog> getAllBlogs();
	}