package com.TaskHub.TaskHub.controller;

import com.TaskHub.TaskHub.model.dto.projeto.request.ProjetoCadastroRequest;
import com.TaskHub.TaskHub.model.dto.projeto.response.ProjetoCadastroResponse;
import com.TaskHub.TaskHub.model.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    private  final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<ProjetoCadastroResponse> cadastro(@RequestBody ProjetoCadastroRequest request){
        ProjetoCadastroResponse response = service.cadastro(request);
        return ResponseEntity.ok(response);
    }
}
