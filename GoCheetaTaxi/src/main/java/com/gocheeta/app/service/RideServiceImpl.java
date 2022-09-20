package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.Ride;
import com.gocheeta.app.repository.RideRepository;
import com.gocheeta.app.repository.VehicleRepository;

@Service
public class RideServiceImpl implements RideService{

	@Autowired
	private RideRepository  rideRepository;
	
	@Override
	public List<Ride> getAllRides() {
		// TODO Auto-generated method stub
		return rideRepository.findAll();
	}

	@Override
	public void saveRide(Ride ride) {
		
		this.rideRepository.save(ride);
		
	}

}
