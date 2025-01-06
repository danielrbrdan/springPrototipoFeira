package com.project.base.app.produto.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.app.produto.dto.ProdutoDTO;
import com.project.base.app.produto.entity.Produto;
import com.project.base.app.produto.service.ProdutoService;
import com.project.base.utils.controller.BaseController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseController<Produto, ProdutoDTO> {
    ProdutoController(ProdutoService produtoService) {
        super(produtoService);
    }
}
