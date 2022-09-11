package com.example.banco_mj.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;

    @ManyToOne
    private Agencia agencia;

    public BigDecimal saldo;

    @OneToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "conta_destino")
    private List<Transacao> transacoes;

    @OneToMany(mappedBy = "conta_origem")
    private List<Transacao> transacoes_origem;

    private String tipo;


    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

}
