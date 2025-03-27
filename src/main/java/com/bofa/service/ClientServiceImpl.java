package com.bofa.service;

import com.bofa.model.Client;
import com.bofa.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private List<Client> clientCache = new ArrayList<>();
    private Map<Long, Client> clientCacheMap = new HashMap<>();
    private Set<Long> clientCacheSet = new HashSet<>();

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        if (clientCacheSet.contains(client.getClientId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Client ID already exists");
        }

        Client savedClient = clientRepository.save(client);
        clientCache.add(savedClient);
        clientCacheMap.put(savedClient.getClientId(), savedClient);
        clientCacheSet.add(savedClient.getClientId());
        System.out.println("Client Cache " + clientCache);

        System.out.println("Client Cache Map: " + clientCacheMap + " Client Cache Set: " + clientCacheSet);

        return savedClient;
    }

    @Override
    public Client getClient(Long clientId) {
        if (clientCacheMap.containsKey(clientId)) {
            return clientCacheMap.get(clientId);
        }
        System.out.println("Client Cache Map: " + clientCacheMap);

        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @Override
    public List<Client> getAllClients() {
        if (clientCache.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No clients found");
        }
        return clientCache;
    }

    @Override
    public void deleteClient(Long clientId) {
        if (!clientCacheSet.contains(clientId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with ID " + clientId + " does not exist");
        }

        clientRepository.deleteById(clientId);
        clientCache.removeIf(client -> client.getClientId().equals(clientId));
        clientCacheMap.remove(clientId);
        clientCacheSet.remove(clientId);
        System.out.println("Client Cache Map: " + clientCacheMap + " Client Cache Set: " + clientCacheSet);
    }

    @Override
    public Client updateClient(Client client) {
        if (client.getClientName() == null || client.getClientName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client name cannot be null or empty");
        }

        if (!clientCacheSet.contains(client.getClientId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }

        Client existingClient = clientCacheMap.get(client.getClientId());
        existingClient.setClientName(client.getClientName());
        existingClient.setClientEmail(client.getClientEmail());
        existingClient.setClientPhone(client.getClientPhone());

        switch (client.getClientName()) {
            case "John":
                System.out.println("Client name John already exists in the database.");
                break;
            case "Alex":
                System.out.println("Client name Alex exists in the database.");
                break;
            case "Bob":
                System.out.println("Client name Bob exists in the database.");
                break;
            default:
                System.out.println("Client updated successfully.");
                break;
        }

        Client updatedClient = clientRepository.save(existingClient);
        clientCacheMap.put(updatedClient.getClientId(), updatedClient);
        System.out.println("Client Cache Map: " + clientCacheMap);
        return updatedClient;
    }
}
