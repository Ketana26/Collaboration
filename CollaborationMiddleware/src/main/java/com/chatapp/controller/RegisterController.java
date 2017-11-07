package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.dao.RegisterDaoInt;
import com.chatapp.model.Registration;

@RestController
public class RegisterController {
	@Autowired
	private RegisterDaoInt registerDao;
	
	@PostMapping("/registerUser")
	public ResponseEntity<Registration> registerUser(@RequestBody Registration register){
		registerDao.registerUser(register);
		
		System.out.println(register.getEmailId());
				return new ResponseEntity<Registration>(register,HttpStatus.OK);		
			
		}
	
	@PostMapping("/login")
	public ResponseEntity<Registration> loginCheck(@RequestBody Registration register){
		registerDao.loginCheck(register);
		return new ResponseEntity<Registration>(register,HttpStatus.OK);
	}
}
