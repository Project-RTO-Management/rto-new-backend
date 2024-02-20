package com.app.service;


import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.NoSuchElementException;
import com.app.dao.UserDao;
import com.app.dto.UserDTO;
import com.app.dto.UserShowDto;
import com.app.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;
@Autowired
private UserDTO userDto;
@Autowired
private ModelMapper mapper;

@Override
public User authenticateUser(String em, String pass) {

	User u=  userDao.findByEmailAndPassword(em, pass).orElseThrow();
	//System.out.println(u);
	return u;
	
	
}

@Override
public String addUserDetails( UserDTO userdto) {
	User user = mapper.map(userdto, User.class);
	userDao.save(user);
	return "Added new user ....";
}

@Override
public UserShowDto getUserDetailsById(@NotNull(message = "UserId can not be null") Long userId) {
	
	return mapper.map(userDao.findById(userId).orElseThrow(() -> new NoSuchElementException("Personal Details can't fetched")), UserShowDto.class);
}



}
