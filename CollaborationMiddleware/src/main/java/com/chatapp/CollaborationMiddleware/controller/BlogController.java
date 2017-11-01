package com.chatapp.CollaborationMiddleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.CollaborationBackend.dao.BlogDaoInt;
import com.chatapp.CollaborationBackend.model.Blog;

@RestController
public class BlogController {
	@Autowired
	private BlogDaoInt blogDao;
	
	@PostMapping("/blogDetails")
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
		blogDao.addBlog(blog);
		System.out.println(blog.getBlogId());
				return new ResponseEntity<Blog>(blog,HttpStatus.OK);				
		}
	@GetMapping("/reqDeleteBlog")
	public ResponseEntity<Blog> deleteBlog(@RequestParam ("blogId") String blogId){
		System.out.println(blogId);
		 blogDao.deleteBlog(blogId);
      return new ResponseEntity<Blog>(HttpStatus.OK);		
	}
	@GetMapping("getblog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable ("blogId") String blogId){
		System.out.println(blogId);
		Blog blog=blogDao.getBlog(blogId);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	
	@PostMapping("/reqeditblog")
	public ResponseEntity<Blog> editBlog(@RequestBody Blog blog){
		blogDao.editBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@GetMapping("getAllBlogs")
	public ResponseEntity<List<Blog>> getBlogs(){
		List<Blog> blogs=blogDao.getAllBlogs();
		return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	}
	
}