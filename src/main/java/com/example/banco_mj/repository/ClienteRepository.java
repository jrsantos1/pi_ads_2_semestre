package com.example.banco_mj.repository;

import com.example.banco_mj.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @PersistenceContext
    public List<Cliente> findAll();

}
