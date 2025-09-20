package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.exception.ProjetoNaoEncontrado;
import com.TaskHub.TaskHub.model.dto.projeto.request.ProjetoCadastroRequest;
import com.TaskHub.TaskHub.model.dto.projeto.response.ProjetoCadastroResponse;
import com.TaskHub.TaskHub.model.entity.Projeto;
import com.TaskHub.TaskHub.model.entity.Tarefa;
import com.TaskHub.TaskHub.model.entity.Usuario;
import com.TaskHub.TaskHub.model.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    private final ProjetoRepository repository;
    private final UsuarioService usuarioService;
    public ProjetoService(ProjetoRepository repository, UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }
    public ProjetoCadastroResponse cadastro(ProjetoCadastroRequest request){
        Usuario usuario = usuarioService.obterUSuarioPorToken(request.token());
        Projeto projeto = new Projeto();
        projeto.setDescricao(request.descricao());
        projeto.setNome(request.nome());
        projeto.setUsuario(usuario);
        repository.save(projeto);
        return new ProjetoCadastroResponse(projeto);
    }
    public Projeto obterPorNome(String nome){
        var projetoOptional = repository.findByNome(nome);
        if(projetoOptional.isEmpty()){
            throw  new ProjetoNaoEncontrado("projeto Nao encontrado");
        }
        return projetoOptional.get();
    }
    @Transactional
    public void AdicionarTarefa(Tarefa tarefa, String nome){
        var projetoOptional = repository.findByNome(nome);
        if(projetoOptional.isEmpty()){
            throw  new ProjetoNaoEncontrado("projeto Nao encontrado");
        }
        var projeto = projetoOptional.get();
        var tarefas =  projeto.getTarefas();
        tarefas.add(tarefa);
    }

}
