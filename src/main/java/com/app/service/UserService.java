package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.UserDTO;
import com.app.dto.UserShowDto;
import com.app.entities.*;

public interface UserService {

	User authenticateUser(String em, String pass);

	String addUserDetails(UserDTO userDto);

	UserShowDto getUserDetailsById(@NotNull(message = "UserId can not be null") @NotNull(message = "UserId can not be null") Long userId);

	

	


}
