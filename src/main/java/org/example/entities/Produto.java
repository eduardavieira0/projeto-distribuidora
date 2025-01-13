package org.example.entities;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORNECEDOR")
    private Long idProduto;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    public Produto() {
    }
    public Produto(Long idProduto, String nome, Double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}