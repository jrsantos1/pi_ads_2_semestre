package com.example.banco_mj.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 255, unique = true)

    @OneToMany(mappedBy = "endereco")
    private List<Cliente> cliente = new ArrayList<>();

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private long numero;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String bairro;


    // Getter And Setters

    public List<Cliente> getId_cliente() {
        return cliente;
    }

    public void setId_cliente(List<Cliente> id_cliente) {
        this.cliente = id_cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
