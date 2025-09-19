package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.exception.SenhaErrada;
import com.TaskHub.TaskHub.exception.UsuarioNaoEncontrado;
import com.TaskHub.TaskHub.model.dto.usuario.request.UsuarioCadastroRequest;
import com.TaskHub.TaskHub.model.dto.usuario.request.UsuarioLoginRequest;
import com.TaskHub.TaskHub.model.dto.usuario.response.UsuarioCadastroResponse;
import com.TaskHub.TaskHub.model.dto.usuario.response.UsuarioLoginResponse;
import com.TaskHub.TaskHub.model.entity.Usuario;
import com.TaskHub.TaskHub.model.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder, TokenService tokenService) {
        this.repository = repository;
        this.encoder = encoder;
        this.tokenService = tokenService;
    }
    public UsuarioCadastroResponse cadastro(UsuarioCadastroRequest dto){
        Usuario usuario = new Usuario(dto);
        String senhaHash =  encoder.encode(dto.senha());
        usuario.setSenha(senhaHash);
        repository.save(usuario);
        UsuarioCadastroResponse response = new UsuarioCadastroResponse(usuario.getNome(),
                usuario.getEmail(), usuario.getSenha(), usuario.getId());
        return response;
    }
    public UsuarioLoginResponse login(UsuarioLoginRequest dto){
        Optional<Usuario> usuario = repository.findByEmail(dto.email());
        if(usuario.isEmpty()){
            throw  new UsuarioNaoEncontrado("email ou senha incorreto");
        }
        if(!encoder.matches(dto.senha(),usuario.get().getSenha())){
           throw  new SenhaErrada("email ou senha incorreto");
        }
        String token = tokenService.generateToken(usuario.get());
        UsuarioLoginResponse response = new UsuarioLoginResponse(token);
        return  response;
    }
}
