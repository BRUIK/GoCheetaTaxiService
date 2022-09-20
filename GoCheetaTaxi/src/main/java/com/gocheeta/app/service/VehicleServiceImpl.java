package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.Vehicle;
import com.gocheeta.app.repository.VehicleSingleRepository;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleSingleRepository repository;
	
	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		this.repository.save(vehicle);
	}

}
