package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.AddressDTO;

public interface AddressService {
	String addPermAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr);

	String addCorrespondeAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr);

}
