package com.project.base.app.test.dto;

import com.project.base.utils.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO implements BaseDTO {
    private Long id;
    private String name;
}
