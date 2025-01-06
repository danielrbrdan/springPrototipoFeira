package com.project.base.app.jwt.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.base.app.jwt.role.repository.RoleRepository;
import com.project.base.app.user.dto.CreateUserDTO;
import com.project.base.app.user.entity.User;
import com.project.base.app.user.repository.UserRepository;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            RoleRepository roleRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setEmail(createUserDTO.getEmail());
        user.setFullName(createUserDTO.getFullName());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setRoles(new HashSet<>(List.of(roleRepository.findByName("USER"))));

        return userRepository.save(user);
    }

    public Authentication authenticate(User user) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()));
    }
}
