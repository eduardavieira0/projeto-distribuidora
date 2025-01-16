package org.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
