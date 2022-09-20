package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.UserDetails;
import com.gocheeta.app.repository.UserDetailRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		return userDetailRepository.findAll();
	}

	@Override
	public void saveUserDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		this.userDetailRepository.save(userDetails);
	}


}
