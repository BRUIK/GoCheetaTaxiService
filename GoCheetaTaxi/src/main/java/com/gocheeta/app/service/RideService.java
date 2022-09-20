package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.Ride;
import com.gocheeta.app.model.UserDetails;

public interface RideService {
	List<Ride> getAllRides();
	void saveRide (Ride ride);
}
