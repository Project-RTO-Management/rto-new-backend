package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ExamService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class ExamController {

	@Autowired
	private ExamService examService;

	@GetMapping("/{userID}")
	public ResponseEntity<?> getLicenseIdById(@PathVariable Long userID,@RequestBody String license) {

		return ResponseEntity.status(HttpStatus.OK).body(examService.applyForExam(userID,license)) ;
	}

	
	@PostMapping("/test")
	public ResponseEntity<?> getExamQue(){
		return ResponseEntity.status(HttpStatus.OK).body(examService.getExamQueSet());
		
	}
}
