package com.project.base.app.test.service;

import org.springframework.stereotype.Service;

import com.project.base.app.test.dto.TestDTO;
import com.project.base.app.test.entity.Test;
import com.project.base.app.test.repository.TestRepository;
import com.project.base.utils.service.BaseService;

import lombok.Builder;

@Service
public class TestService extends BaseService<Test, TestDTO> {
    @Builder
    public TestService(TestRepository testRepository) {
        super(testRepository);
    }

    @Override
    public Test mapToEntity(TestDTO dto) {
        return modelMapper.map(dto, Test.class);
    }

    @Override
    public TestDTO mapToDto(Test entity) {
        return modelMapper.map(entity, TestDTO.class);
    }
}
