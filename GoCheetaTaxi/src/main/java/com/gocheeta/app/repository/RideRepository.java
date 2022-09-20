package com.gocheeta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gocheeta.app.model.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer>{

}
