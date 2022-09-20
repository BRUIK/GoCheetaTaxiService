package com.gocheeta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gocheeta.app.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
}
