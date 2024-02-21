package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.UserDTO;
import com.app.dto.UserShowDto;
import com.app.entities.User;

public interface UserDao extends JpaRepository<User, Long>  {

	Optional<User> findByEmailAndPassword(String em, String pass);

	User save(UserShowDto existingUser);

}
