package com.project.base.app.produto.dto;

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
public class ProdutoDTO  implements BaseDTO {
    private Long id;
    private String name;
    private Long quantity;
    private List<LojaProdutoDTO> lojas;
}