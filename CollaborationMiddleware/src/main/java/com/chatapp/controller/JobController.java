package com.chatapp.controller;

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

import com.chatapp.dao.JobDaoInt;
import com.chatapp.model.Blog;
import com.chatapp.model.Job;

@RestController
public class JobController {
	@Autowired
	private JobDaoInt jobDao;
	@PostMapping("/addJob")
	public ResponseEntity<Job> addJobDetails(@RequestBody Job job){
		jobDao.addJob(job);
		System.out.println(job.getId());
				return new ResponseEntity<Job>(job,HttpStatus.OK);

}
@GetMapping("/reqDeleteJob/{id}")
public ResponseEntity<Job> deleteJob(@PathVariable ("id") int id){
		System.out.println(id);
		jobDao.deleteJob(id);
      return new ResponseEntity<Job>(HttpStatus.OK);		
	}

@PostMapping("/reqeditjob")
public ResponseEntity<Job> editJob(@RequestBody Job job){
	jobDao.editJob(job);
	return new ResponseEntity<Job>(job,HttpStatus.OK);
}

@GetMapping("getjob/{id}")
public ResponseEntity<Job> getJob(@PathVariable ("id") int id){
	System.out.println(id);
	Job job=jobDao.getJob(id);
	return new ResponseEntity<Job>(job,HttpStatus.OK);
}

@GetMapping("getJobs")
public ResponseEntity<List<Job>> getJobs(){
	List<Job> jobs=jobDao.getAllJobs();
	return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
}


@GetMapping("/waitJob")
public ResponseEntity<List<Job>> waitingforJobApproval(){		
	List<Job> jobs=jobDao.waitingforJobApproval();
	return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
}
}

