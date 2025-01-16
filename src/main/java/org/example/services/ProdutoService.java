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

    public List<Produto> findAll(){return produtoRepository.findAll();}

    public Optional<Produto> findID(Long id){return produtoRepository.findById(id);
    }

    public Produto insert(Produto produto){return produtoRepository.save(produto);
    }

    public Produto update(Long id, Produto produtoUpdate){
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoUpdate.getNome());
            produto.setPreco(produtoUpdate.getPreco());
            produto.setFornecedor(produtoUpdate.getFornecedor());
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public void deleteID(Long id){produtoRepository.deleteById(id);
    }
}
