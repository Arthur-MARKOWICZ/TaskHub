package com.TaskHub.TaskHub.model.service;

import com.TaskHub.TaskHub.model.dto.tag.request.TagCadastroRequest;
import com.TaskHub.TaskHub.model.dto.tag.response.TagCadastroResponse;
import com.TaskHub.TaskHub.model.entity.Tag;
import com.TaskHub.TaskHub.model.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository repository;
    private final TokenService tokenService;
    public TagService(TagRepository repository, TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }
    public TagCadastroResponse cadastro(TagCadastroRequest request){
        Tag tag = new Tag();
        tag.setNome(request.nome());
        repository.save(tag);
        return new TagCadastroResponse(tag.getNome());
     }

}
