package com.project.base.utils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.base.utils.dto.BaseDTO;
import com.project.base.utils.entity.BaseEntity;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public abstract class BaseService<T extends BaseEntity, TDTO extends BaseDTO> {
    protected final JpaRepository<T, Long> repository;

    @Autowired
    protected ModelMapper modelMapper;

    public BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T save(TDTO entityDto) {
        T entity = mapToEntity(entityDto);
        return repository.save(entity);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(Long id, TDTO entityDto) {
        if (entityDto == null || entityDto.getId() == null) {
            throw new IllegalArgumentException("The entity or its ID must not be null for update.");
        }

        if (!repository.existsById(entityDto.getId())) {
            throw new EntityNotFoundException("Entity with ID " + entityDto.getId() + " does not exist.");
        }

        T entity = mapToEntity(entityDto);
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public abstract T mapToEntity(TDTO tdto);

    public abstract TDTO mapToDto(T t);
}
