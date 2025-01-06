package com.project.base.utils.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.base.utils.dto.BaseDTO;
import com.project.base.utils.entity.BaseEntity;
import com.project.base.utils.service.BaseService;

public abstract class BaseController<T extends BaseEntity, TDTO extends BaseDTO> {
    private BaseService<T, TDTO> service;

    public BaseController(BaseService<T, TDTO> service) {
        this.service = service;
    }

    @GetMapping()
    public List<T> findAll() {
        var result = service.findAll();
        return result;
    }

    // @GetMapping("/{id}")
    // public TDTO findById(@PathVariable Long id) {
    //     return this.service.mapToDto(service.findById(id).get());
    // }

    @GetMapping("/{id}")
    public Optional<T> findById(@PathVariable Long id) {
        var result = service.findById(id);;
        return result;
    }

    @PostMapping()
    public T save(@RequestBody TDTO t) {
        return service.save(t);
    }

    @PatchMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody TDTO t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
