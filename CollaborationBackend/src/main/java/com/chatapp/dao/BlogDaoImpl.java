package com.chatapp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatapp.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDaoInt {
	
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addBlog(Blog blog) {
		System.out.println("Hello java1");
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Hello java2");
		 try{
			 session.save(blog);
			 return true;
		 }catch(Exception e)
		 {
			 System.out.println(e.getMessage());
			 return false;
		 }
	
	}

	public void deleteBlog(int blogId) {
  		Session session=sessionFactory.getCurrentSession();
  		Blog blog=session.get(Blog.class, blogId);
  		session.delete(blog);
  		
  	/*	Blog blog=new Blog();
  		Query query=session.createQuery("delete from Blog where blogId =?");
  		query.setParameter(0,blog.getBlogId());
  		System.out.println(blog);
  	 int result=query.executeUpdate(); 
  	 System.out.println(blogId);*/
 	}

	public void editBlog(Blog blog) {
		Session session = sessionFactory.getCurrentSession();
		session.update(blog);
	}

	public Blog getBlog(int blogId)
	{
		Session session=sessionFactory.getCurrentSession();		
		Blog blog=session.get(Blog.class, blogId);
		System.out.println(blogId);
		System.out.println(blog);
		blog.setApproved("True");
		session.save(blog);
		return blog;
	}
	
	
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog");
		return query.getResultList();
	}

	 public List<Blog> waitingforApproval(){
		 Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from Blog where approved = 'False'");
		   List<Blog> blogs=query.getResultList();
		   System.out.println(blogs);
		   return blogs;
	 }
	

}