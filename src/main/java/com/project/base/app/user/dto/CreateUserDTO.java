package com.project.base.app.user.dto;

import com.project.base.utils.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class CreateUserDTO implements BaseDTO {
    private Long id;
    private String email;
    private String password;
    private String fullName;
}
