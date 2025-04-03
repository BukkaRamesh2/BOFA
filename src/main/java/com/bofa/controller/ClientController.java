package com.bofa.controller;

import com.bofa.model.Client;
import com.bofa.service.ClientService;
import com.bofa.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientServiceImpl;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clientServiceImpl.addClient(client).join();
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return clientServiceImpl.getAllClients().join();
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable Long clientId) {
        return clientServiceImpl.getClient(clientId).join();
    }

    @PutMapping("/update/{clientId}")
    public Client updateClient(@PathVariable Long clientId,  @RequestBody Client client) {
        if (!client.getClientId().equals(clientId)) {
            throw new RuntimeException("Client ID does not match");
        }
        return clientServiceImpl.updateClient(client).join();
    }

    @DeleteMapping("/delete/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientServiceImpl.deleteClient(clientId).join();
    }


}
