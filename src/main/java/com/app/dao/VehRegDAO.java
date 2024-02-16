package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.VehicleRegistration;


public interface VehRegDAO extends  JpaRepository<VehicleRegistration, Long>{

}
