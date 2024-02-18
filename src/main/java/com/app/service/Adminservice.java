package com.app.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.app.dto.licenseAdminDTO;
import com.app.entities.License;

public interface Adminservice {

	List<licenseAdminDTO> getLicenseApplicantList() ;

	String approveLic( @NotNull(message = "Id can not be null") Long licId);
		

}
