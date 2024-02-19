package com.app.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.app.dto.AdminVehiRegDTO;
import com.app.dto.UserShowDto;
import com.app.dto.licenseAdminDTO;

public interface Adminservice {

	List<licenseAdminDTO> getLicenseApplicantList() ;

	String approveLic(Long licId);

	String rejectLic(Long licId);

	List<AdminVehiRegDTO> getVehRegisterList();

	UserShowDto getAdminDetailsById(@NotNull(message = "UserId can not be null") Long userId);

		

}
