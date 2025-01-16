package org.example.entities;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "NOME_CLIENTE")
    private String nomeCliente;

    @Column(name = "EMAIL")
    private String emailCliente;

    @Column(name = "PHONE_CLIENTE")
    private Integer phoneCliente;


public Cliente() {
}

public Cliente(Long idCliente, String nomeCliente, String emailCliente,Integer phoneCliente) {
    this.idCliente = idCliente;
    this.nomeCliente = nomeCliente;
    this.emailCliente = emailCliente;
    this.phoneCliente = phoneCliente;
}


public Long getIdCliente() {
    return idCliente;
}

public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
}
public String getNomeCliente() {
    return nomeCliente;
}

public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
}

public String getEmailCliente() {
    return emailCliente;
}

public void setEmailCliente(String emailCliente) {
    this.emailCliente = emailCliente;
}

public Integer getPhoneCliente() {
    return phoneCliente;
}

public void setPhoneCliente(Integer phoneCliente) {
    this.phoneCliente = phoneCliente;
}
}