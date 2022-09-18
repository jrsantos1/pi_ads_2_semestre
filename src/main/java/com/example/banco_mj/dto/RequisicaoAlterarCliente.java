package com.example.banco_mj.dto;

import com.example.banco_mj.model.Cliente;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RequisicaoAlterarCliente {

    public String nome;
    public String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dataNascimento;

    public long id;

    public RequisicaoAlterarCliente(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getData_nascimento();
        this.id = cliente.getId();
    }

    public RequisicaoAlterarCliente(){};


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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
