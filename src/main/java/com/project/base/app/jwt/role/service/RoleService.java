package com.project.base.app.jwt.role.service;

import org.springframework.stereotype.Service;

import com.project.base.app.jwt.role.dto.RoleDTO;
import com.project.base.app.jwt.role.entity.Role;
import com.project.base.app.jwt.role.repository.RoleRepository;
import com.project.base.utils.service.BaseService;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class RoleService extends BaseService<Role, RoleDTO> {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    @Transactional
    public void createDefaultRole() {
        if (!roleRepository.existsByName("USER")) {
            Role defaultRole = new Role();
            defaultRole.setName("USER");
            defaultRole.setDescription("Usuário padrão");
            roleRepository.save(defaultRole);
        }

        if (!roleRepository.existsByName("ADMIN")) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            adminRole.setDescription("Administrador");
            roleRepository.save(adminRole);
        }
    }

    @Override
    public Role mapToEntity(RoleDTO dto) {
        return modelMapper.map(dto, Role.class);
    }

    @Override
    public RoleDTO mapToDto(Role entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }
}
