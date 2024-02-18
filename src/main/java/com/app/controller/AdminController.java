package com.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.Adminservice;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AdminController {
@Autowired
private Adminservice service;

	@GetMapping("/licenselist")
	public ResponseEntity<?> getLicenseList(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getLicenseApplicantList());
		
	}
	
	@PostMapping("/approve")   //   /{licenseId}
	public ResponseEntity<?> approveLicense(@RequestBody Long licId){
		return ResponseEntity.status(HttpStatus.OK).body(service.approveLic(licId));
	}
}
