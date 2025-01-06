package com.project.base.app.loja.lojaProduto.service;

import org.springframework.stereotype.Service;

import com.project.base.app.loja.lojaProduto.dto.LojaProdutoDTO;
import com.project.base.app.loja.lojaProduto.entity.LojaProduto;
import com.project.base.app.loja.lojaProduto.repository.LojaProdutoRepository;
import com.project.base.utils.service.BaseService;

import lombok.Builder;

@Service
public class LojaProdutoService extends BaseService<LojaProduto, LojaProdutoDTO> {
    private LojaProdutoRepository lojaRepository;

    @Builder
    public LojaProdutoService(LojaProdutoRepository lojaRepository) {
        super(lojaRepository);
        this.lojaRepository = lojaRepository;
    }

    public LojaProduto findByLojaIdAndProdutoId(Long lojaId, Long produtoId) {
        return this.lojaRepository.findByLojaIdAndProdutoId(lojaId, produtoId);
    }


    @Override
    public LojaProduto mapToEntity(LojaProdutoDTO dto) {
        return modelMapper.map(dto, LojaProduto.class);
    }

    @Override
    public LojaProdutoDTO mapToDto(LojaProduto entity) {
        return modelMapper.map(entity, LojaProdutoDTO.class);
    }
}
