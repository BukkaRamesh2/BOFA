package com.bofa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bofa.model.Branch;
import com.bofa.service.BranchServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BranchKafkaConsumer {
	
	public BranchKafkaConsumer() {
		
	}
	
	@Autowired
	private BranchServiceImpl branchservice;
	
	@Autowired
	private ObjectMapper objectmapper;
	
	@KafkaListener(topics = "branch-topic" , groupId =  "branch-group")
	public void consume(String message) {
		try {
			Branch branch = objectmapper.readValue(message, Branch.class);
			branchservice.saveBranchWithThreadSafety(branch);
		}
		catch(Exception e) {
            e.printStackTrace();
        }
	}
	
}
