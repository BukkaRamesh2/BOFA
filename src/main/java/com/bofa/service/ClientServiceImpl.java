package com.bofa.service;

import com.bofa.model.Client;
import com.bofa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Long clientId) {
         Optional<Client> client_id = clientRepository.findById(clientId);
         if (client_id.isPresent()) {
             return client_id.get();
         }else{
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client not found");
         }
    }

    @Override
    public List<Client> getAllClients() {
//        First create a list to store all the client
        List<Client> clients = clientRepository.findAll();

        if(clients.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client not found");
        }
//        Print all of them using for each loop
        clients.forEach(client -> {
            if (client.getClientName().equals("John")){
                System.out.println("Client name John already exists in the database.");
            }else if (client.getClientName().isEmpty()){
                throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Client not found");
            }

        });
        return clients;
    }

    @Override
    public void deleteClient(Long clientId) {
//            Check if the client id exists or not
        if(clientRepository.findById(clientId).isPresent()){
            clientRepository.deleteById(clientId);
            System.out.println("Client Successfully deleted!");
        }else{
            System.out.println("Client with that ID doesn't exists");
        }
    }

    @Override
    public Client updateClient(Client client) {
//        So here, we need to update the customer then
//        save the updated details in the db
        if (client.getClientName() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client not found or Invalid Name");
        }
        switch (client.getClientName()){
            case "John":
                System.out.println("Client name John already exists in the database.");
            case "Alex":
                System.out.println("Client name Alex exists in the database");
            case "Bob":
                System.out.println("Client name Bob exists in the database");
        }
        return clientRepository.save(client);
    }
}
