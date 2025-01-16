package org.example.entities;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR", nullable = false)
    private Fornecedor fornecedor;


    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

    public Produto() {
    }
    public Produto(Long idProduto, Fornecedor fornecedor, String nome, Double preco) {
        this.idProduto = idProduto;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getFornecedor() {return fornecedor;}

    public void setFornecedor(Fornecedor fornecedor) {this.fornecedor = fornecedor;}

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