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
import com.app.dto.PermanentLicenseDTO;
import com.app.service.LicenseService;




@RestController
@RequestMapping("/License")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class LicenseController {


@Autowired
private LicenseService service;

@PostMapping("/learning/{userId}")
	public ResponseEntity<?> applyForLearning( @PathVariable @NotNull(message = "Id can not be null") Long userId,@RequestBody LicenseDTO licdto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.generateLearningLicenseNo(userId,licdto));
				 	
	}

@PostMapping("/permanent/{userId}")
public ResponseEntity<?> applyForPermanent(@PathVariable @NotNull(message = "Learning license can not be null") Long userId,@RequestBody PermanentLicenseDTO perdto){
	return ResponseEntity.status(HttpStatus.CREATED).body(service.applyForParmanentLicense(userId,perdto));
}

//	@PostMapping("/applyLearningLicense")
//	public  ResponseEntity<License> newApplyLearningLicense(@RequestBody LicenseDTO  licenseDto, HttpSession session) {
//		
//		 //Take input data from user page like vehicle and license type and user id  in LicenseDto
//
//		License license=licenseService.addLicense(licenseDto);  
//		System.out.println("userId : "+license);
//		
//		
//		
//		return new ResponseEntity<>(license, HttpStatus.CREATED);
//	}
	

}
