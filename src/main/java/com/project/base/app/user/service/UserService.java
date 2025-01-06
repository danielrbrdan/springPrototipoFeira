package com.project.base.app.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.base.app.produto.dto.ProdutoDTO;
import com.project.base.app.produto.entity.Produto;
import com.project.base.app.user.dto.CreateUserDTO;
import com.project.base.app.user.entity.User;
import com.project.base.app.user.repository.UserRepository;
import com.project.base.app.venda.dto.VendaDTO;
import com.project.base.app.venda.entity.Venda;
import com.project.base.utils.service.BaseService;

import lombok.Builder;

@Service
public class UserService extends BaseService<User, CreateUserDTO> {
    @Builder
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User mapToEntity(CreateUserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    @Override
    public CreateUserDTO mapToDto(User entity) {
        return modelMapper.map(entity, CreateUserDTO.class);
    }
}
