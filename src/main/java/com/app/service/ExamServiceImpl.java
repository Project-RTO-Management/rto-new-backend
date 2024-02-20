package com.app.service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ExamDataDao;
import com.app.dao.LicenseRenewDao;
import com.app.dto.ExamDataDto;
import com.app.entities.ExamData;
import com.app.entities.LearningLicenseRegister;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private LicenseRenewDao licensedao;
	@Autowired
	private ExamDataDao examdao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String applyForExam(Long userId) {
			LearningLicenseRegister lic = licensedao.findByUserId(userId)
				.orElseThrow(() -> new NoSuchElementException());
		System.out.println(lic.getLearningLicenseNo());
	
			return "You can start exam.";
	}

	@Override
	public Set<ExamDataDto> getExamQueSet() {
		Set<ExamData> exam=	examdao.findRandom10();
		 Set<ExamDataDto> examDataDTOSet = new HashSet<>();
	        for (ExamData examData : exam) {
	            examDataDTOSet.add(mapper.map(examData, ExamDataDto.class));
	        }
	        return examDataDTOSet;
	
	}

}
