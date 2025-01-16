package org.example.resources;

import org.example.entities.Fornecedor;
import org.example.entities.Produto;
import org.example.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")

public class ProdutoResource {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public List<Produto> findAll(){
        return produtoService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findByID(@PathVariable Long id){
        return produtoService.findID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   @PostMapping
   public Produto create(@RequestBody Produto produto){return produtoService.insert(produto);}


    @PutMapping("/{id}")
    public  ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        return  produtoService.findID(id)
                .map(existingProduto -> {
                    produto.setIdProduto(existingProduto.getIdProduto());
                    return ResponseEntity.ok(produtoService.insert(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return produtoService.findID(id)
                .map(existingProduto -> {
                    produtoService.deleteID(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
