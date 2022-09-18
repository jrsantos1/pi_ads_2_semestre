package com.example.banco_mj.dto;

import com.example.banco_mj.model.Cliente;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class RequisicaoNovoCliente {

    public String nome;
    public String cpf;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date dataNascimento;

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

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setData_nascimento(this.dataNascimento);

        return cliente;
    }

    public Cliente toClienteAdmin() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setData_nascimento(this.dataNascimento);

        return cliente;
    }
}
