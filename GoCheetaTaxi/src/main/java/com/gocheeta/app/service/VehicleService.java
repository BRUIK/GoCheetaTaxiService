package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.Vehicle;

public interface VehicleService {
	List <Vehicle> getAllVehicle();
	void saveVehicle(Vehicle vehicle);
}
