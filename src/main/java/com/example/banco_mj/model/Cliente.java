package com.example.banco_mj.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_nascimento;

    @ManyToOne
    private Endereco endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Endereco getId_endereco() {
        return endereco;
    }

    public void setId_endereco(Endereco id_endereco) {
        this.endereco = id_endereco;
    }


}
