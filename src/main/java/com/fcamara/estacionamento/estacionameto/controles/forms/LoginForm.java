package com.fcamara.estacionamento.estacionameto.controles.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginForm {

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    public LoginForm(@NotNull @NotEmpty String email, @NotNull @NotEmpty String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
