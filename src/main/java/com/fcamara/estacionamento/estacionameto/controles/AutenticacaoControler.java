package com.fcamara.estacionamento.estacionameto.controles;

import com.fcamara.estacionamento.estacionameto.configuracao.securanca.TokenService;
import com.fcamara.estacionamento.estacionameto.controles.dtos.TokenDTO;
import com.fcamara.estacionamento.estacionameto.controles.forms.LoginForm;
import com.fcamara.estacionamento.estacionameto.modelos.Usuario;
import com.fcamara.estacionamento.estacionameto.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AutenticacaoControler {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity<TokenDTO> cadastraEntradaEstacionameto(@RequestBody @Valid LoginForm form) {

        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSenha(form.getEmail(), form.getSenha());

        if (usuario.isPresent()) {

            try {

                UsernamePasswordAuthenticationToken dadosLogin = form.converter();
                Authentication authentication = authManager.authenticate(dadosLogin);

                String token = tokenService.gerarToken(authentication);
                return ResponseEntity.ok(new TokenDTO(token, "Bearer"));

            } catch (AuthenticationException e) {
                System.out.println("######################################");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
        }

        return ResponseEntity.badRequest().build();
    }


}
