package com.gocheeta.app.service;

import java.util.List;

import com.gocheeta.app.model.Branch;

public interface BranchService {
	List<Branch> getAllBranches();
	Branch findBranch(int id);
}
