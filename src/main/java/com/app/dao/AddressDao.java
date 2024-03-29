package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Address;

public interface AddressDao extends JpaRepository<Address, Long> {
//list all emps by specified city (eg of custom query)
//	@Query("select a.emp from Address a where a.city=:city")
//	List<User> findEmployeesByCity(String city);
//	
	//delete all addresses from specific state , rets no of rows
	long deleteByState(String state);//will cause select + n delete queries
	//OR : bulk deletion approach
	@Query("delete from Address a where a.state=:state")
	@Modifying
	long deleteAddressDetailsByState(String state);
	
	
}