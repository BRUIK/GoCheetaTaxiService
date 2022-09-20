package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void saveCustomer (Customer customer);
}
