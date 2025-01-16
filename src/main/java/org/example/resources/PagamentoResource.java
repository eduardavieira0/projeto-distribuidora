package org.example.resources;

import org.example.entities.Fornecedor;
import org.example.entities.Pagamento;
import org.example.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")

public class PagamentoResource {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> findAll(){return pagamentoService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findByID(@PathVariable Long id){
        return pagamentoService.findID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Pagamento create(@RequestBody Pagamento pagamento){
        return pagamentoService.insert(pagamento);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento){
        return pagamentoService.findID(id)
                .map(existingPagamento -> {
                    pagamento.setIdPagamento((existingPagamento.getIdPagamento()));
                    return ResponseEntity.ok(pagamentoService.insert(pagamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return pagamentoService.findID(id)
                .map(existingPagamento -> {
                    pagamentoService.deleteID(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

