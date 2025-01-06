package com.project.base.app.loja.lojaProduto.dto;

import com.project.base.app.loja.dto.LojaDTO;
import com.project.base.app.produto.dto.ProdutoDTO;
import com.project.base.utils.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojaProdutoDTO implements BaseDTO {

    private Long id;
    private LojaDTO loja;
    private ProdutoDTO produto;
    private Long quantidade;

}