package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.VehicleType;

public interface VehicleTypeService {
	List<VehicleType> getAllVehicleTypes();
	VehicleType findType(String id);
	void save(VehicleType type);
}
