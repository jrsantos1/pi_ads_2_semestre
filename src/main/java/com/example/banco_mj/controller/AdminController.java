package com.example.banco_mj.controller;

import com.example.banco_mj.dto.RequisicaoAlterarCliente;
import com.example.banco_mj.model.Cliente;
import com.example.banco_mj.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("dash")
    public String dash(Model model){

        List<Cliente> listaCliente = clienteRepository.findAll();
        model.addAttribute("clientes", listaCliente);
        return "admin/dash";

    }
    @GetMapping("login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("excluir/usuario/{id}")
    public String excluirUsuario(@PathVariable("id") long id){

        Optional<Cliente> usuarioOpt = clienteRepository.findById(id);

        if (usuarioOpt.isEmpty()){
            throw new IllegalArgumentException("Usuário Inválido");
        }

        clienteRepository.deleteById(id);

        return "redirect:/admin/login";

    }

    @GetMapping("alterar/usuario/{id}")
    public String getAlterarUsuario(@PathVariable("id") long id, Model model){

        // Buscar usuário pelo id no banco de dados
        Optional<Cliente> usuarioOpt = clienteRepository.findById(id);

        // veriricar se valor retornado está vazio
        if (!usuarioOpt.isPresent()){
            System.out.println("erro");
            // Caso vazio jogar jogar um exceção
            throw new IllegalArgumentException("Usuário Inválido");
        }

        RequisicaoAlterarCliente requisicaoAlterarCliente = new RequisicaoAlterarCliente(usuarioOpt.get());

        model.addAttribute("requisicaoAlterarCliente", requisicaoAlterarCliente);

        return "admin/form_alterar_usuario";

    }

    @PostMapping("alterar/usuario")
    public String alterarUsuario(RequisicaoAlterarCliente requisicaoAlterarCliente){

        // Buscar usuário pelo id no banco de dados

        //Cliente cliente = clienteRepository.findById(requisicaoAlterarCliente.getId()).orElseThrow(() -> new InvalidParameterException("Usuário Inválido"));

        Cliente cliente = new Cliente();

        cliente.setCpf(requisicaoAlterarCliente.getCpf());
        cliente.setNome(requisicaoAlterarCliente.getNome());
        cliente.setData_nascimento(requisicaoAlterarCliente.getDataNascimento());
        cliente.setId(requisicaoAlterarCliente.getId());

        clienteRepository.save(cliente);

        return "redirect:/admin/dash";

    }


}
