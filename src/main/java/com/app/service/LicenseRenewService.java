package com.app.service;

import com.app.dto.LicenseRenewDto;
import com.app.dto.VehRegRenewDTO;

public interface LicenseRenewService

{
	public String LicenseRenew(Long userId,LicenseRenewDto licenceRenewDto);

}
