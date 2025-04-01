package com.bofa.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.bofa.model.Branch;
import com.bofa.model.Client;
import com.bofa.repository.BranchRepository;

public class BranchServiceImpl implements BranchService {
	private BranchRepository branchRepository;
	
	public BranchServiceImpl(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}

}

	@Override
	public Branch addBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	@Override
	public Branch getBranch(Long branchId) {
		
		return branchRepository.findById(branchId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Branch not found"));;
	}

	@Override
	public List<Branch> getAllBranches() {
		List<Branch> branches = branchRepository.findAll();
		if (branches.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Branches found"))
		}
		branches.forEach(branch -> {
			System.out.println(branch.getBranchName());
		});
		
		return branches;
	}

	@Override
	public void deleteClient(Long branchId) {
		if (branchRepositoy.findById())
		
	}

	@Override
	public Branch updateClient(Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}
