package com.app.controller;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LicenseDTO;
import com.app.dto.LicenseRenewDto;
import com.app.dto.PermanentLicenseDTO;
import com.app.dto.VehRegRenewDTO;
import com.app.service.LicenseRenewService;
import com.app.service.LicenseService;




@RestController
@RequestMapping("/License")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class LicenseController {


@Autowired
private LicenseService service;

@Autowired
private LicenseRenewService renewService;

@PostMapping("/learning/{userId}")
	public ResponseEntity<?> applyForLearning( @PathVariable @NotNull(message = "Id can not be null") Long userId,@RequestBody LicenseDTO licdto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.generateLearningLicenseNo(userId,licdto));
				 	
	}

@PostMapping("/permanent/{userId}")
public ResponseEntity<?> applyForPermanent(@PathVariable @NotNull(message = "Learning license can not be null") Long userId,@RequestBody PermanentLicenseDTO perdto){
	return ResponseEntity.status(HttpStatus.CREATED).body(service.applyForParmanentLicense(userId,perdto));
}

@PostMapping("/licenseno/{userId}")
public ResponseEntity<?> getPermanentLicenseNo(@PathVariable @NotNull(message = "Learning license can not be null") Long userId){
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getPermanentLicNo(userId));
	
	


}



@PostMapping("/renewLicense/{userId}")
public ResponseEntity<?> LicenseRenew(@PathVariable Long userId,@RequestBody LicenseRenewDto licenseRenewDto)
	{
	
		return ResponseEntity.status(HttpStatus.CREATED).body(renewService.LicenseRenew(userId, licenseRenewDto));
		
	}
}
