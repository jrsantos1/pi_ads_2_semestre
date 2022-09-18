package com.example.banco_mj.controller;

import com.example.banco_mj.dto.RequisicaoNovoCliente;
import com.example.banco_mj.model.Cliente;
import com.example.banco_mj.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conta")
public class AbrirContaController {

    @Autowired
    ClienteRepository clienteRepository;


    @GetMapping("/formulario_nova_conta")
    public String home(RequisicaoNovoCliente requisicao){
        return "conta/formulario_nova_conta";
    }

    @PostMapping("/novo")
    public String novo(RequisicaoNovoCliente requisicao){

        Cliente cliente = requisicao.toCliente();

        clienteRepository.save(cliente);

        return "conta/formulario_nova_conta";
    }

}
