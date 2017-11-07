package com.chatapp.dao;

import java.util.List;

import com.chatapp.model.Job;

public interface JobDaoInt {
	
	public boolean addJob(Job job);
	public void deleteJob(int id);
	public void editJob(Job job);
	public Job getJob(int id);
    public List<Job> getAllJobs();
    public List<Job> waitingforJobApproval();
}