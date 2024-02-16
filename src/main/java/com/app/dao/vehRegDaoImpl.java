package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entities.VehicleRegistration;


@Repository
public abstract class vehRegDaoImpl implements VehRegDAO{
	
	@Autowired
	public VehicleRegistration vehicalReg;

}
