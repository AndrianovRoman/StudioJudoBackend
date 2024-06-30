package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Client;
import com.example.studioJudo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAllClient() {
        return clientService.findAllClient();
    }

    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/clients/{id}")
    public Optional<Client> findClientById(@PathVariable("id") Integer id) {
        return clientService.findById(id);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable("id") Integer id, @RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable("id") Integer id){
        clientService.deleteClient(id);
    }

}
