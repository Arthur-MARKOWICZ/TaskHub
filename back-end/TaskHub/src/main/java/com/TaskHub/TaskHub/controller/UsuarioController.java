package com.TaskHub.TaskHub.controller;

import com.TaskHub.TaskHub.model.dto.usuario.request.UsuarioCadastroRequest;
import com.TaskHub.TaskHub.model.dto.usuario.response.UsuarioCadastroResponse;
import com.TaskHub.TaskHub.model.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UsuarioCadastroResponse> cadastro(@RequestBody UsuarioCadastroRequest request){
        UsuarioCadastroResponse response = service.cadastro(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
