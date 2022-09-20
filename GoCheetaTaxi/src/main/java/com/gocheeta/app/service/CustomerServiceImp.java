package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.Customer;
import com.gocheeta.app.repository.CustomerRepository;
import com.gocheeta.app.repository.UserDetailRepository;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	
}
