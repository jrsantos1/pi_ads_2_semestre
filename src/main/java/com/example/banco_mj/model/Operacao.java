package com.example.banco_mj.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private byte ativo;

    @Column(nullable = false)
    @OneToMany(mappedBy = "operacao")
    private List<Transacao> transacoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getAtivo() {
        return ativo;
    }

    public void setAtivo(byte ativo) {
        this.ativo = ativo;
    }
}
