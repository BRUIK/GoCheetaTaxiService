package com.gocheeta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gocheeta.app.model.VehicleType;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleType, Integer> {

}
