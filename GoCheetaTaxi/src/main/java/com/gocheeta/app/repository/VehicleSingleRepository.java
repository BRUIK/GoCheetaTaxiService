package com.gocheeta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gocheeta.app.model.Vehicle;

@Repository
public interface VehicleSingleRepository extends JpaRepository<Vehicle,Integer>{

}
