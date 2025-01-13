package org.example.resources;

import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")

public class FornecedorResource {
    @Autowired
    private FornecedorService fornecedorService;
    @GetMapping
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findByID(@PathVariable Long id){
        return fornecedorService.findID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor){
        return fornecedorService.insert(fornecedor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor){
        return fornecedorService.findID(id)
                .map(existingFornecedor -> {
                    fornecedor.setIdFornecedor((existingFornecedor.getIdFornecedor()));
                    return ResponseEntity.ok(fornecedorService.insert(fornecedor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return fornecedorService.findID(id)
                .map(existingFornecedor -> {
                    fornecedorService.deleteID(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
