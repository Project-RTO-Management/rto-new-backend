package com.app.service;

import java.util.NoSuchElementException;
import java.util.Random;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LearnLicenseDao;
import com.app.dao.LicenseDao;
import com.app.dao.PermanentLicenseDao;
import com.app.dao.UserDao;
import com.app.dto.LicenseDTO;
import com.app.dto.PermanentLicenseDTO;
import com.app.entities.LearningLicenseRegister;
import com.app.entities.License;
import com.app.entities.PermanentLicenseRegister;
import com.app.entities.User;


@Service
@Transactional
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserDao userDao;
	@Autowired
	private LearnLicenseDao dao;
	@Autowired
	private PermanentLicenseDao perdao;
	@Autowired
	private LicenseDao licdao;
	
	

  //generate learning license
  		public String generateRegistrationNumber() {
  	        String prefix = "DL"; // License prefix
  	        String uniqueNumber = generateUniqueNumber(); // Generate unique number

  	        // Combine prefix and unique number
  	        String licenseNumber = prefix + uniqueNumber;

  	        return licenseNumber;
  	    }
  		private String generateUniqueNumber() {
  	        // Generate a random number or use any other logic to ensure uniqueness
  	        Random random = new Random();
  	        int randomNumber = random.nextInt(99999); // Adjust as needed
			

  	        // Convert to a fixed length string
  	      return String.format("%05d", randomNumber); // 5-digit number
  	   
  }
 
  		
  		
	@Override
	public LicenseDTO generateLearningLicenseNo( @NotNull(message = "Id can not be null") Long userId,LicenseDTO licdto) {
		LearningLicenseRegister license = mapper.map(licdto,LearningLicenseRegister.class);
		
		System.out.println(license.toString());
		System.out.println(license.getAge() >18 && license.getAge() <60);
		System.out.println(String.valueOf(license.getAdharcardNumber()).length() == 12);
		
		if(license.getAge() >18 && license.getAge() <60 && String.valueOf(license.getAdharcardNumber()).length() == 12) {
		User user = userDao.findById(userId).orElseThrow(()-> new NoSuchElementException("Id not found"));
		license.setLearningLicenseNo(this.generateRegistrationNumber());
		license.setUser(user);
		dao.save(license);
		
		return mapper.map(dao.save(license), LicenseDTO.class);
		}
//		else
//			return mapper.map(, null)
//			//return "redirect:/users/home";
		return licdto;
	}
	
	
	@Override
	public String applyForParmanentLicense(@NotNull(message = "Learning license can not be null") Long userId,
			PermanentLicenseDTO perdto) {
		PermanentLicenseRegister license = mapper.map(perdto, PermanentLicenseRegister.class);
//		System.out.println(license.getLearningLicNo());
		System.out.println(license);
	  User user = userDao.findById(userId).orElseThrow(()-> new NoSuchElementException("User not found"));
		LearningLicenseRegister learn = dao.findByUserId(userId).orElseThrow(()-> new NoSuchElementException("Learning license not found"));
	  System.out.println(learn.getLearningLicenseNo().toString());
	  boolean b = license.getLearningLicNo().trim().equalsIgnoreCase(learn.getLearningLicenseNo().toString().trim()) ;
	  System.out.println(b);
	
	  if(license.getLearningLicNo().trim().equalsIgnoreCase(learn.getLearningLicenseNo().toString().trim())) {
		
//		   if(learn.getResult().equalsIgnoreCaseeCase("PASS")) {
		  System.out.println(learn.getResult().toString());
		  if(learn.getResult().equalsIgnoreCase("PASS")) {
			  license.setLearn(learn);
			  license.setUser(user);
			  license.setResultStatus(learn.getResult());
			  perdao.save(license);
			  
			  
				//to save data in license table for admin view
			  License lic =new License();
				lic.setLicenseHolder(user.getUserName());
				lic.setLicenseType("Permanent");
				lic.setApprove("NO");
				lic.setExamStatus("Pass");
				lic.setVehicleType(learn.getVehicleType());
				lic.setDateOfApply(license.getDateOfAppl());
				lic.setUser(user);
				licdao.save(lic);
				
				
			  return "Registration for Permanent License is successfull";
			  }
		  return "Your Online Exam result is 'FAIL'. Please, Reappear for Exam";
	  }
		return "Please give correct Learning License Number";
	}
	
	@Override
	public String getPermanentLicNo(@NotNull(message = "Learning license can not be null") Long userId) {
		License lic= licdao.findByUserId(userId);
//		if(lic.getApprove().equalsIgnoreCase("Approved"))
//			return lic.getLicenseNo();
//		else
//		return "Your Application for PermanentLicense is still pending" ;
		
		 if (lic != null) {
		        String approvalStatus = lic.getApprove();
		        if ("Approved".equalsIgnoreCase(approvalStatus)) 
		            return lic.getLicenseNo();
		        else if ("Rejected".equalsIgnoreCase(approvalStatus)) 
		            return "Your application for a Permanent License has been rejected";
		        else 
		            return "Your application for a Permanent License is still pending";
		    }
	     else 
		        return "No license found for the given user ID";
	}

}






