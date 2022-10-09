package com.example.banco_mj.controller;

import com.example.banco_mj.model.Cliente;
import com.example.banco_mj.model.User;
import com.example.banco_mj.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private ClienteRepository clienteRepository;

    private void buscarUserLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){

        }
    }

    @GetMapping("/user/home")
    public String userHome(Model model, Principal usuario){
        Optional<Cliente> cliente = clienteRepository.findByCpf(usuario.getName());
        if (cliente.isEmpty()){
            throw new IllegalArgumentException("Usuário Inválido");
        }
        System.out.println(cliente.get().getNome());
        model.addAttribute("cliente", cliente.get());
        return "user/home";
    }
}
