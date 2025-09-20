package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.model.dto.projeto.request.ProjetoCadastroRequest;
import com.TaskHub.TaskHub.model.dto.projeto.response.ProjetoCadastroResponse;
import com.TaskHub.TaskHub.model.entity.Projeto;
import com.TaskHub.TaskHub.model.entity.Usuario;
import com.TaskHub.TaskHub.model.repository.ProjetoRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    private final ProjetoRepository repository;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;
    public ProjetoService(ProjetoRepository repository, TokenService tokenService, UsuarioService usuarioService) {
        this.repository = repository;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }
    public ProjetoCadastroResponse cadastro(ProjetoCadastroRequest request){
        String email = tokenService.getSubject(request.token());
        Usuario usuario = usuarioService.obterUsuarioPorEmail(email);
        Projeto projeto = new Projeto();
        projeto.setDescricao(request.descricao());
        projeto.setNome(request.nome());
        projeto.setUsuario(usuario);
        repository.save(projeto);
        return new ProjetoCadastroResponse(projeto);
    }

}
