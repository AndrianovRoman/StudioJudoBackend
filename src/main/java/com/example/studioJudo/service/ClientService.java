package com.example.studioJudo.service;

import com.example.studioJudo.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAllClient();
    Optional<Client> findById(Integer id);
    Client saveClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Integer id);
}
