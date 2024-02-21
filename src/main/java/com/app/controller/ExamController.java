package com.app.controller;

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

import com.app.dto.ResultDTO;
import com.app.service.ExamService;

@RestController
@RequestMapping("/exam")
@CrossOrigin()
@Validated
public class ExamController {

	@Autowired
	private ExamService examService;

	@GetMapping("/{userID}")
	public ResponseEntity<?> getLicenseIdById(@PathVariable Long userID) {
 			return ResponseEntity.status(HttpStatus.OK).body(examService.applyForExam(userID));
	}

	
	@GetMapping("/test")
	public ResponseEntity<?> getExamQue(){
		return ResponseEntity.status(HttpStatus.OK).body(examService.getExamQueSet());
		
	}
	
	  @PostMapping("/test/result/{userId}/{status}")
	    public ResponseEntity<?> getResultStatus(@PathVariable Long userId, @PathVariable String status) {
	        return ResponseEntity.status(HttpStatus.OK).body(examService.getResult(userId, status));
	    }
	
//	@PostMapping("/test/result/{userID}")
//	public ResponseEntity<?> getResultStatus(@PathVariable Long userID,@RequestBody ResultDTO resultDto){
//		System.out.println("result:"+resultDto.getResult().toString());
//		return ResponseEntity.status(HttpStatus.OK).body(examService.getResult(userID,resultDto));
//		
//	}
}

