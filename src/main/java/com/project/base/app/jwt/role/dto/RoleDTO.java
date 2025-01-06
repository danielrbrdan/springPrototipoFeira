package com.project.base.app.jwt.role.dto;

import com.project.base.utils.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements BaseDTO {
    private Long id;
    private String name;
    private String description;
}
