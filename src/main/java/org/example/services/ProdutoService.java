package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> findAll(){

        return produtoRepository.findAll();
    }

    public Optional<Produto> findID(Long id){

        return produtoRepository.findById(id);
    }

    public Produto insert(Produto produto){

        return produtoRepository.save(produto);
    }

    public void deleteID(Long id){

        produtoRepository.deleteById(id);
    }
}
