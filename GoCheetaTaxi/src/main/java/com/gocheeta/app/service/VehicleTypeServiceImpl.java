package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.VehicleType;
import com.gocheeta.app.repository.VehicleRepository;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public List<VehicleType> getAllVehicleTypes() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public VehicleType findType(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(VehicleType type) {
		this.vehicleRepository.save(type);
	}

}
