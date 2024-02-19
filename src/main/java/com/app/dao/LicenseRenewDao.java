package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.LearningLicenseRegister;
import com.app.entities.VehicleRegistration;

public interface LicenseRenewDao  extends  JpaRepository<LearningLicenseRegister, Long>{

	
	
	//Optional<LearningLicenseRegister> findLicenseIdByUserId(Long userId);
	Optional<LearningLicenseRegister> findByUserId(Long id);

	LearningLicenseRegister findByLearningLicenseNo(String learningLicenseNo);
	
	
	
}

