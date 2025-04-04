package com.bofa.service;

import com.bofa.model.Service;

import java.util.List;


public interface ExecService {
	
    public Service getService(Long serviceId);

    public List<Service> getAllServices();

    public void deleteService(Long serviceId);

    public Service updateService(Service service);

    public Service saveService(Service service);


}

/*
package com.bofa.service;

import com.bofa.model.Client;

import java.util.List;

public interface ClientService {
	
    public Client addClient(Client client);
    public Client getClient(Long clientId);
    public List<Client> getAllClients();
    public void deleteClient(Long clientId);
    public Client updateClient(Client client);
}

*/