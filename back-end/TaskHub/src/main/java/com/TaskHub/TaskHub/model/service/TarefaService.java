package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.model.dto.tarefa.request.TarefaCadastroRequest;
import com.TaskHub.TaskHub.model.dto.tarefa.response.TarefaCadastroResponse;
import com.TaskHub.TaskHub.model.entity.Projeto;
import com.TaskHub.TaskHub.model.entity.Tarefa;
import com.TaskHub.TaskHub.model.entity.Usuario;
import com.TaskHub.TaskHub.model.repository.TagRepository;
import com.TaskHub.TaskHub.model.repository.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    private final UsuarioService usuarioService;
    private final ProjetoService projetoService;

    public TarefaService(TarefaRepository repository, UsuarioService usuarioService, ProjetoService projetoService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.projetoService = projetoService;
    }
    public TarefaCadastroResponse cadastro(TarefaCadastroRequest request){
        Usuario usuario  = usuarioService.obterUSuarioPorToken(request.token());
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(request.descricao());
        tarefa.setUsuario(usuario);
        tarefa.setTitulo(request.titulo());
        tarefa.setDataVencimento(request.dataVencimento());
        projetoService.AdicionarTarefa(tarefa, request.nomeProjeto());
        repository.save(tarefa);
        return new TarefaCadastroResponse(tarefa);
    }
}
