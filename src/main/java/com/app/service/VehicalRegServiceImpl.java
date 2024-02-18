package com.app.service;



import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexception.NoSuchElementException;
import com.app.dao.UserDao;
import com.app.dao.VehRegDAO;
import com.app.dto.VehRegDTO;
import com.app.dto.VehRegRenewDTO;
import com.app.entities.User;
import com.app.entities.VehicleRegistration;



@Service
@Transactional
public class VehicalRegServiceImpl implements vehicalRegService {
@Autowired
public UserDao userDao;
	@Autowired
	public VehRegDAO dao;
	
	 @Autowired
	 public ModelMapper mapper;
	 
	 @Autowired
	 private UserDao userdao;
	 
	
	
	// Method to generate a random alphanumeric registration number
	    public String generateRegistrationNumber() {
	        // You can customize the logic to generate registration numbers based on your requirements
	        String registrationNumber = ""; // Initialize an empty string

	        // Generate a random string of alphanumeric characters
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        int length = 10; // Length of the registration number

	        for (int i = 0; i < length; i++) {
	            int index = (int) (Math.random() * characters.length());
	            registrationNumber += characters.charAt(index);
	        }

	        return registrationNumber;
	    }

	    public String generateMaharashtraNumberPlate() {
	   	 final String[] STATE_CODES = {"MH"};
	      final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	      final int[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	      final Random random = new Random();
	          StringBuilder plateNumber = new StringBuilder();

	          // State code
	          plateNumber.append(STATE_CODES[random.nextInt(STATE_CODES.length)]).append(" ");

	          // District code (two digits)
	          plateNumber.append(String.format("%02d", random.nextInt(99))).append(" ");

	          // Alphabets (two letters)
	          plateNumber.append(LETTERS[random.nextInt(LETTERS.length)]);
	          plateNumber.append(LETTERS[random.nextInt(LETTERS.length)]).append(" ");

	          // Year (four digits)
	          plateNumber.append(String.format("%04d", 1950 + random.nextInt(75))); // 1950 to 2024

	          return plateNumber.toString();
	      }
	   

		@Override
		public VehRegDTO generateRegistrationNo(VehRegDTO vehregdto, @NotNull(message = "Id can not be null") Long userId) {
			VehicleRegistration veh=mapper.map(vehregdto, VehicleRegistration.class);
			User user =userDao.findById(userId).orElseThrow(() -> new NoSuchElementException("User can't fetched"));
			veh.setUser(user);
			veh.setRegistrationNo(this.generateRegistrationNumber());
			veh.setNumberPlate(this.generateMaharashtraNumberPlate());
			
			return mapper.map(dao.save(veh), VehRegDTO.class); 
		}

		//Renew Regiseteration
		public VehRegRenewDTO generateRegistrationNoNew(Long userId,VehRegRenewDTO vehNewDto) {
			VehicleRegistration veh=mapper.map(vehNewDto, VehicleRegistration.class);
			System.out.println(veh.getRegistrationNo());
//			User user = userdao.findById(userId).orElseThrow(()->new NoSuchElementException("user cant fetch"));
			
			
			//System.out.println(veh.getRegistrationNo().toString().equals(vehical.getRegistrationNo().toString()));
			
			
			veh=dao.findByRegistrationNo(veh.getRegistrationNo());
//			veh.setUser(user);
			String newRegNo=this.generateRegistrationNumber();
			System.out.println(newRegNo);
			veh.setNewRegistrationNo(newRegNo);
			
			
//			return "Your vehical registeration number renewed successfully";
			return  mapper.map(dao.save(veh), VehRegRenewDTO.class);
		}


	    
	}


	



