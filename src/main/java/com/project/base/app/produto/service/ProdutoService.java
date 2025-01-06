package com.project.base.app.produto.service;

import org.springframework.stereotype.Service;

import com.project.base.app.produto.dto.ProdutoDTO;
import com.project.base.app.produto.entity.Produto;
import com.project.base.app.produto.repository.ProdutoRepository;
import com.project.base.utils.service.BaseService;

import lombok.Builder;

@Service
public class ProdutoService extends BaseService<Produto, ProdutoDTO> {
    @Builder
    public ProdutoService(ProdutoRepository produtoRepository) {
        super(produtoRepository);
    }


    @Override
    public Produto mapToEntity(ProdutoDTO dto) {
        return modelMapper.map(dto, Produto.class);
    }

    @Override
    public ProdutoDTO mapToDto(Produto entity) {
        return modelMapper.map(entity, ProdutoDTO.class);
    }
}
