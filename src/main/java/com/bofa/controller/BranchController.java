package com.bofa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bofa.model.Branch;
import com.bofa.service.BranchService;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
	
    @Autowired 
    BranchService branchServiceImpl;

    @PostMapping("/add")
    public Branch addBranch(@RequestBody Branch branch) {
        return branchServiceImpl.addBranch(branch);
    }

    @GetMapping("/getAllBranches")
    public List<Branch> getAllBranches() {
        return branchServiceImpl.getAllBranches();
    }

    @GetMapping("/getBranchById/{branchId}")
    public Branch getBranch(@PathVariable Long branchId) {
        return branchServiceImpl.getBranch(branchId);
    }

    @PutMapping("/update/{branchId}")
    public Branch updateBranch(@PathVariable Long branchId,  @RequestBody Branch branch) {
        if (branch.getBranchId() != branchId) {
            throw new RuntimeException("Branch ID does not match");
        }
        return branchServiceImpl.updateBranch(branch);
    }

    @DeleteMapping("/delete/{branchId}")
    public void deleteBranch(@PathVariable Long branchId) {
        branchServiceImpl.deleteBranch(branchId);
    }


}
