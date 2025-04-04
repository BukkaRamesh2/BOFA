package com.bofa.service;

import java.util.List;

import com.bofa.model.Service;
import com.bofa.repository.ServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExecServiceImpl implements ExecService{
	
	
	private ServiceRepository servrepo; 

	@Override
	public Service getService(Long serviceId) {
		// TODO Auto-generated method stub
		servrepo.findById(serviceId)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Not Found"));
		// TODO Auto-generated method stub
		return (Service) servrepo.getById(serviceId);
	}

	@Override
	public List<Service> getAllServices() {
		// TODO Auto-generated method stub
		List<Service> servicelist = servrepo.findAll();
		
		if(servicelist.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Services are not found");
		}
		// TODO Auto-generated method stub
		
		servicelist.forEach(service ->
		{
			System.out.println("Service details are as follows" + service);
		} );
		return servicelist;
	}

	@Override
	public void deleteService(Long serviceId) {
		// TODO Auto-generated method stub
		if(servrepo.findById(serviceId).isPresent())
		{
			servrepo.deleteById(serviceId);
			System.out.println("This ServiceId got deleteed" + serviceId);
		}
		
		else
		{
			System.out.println("The serviceid is not found");
		}
			
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public Service updateService(Service service) {
		// TODO Auto-generated method stub
		System.out.println("Updating the service");

		if(service.getServiceId() == 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid first name");
		}
		
		
		return service;

	}

	@Override
	public Service saveService(Service service) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return servrepo.save(service);
	}

}
