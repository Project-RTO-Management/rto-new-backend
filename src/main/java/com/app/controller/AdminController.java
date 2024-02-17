package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserDao;
import com.app.entities.User;


@RestController
@RequestMapping("/admin")
@CrossOrigin()
public class AdminController {
	
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		
		return userDao.findAll();
		
	}

}
