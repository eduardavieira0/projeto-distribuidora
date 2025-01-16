package org.example.services;
import org.example.entities.Cliente;
import org.example.repositories.ClienteRepository;
import org.example.resources.ClienteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> findAll(){return clienteRepository.findAll();}

    public Optional<Cliente> findID(Long id){return clienteRepository.findById(id);}

    public Cliente insert(Cliente cliente){return clienteRepository.save(cliente);}

    public void deleteID(Long id){clienteRepository.deleteById(id);}

}
