package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.UserDetails;

public interface UserDetailsService {
	List<UserDetails> getAllUserDetails();
	void saveUserDetails (UserDetails userDetails);
}
