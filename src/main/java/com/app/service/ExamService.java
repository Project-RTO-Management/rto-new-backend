package com.app.service;

import java.util.Set;

import com.app.dto.ExamDataDto;
import com.app.entities.ExamData;

public interface ExamService {
		
	String applyForExam(Long userId);

	Set<ExamDataDto> getExamQueSet();
}
