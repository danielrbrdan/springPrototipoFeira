package com.project.base.app.loja.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.app.loja.dto.LojaDTO;
import com.project.base.app.loja.entity.Loja;
import com.project.base.app.loja.service.LojaService;
import com.project.base.utils.controller.BaseController;

@RestController
@RequestMapping("/loja")
public class LojaController extends BaseController<Loja, LojaDTO> {
    LojaController(LojaService lojaService) {
        super(lojaService);
    }
}
