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
