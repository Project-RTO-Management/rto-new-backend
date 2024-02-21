package com.app.service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ExamDataDao;
import com.app.dao.LearnLicenseDao;
import com.app.dao.PermanentLicenseDao;
import com.app.dto.ExamDataDto;
import com.app.dto.ResultDTO;
import com.app.entities.ExamData;
import com.app.entities.LearningLicenseRegister;
import com.app.entities.PermanentLicenseRegister;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {
	@Autowired
	private PermanentLicenseDao perdao;
	@Autowired
	private LearnLicenseDao licensedao;
	@Autowired
	private ExamDataDao examdao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String applyForExam(Long userId) {
		LearningLicenseRegister lic = licensedao.findByUserId(userId).orElseThrow(() -> new NoSuchElementException());
		System.out.println(lic.getLearningLicenseNo());

		return "You can start exam.";
	}

	@Override
	public Set<ExamDataDto> getExamQueSet() {
		Set<ExamData> exam = examdao.findRandom10();
		Set<ExamDataDto> examDataDTOSet = new HashSet<>();
		for (ExamData examData : exam) {
			examDataDTOSet.add(mapper.map(examData, ExamDataDto.class));
		}
		return examDataDTOSet;

	}

	
	@Override
	public String getResult(Long userId, int result) {
	    LearningLicenseRegister lic = licensedao.findByUserId(userId)
	            .orElseThrow(() -> new NoSuchElementException());

	    if (result == 0) {
	        lic.setResult("Fail");
	    } else {
	        lic.setResult("Pass");
	    }

	    licensedao.save(lic);

	    PermanentLicenseRegister perlic = perdao.findByUserId(userId)
	            .orElseThrow(() -> new NoSuchElementException());
	    perlic.setResultStatus(lic.getResult());
	    perdao.save(perlic);

	    return lic.getResult();
	}


}
