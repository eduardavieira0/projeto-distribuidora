package org.example.services;

import org.example.entities.Pagamento;
import org.example.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    public PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll(){return pagamentoRepository.findAll();}

    public Optional<Pagamento> findID(Long id){return pagamentoRepository.findById(id);}

    public Pagamento insert(Pagamento pagamento){return pagamentoRepository.save(pagamento);}

    public void deleteID(Long id){pagamentoRepository.deleteById(id);}
}
