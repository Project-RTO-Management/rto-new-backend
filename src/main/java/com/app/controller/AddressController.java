package com.app.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AddressController {
	
	@Autowired
	private AddressService adrService;

	
	@PostMapping("/permanent/{userId}")
	public ResponseEntity<?> assignPermanentAddressToUser(@PathVariable @NotNull(message = "UserId can not be null") Long userId ,@RequestBody AddressDTO adr) {
		System.out.println("in assign adr " + adr);
		
		return ResponseEntity.status(HttpStatus.CREATED).body( adrService.addPermAddress(userId,adr));
		
	}
	
	@PostMapping("/corresponding/{userId}")
	public ResponseEntity<?> assignCorrespondAddressToUser(@PathVariable @NotNull(message = "UserId can not be null") Long userId ,@RequestBody AddressDTO adr) {
		System.out.println("in assign adr " + adr);
		
		return ResponseEntity.status(HttpStatus.CREATED).body( adrService.addCorrespondeAddress(userId,adr));
		
	}
	

}

