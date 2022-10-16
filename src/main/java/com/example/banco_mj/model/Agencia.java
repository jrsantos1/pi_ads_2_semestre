package com.example.banco_mj.model;

import javax.persistence.*;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;
    @OneToOne
    private EnderecoAgencia enderecoAgencia;
    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public EnderecoAgencia getEnderecoAgencia() {
        return enderecoAgencia;
    }
    public void setEnderecoAgencia(EnderecoAgencia enderecoAgencia) {
        this.enderecoAgencia = enderecoAgencia;
    }
}
