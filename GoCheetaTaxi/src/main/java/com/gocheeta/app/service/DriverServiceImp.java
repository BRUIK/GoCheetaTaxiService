package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.Driver;
import com.gocheeta.app.repository.DriverRepository;

@Service
public class DriverServiceImp implements DriverService{

	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		return driverRepository.findAll();
	}

	@Override
	public void saveDriver(Driver driver) {
		this.driverRepository.save(driver);
		
	}

}
