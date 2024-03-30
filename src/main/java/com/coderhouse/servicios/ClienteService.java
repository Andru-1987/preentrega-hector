package com.coderhouse.servicios;

import com.coderhouse.entidades.Cliente;
import com.coderhouse.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Method to retrieve all clients
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Method to retrieve a client by ID
    public Cliente getClienteById(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null); // Return null if not found
    }

    // Method to create or update a client
    public Cliente createOrUpdateCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Method to delete a client by ID
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
