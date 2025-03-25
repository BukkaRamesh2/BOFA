package com.bofa.controller;

import com.bofa.model.Client;
import com.bofa.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired ClientServiceImpl clientServiceImpl;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clientServiceImpl.addClient(client);
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return clientServiceImpl.getAllClients();
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Long clientId) {
        return clientServiceImpl.getClient(clientId);
    }

    @PutMapping("/update/{clientId}")
    public Client updateClient(@PathVariable Long clientId,  @RequestBody Client client) {
        if (client.getClientId() != clientId) {
            throw new RuntimeException("Client ID does not match");
        }
        return clientServiceImpl.updateClient(client);
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientServiceImpl.deleteClient(clientId);
    }


}
