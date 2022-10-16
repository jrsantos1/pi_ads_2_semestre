package com.example.banco_mj.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Transacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Conta conta_destino;

    @ManyToOne
    private Conta conta_origem;

    //@Column(nullable = false)
    @ManyToOne
    private Operacao operacao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date data;


    public Conta getConta_destino() {
        return conta_destino;
    }

    public void setConta_destino(Conta conta_destino) {
        this.conta_destino = conta_destino;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
