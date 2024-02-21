package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.License;

public interface LicenseDao extends JpaRepository<License, Long>{
	License findByUserId(Long id);
	License findByLicenseNo(String LicenseNo);
	
}
