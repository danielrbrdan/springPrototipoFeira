package com.project.base.app.venda.dto;

import com.project.base.app.loja.dto.LojaDTO;
import com.project.base.app.produto.dto.ProdutoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.project.base.utils.dto.BaseDTO;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDTO implements BaseDTO {
    private Long id;
    private Long quantidadeVendida;
    private LojaDTO loja;
    private ProdutoDTO produto;
}