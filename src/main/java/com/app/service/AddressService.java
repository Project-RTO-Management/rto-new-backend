package com.app.service;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;

public interface AddressService {
	String addPermAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr);

	String addCorrespondeAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr);

}
