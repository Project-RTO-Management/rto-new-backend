package com.app.service;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LicenseRenewDao;
import com.app.dto.LicenseRenewDto;
import com.app.dto.VehRegRenewDTO;
import com.app.entities.LearningLicenseRegister;
import com.app.entities.VehicleRegistration;

import io.swagger.v3.oas.annotations.servers.Server;


@Service
@Transactional
public class LicenceRenewServiceImpl implements LicenseRenewService{
	
	@Autowired
	private LicenseRenewDao dao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String LicenseRenew(Long userId, LicenseRenewDto licenceRenewDto) {
		LearningLicenseRegister learning=mapper.map(licenceRenewDto, LearningLicenseRegister.class);
		System.out.println(learning.getLearningLicenseNo());
//		User user = userdao.findById(userId).orElseThrow(()->new NoSuchElementException("user cant fetch"));
		
		
		//System.out.println(veh.getRegistrationNo().toString().equals(vehical.getRegistrationNo().toString()));
		
		
		learning=dao.findByLearningLicenseNo(learning.getLearningLicenseNo());
//		veh.setUser(user);
		
		
		
		
     return "Your License  renewed successfully";
		
	}

}
