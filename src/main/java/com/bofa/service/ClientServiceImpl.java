package com.bofa.service;

import com.bofa.exception.ClientAlreadyExistsException;
import com.bofa.exception.ClientNotFoundException;
import com.bofa.exception.InvalidClientDataException;
import com.bofa.model.Client;
import com.bofa.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
//    private List<Client> clientCache = new ArrayList<>();
    private Map<Long, Client> clientCacheMap = new HashMap<>();
//    private Set<Long> clientCacheSet = new HashSet<>();
    private final Lock clientLock = new ReentrantLock();  // Lock for thread safety


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Async
    @Override
    public CompletableFuture<Client> addClient(Client client) {
//        Create a lock
        clientLock.lock();
        try {
            if (clientCacheMap.containsKey(client.getClientId())) {
                throw new ClientAlreadyExistsException("Client ID already exists");
            }
            Client savedClient = clientRepository.save(client);
            clientCacheMap.put(savedClient.getClientId(), savedClient);
            return CompletableFuture.completedFuture(savedClient);
        } finally {
//            close the lock
            clientLock.unlock();
        }
    }

    @Async
    @Override
    public CompletableFuture<Client> getClient(Long clientId) {

        return CompletableFuture.completedFuture(
                clientCacheMap.getOrDefault(clientId,
                        clientRepository.findById(clientId)
                                .orElseThrow(() -> new ClientNotFoundException("Client not found"))));
    }

    @Async
    @Override
    public CompletableFuture<List<Client>> getAllClients() {
        if (clientCacheMap.isEmpty()) {
            List<Client> clients = clientRepository.findAll();
            for (Client client : clients) {
                clientCacheMap.put(client.getClientId(), client);
            }
        }
        return CompletableFuture.completedFuture(new ArrayList<>(clientCacheMap.values()));
    }


    @Async
    @Override
    public CompletableFuture<Void> deleteClient(Long clientId) {
        clientLock.lock();  // Lock before modifying shared resources
        try {
            if (!clientCacheMap.containsKey(clientId)) {
                throw new ClientNotFoundException("Client with ID " + clientId + " does not exist");
            }

            clientRepository.deleteById(clientId);
            // Ensure the client is fully removed from cache
            while (clientCacheMap.containsKey(clientId)) {
                clientCacheMap.remove(clientId);
            }
//            clientCacheMap.remove(clientId);
            System.out.println("Client with ID " + clientId + " deleted successfully");
            return CompletableFuture.completedFuture(null);
        } finally {
            System.out.println("Client Cache after deletion: " + clientCacheMap);
            clientLock.unlock();  // Release lock
        }
    }

    @Async
    @Override
    public CompletableFuture<Client> updateClient(Client client) {
        clientLock.lock();
        try {
            if (client.getClientName() == null || client.getClientName().isEmpty()) {
                throw new InvalidClientDataException("Client name cannot be null or empty");
            }
            if (!clientCacheMap.containsKey(client.getClientId())) {
                throw new ClientNotFoundException("Client not found");
            }
            switch (client.getClientName()){
                case "John", "Jane" -> {
                    System.out.println("Client name already exists");
                    throw new ClientAlreadyExistsException("Client name already exists");
                }
                default ->
                    System.out.println("Client updated successfully");
            }

            Client updatedClient = clientRepository.save(client);
            clientCacheMap.put(updatedClient.getClientId(), updatedClient);
            return CompletableFuture.completedFuture(updatedClient);
        } finally {
            System.out.println("Client Cache after update: " + clientCacheMap);
            clientLock.unlock();
        }
    }
}
