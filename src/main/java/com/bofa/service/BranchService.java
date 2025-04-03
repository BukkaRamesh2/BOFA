package com.bofa.service;
import com.bofa.model.Branch;

import java.util.List;

public interface BranchService {
	
    public Branch addBranch(Branch branch);
    
    public Branch getBranch(Long branchId);
    
    public List<Branch> getAllBranches();
    
    public void deleteBranch(Long branchId);
    
    public Branch updateBranch(Branch branch);
}
