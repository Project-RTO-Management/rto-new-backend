package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.LicenseDTO;
import com.app.dto.PermanentLicenseDTO;

public interface LicenseService{

	LicenseDTO generateLearningLicenseNo( @NotNull(message = "Id can not be null") Long userId,LicenseDTO licdto);

	String applyForParmanentLicense(@NotNull(message = "Learning license can not be null") Long userId,
			PermanentLicenseDTO perdto);

	String getPermanentLicNo(@NotNull(message = "Learning license can not be null") Long userId);



}
