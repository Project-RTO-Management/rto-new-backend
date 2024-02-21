package com.app.service;

import java.util.Set;

import com.app.dto.ExamDataDto;
import com.app.dto.ResultDTO;
import com.app.entities.ExamData;

public interface ExamService {
		
	String applyForExam(Long userId);

	Set<ExamDataDto> getExamQueSet();

	String getResult(Long userID, String status);
}
