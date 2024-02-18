package com.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LicenseDao;
import com.app.dto.licenseAdminDTO;
import com.app.entities.License;

@Service
@Transactional
public class AdminServiceImpl implements Adminservice{
@Autowired
private LicenseDao licdao;
@Autowired
private licenseAdminDTO dto;
@Autowired
private ModelMapper mapper;

//generate learning license
	public String generateRegistrationNumber() {
      String prefix = "PL"; // License prefix
      String suffix = "MH";
      String uniqueNumber = generateUniqueNumber(); // Generate unique number

      // Combine prefix and unique number
      String licenseNumber = prefix + uniqueNumber+suffix;

      return licenseNumber;
  }
	private String generateUniqueNumber() {
      // Generate a random number or use any other logic to ensure uniqueness
      Random random = new Random();
      int randomNumber = random.nextInt(9999999); // Adjust as needed
	

      // Convert to a fixed length string
    return String.format("%07d", randomNumber); // 5-digit number
 
}
	@Override
	public List<licenseAdminDTO> getLicenseApplicantList() {
		
		return licdao.findAll()
				.stream() //Stream<license>
				.map(lic -> mapper.map(lic,licenseAdminDTO.class)) //Stream <DTO>
				.collect(Collectors.toList());//List<DTO>	
			
	}

	@Override
	public String approveLic(@NotNull(message = "Id can not be null") Long licId) {
		License license =licdao.findById(licId).orElseThrow(() -> new NoSuchElementException());
		license.setApprove("Approved");
		license.setLicenseNo(generateRegistrationNumber());
		System.out.println(license.getLicenseNo());
		licdao.save(license);
		
		return "Application for Permanent License is Approved";
	}

}
