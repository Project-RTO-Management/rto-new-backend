package com.app.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressDao;
import com.app.dao.UserDao;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.User;
@Service
@Transactional

public class AddressServiceImpl implements AddressService{
	@Autowired
	private UserDao dao;
	@Autowired
	private AddressDao adrDao;
@Autowired
private ModelMapper mapper;


@Override
public String addPermAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr) {
	User user = dao.findById(userId).orElseThrow(() -> new NoSuchElementException("User can not be null"));
	Address address = mapper.map(adr, Address.class);
	address.setUser(user);
	user.setPermanentAddress(address);
	
	adrDao.save(address);
	return "Permanent Address added";
}

@Override
public String addCorrespondeAddress(@NotNull(message = "UserId can not be null") Long userId, AddressDTO adr) {
	User user = dao.findById(userId).orElseThrow(() -> new NoSuchElementException("User can not be null"));
	Address address = mapper.map(adr, Address.class);
	address.setUser(user);
	user.setCorrespondAdd(address);
	
	adrDao.save(address);
	return "Corresponding Address added";
}


//	@Override
//	public ApiResponse assignUserAddress(@NotNull(message = "Emp id is required !!!") Integer userId, AddressDTO adr) {
//		// get the proxy of emp 
//				User user=dao.getReferenceById(userId);
//				//adr dto --> adr entity
//				Address addressEntity = mapper.map(adr, Address.class);
//				//set up uni dir asso adr --> emp
//				addressEntity.setEmp(user);//assigning a placeholder : proxy
//				adrDao.save(addressEntity);
//				return new  ApiResponse("address assigned to emp....");
//	}

}
