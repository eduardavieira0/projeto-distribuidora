package org.example.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "NOME_USER")
    private String nomeUser;

    @Column(name = "EMAIL_USER")
    private String emailUser;

    public User() {
    }

    public User(Long idUser, String nomeUser,
                String emailUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.emailUser = emailUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}
