package com.gocheeta.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gocheeta.app.model.Branch;
import com.gocheeta.app.repository.BranchRepository;

@Service
public class BranchServiceImp implements BranchService{

	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public List<Branch> getAllBranches() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}

	@Override
	public Branch findBranch(int id) {
		// TODO Auto-generated method stub
		return branchRepository.getById(id);
	}

}
