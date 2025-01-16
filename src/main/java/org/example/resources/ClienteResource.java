package org.example.resources;
import org.example.entities.Cliente;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")

public class ClienteResource {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public List<Cliente> findAll(){return clienteService.findAll();}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findByID(@PathVariable Long id){
        return clienteService.findID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){return clienteService.insert(cliente);}

    @PutMapping ("/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.findID(id)
                .map(existingCliente ->{
                    cliente.setIdCliente((existingCliente.getIdCliente()));
                    return ResponseEntity.ok(clienteService.insert(cliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable Long id){
        return clienteService.findID(id)
                .map(existingCliente -> {
                    clienteService.deleteID(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
