package com.example.banco_mj.repository;

import com.example.banco_mj.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @PersistenceContext
    public List<Transacao> findAll();
}
