package com.gocheeta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gocheeta.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
