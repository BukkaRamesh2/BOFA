package com.bofa.service;

import com.bofa.model.Client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ClientService {

    CompletableFuture<Client> addClient(Client client);
    CompletableFuture<Client> getClient(Long clientId);
    CompletableFuture<List<Client>> getAllClients();
    CompletableFuture<Void> deleteClient(Long clientId);
    CompletableFuture<Client> updateClient(Client client);
}
