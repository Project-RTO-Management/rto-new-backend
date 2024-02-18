package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.VehRegDTO;
import com.app.dto.VehRegRenewDTO;

public interface vehicalRegService {

	public VehRegDTO generateRegistrationNo(VehRegDTO vehregdto,@NotNull(message = "Id can not be null") Long userId);

	public VehRegRenewDTO generateRegistrationNoNew(Long userId, VehRegRenewDTO vehNewDto);

}
