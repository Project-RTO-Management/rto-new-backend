package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

@Repository
public abstract class UserDAoImpl implements UserDao {

	@Autowired
	private User user;
}
