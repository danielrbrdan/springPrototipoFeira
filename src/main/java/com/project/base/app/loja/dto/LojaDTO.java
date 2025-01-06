package com.project.base.app.loja.dto;

import java.util.List;

import com.project.base.app.loja.lojaProduto.dto.LojaProdutoDTO;
import com.project.base.utils.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojaDTO implements BaseDTO {
    private Long id;
    private String name;
    private List<LojaProdutoDTO> produtos;

}