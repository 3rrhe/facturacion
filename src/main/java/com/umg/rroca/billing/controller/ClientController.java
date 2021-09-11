package com.umg.rroca.billing.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import javax.validation.Valid;

import com.umg.rroca.billing.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.umg.rroca.billing.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.umg.rroca.billing.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Get all clients list.
     *
     * @return the list
     */
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Gets clients by id.
     *
     * @param clientId the user id
     * @return the clients by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientsById(@PathVariable(value = "id") Long clientId)
            throws ResourceNotFoundException {
        Client client =
                clientRepository
                        .findById(clientId)
                        .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientId));
        return ResponseEntity.ok().body(client);
    }

    /**
     * Create new client.
     *
     * @param client the client
     * @return the client
     */
    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    /**
     * Update client response entity.
     *
     * @param clientId      the client id
     * @param clientDetails the client details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable(value = "id") Long clientId, @Valid @RequestBody Client clientDetails)
            throws ResourceNotFoundException {

        Client client =
                clientRepository
                        .findById(clientId)
                        .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientId));

        client.setEmail(clientDetails.getEmail());
        client.setLastName(clientDetails.getLastName());
        client.setFirstName(clientDetails.getFirstName());
        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    /**
     * Delete client map.
     *
     * @param clientId the client id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId) throws Exception {
        Client client =
                clientRepository
                        .findById(clientId)
                        .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientId));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}