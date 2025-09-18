package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.model.dto.usuario.request.UsuarioCadastroRequest;
import com.TaskHub.TaskHub.model.dto.usuario.response.UsuarioCadastroResponse;
import com.TaskHub.TaskHub.model.entity.Usuario;
import com.TaskHub.TaskHub.model.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
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
}
