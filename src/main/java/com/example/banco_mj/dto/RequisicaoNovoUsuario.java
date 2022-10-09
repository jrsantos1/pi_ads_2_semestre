package com.example.banco_mj.dto;

import com.example.banco_mj.model.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequisicaoNovoUsuario {
    private String cpf;
    private String password;
    private Boolean enable;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public User toUsuario() {
        User user = new User();
        user.setCpf(this.cpf);
        //Criptografar Senha
        String geradoSenha = BCrypt.gensalt();
        String senhaCrypt = BCrypt.hashpw(this.password, geradoSenha);

        user.setPassword(senhaCrypt);
        user.setEnabled(true);

        return user;
    }
}
