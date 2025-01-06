package com.project.base.app.loja.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.base.app.loja.dto.LojaDTO;
import com.project.base.app.loja.entity.Loja;
import com.project.base.app.loja.repository.LojaRepository;
import com.project.base.app.test.dto.TestDTO;
import com.project.base.app.test.entity.Test;
import com.project.base.utils.service.BaseService;

import lombok.Builder;

@Service
public class LojaService extends BaseService<Loja, LojaDTO> {
    @Builder
    public LojaService(LojaRepository lojaRepository) {
        super(lojaRepository);
    }

    @Override
    public Loja mapToEntity(LojaDTO dto) {
        return modelMapper.map(dto, Loja.class);
    }

    @Override
    public LojaDTO mapToDto(Loja entity) {
        return modelMapper.map(entity, LojaDTO.class);
    }
}
