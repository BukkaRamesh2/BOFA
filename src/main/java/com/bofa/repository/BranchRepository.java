package com.bofa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bofa.model.Branch;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long>{
}
