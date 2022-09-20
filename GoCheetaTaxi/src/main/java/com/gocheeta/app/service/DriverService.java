package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.Driver;

public interface DriverService {
	List <Driver> getAllDrivers();
	void saveDriver(Driver driver);
}
