package com.project.base.app.venda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.app.venda.dto.VendaDTO;
import com.project.base.app.venda.entity.Venda;
import com.project.base.app.venda.service.VendaService;
import com.project.base.utils.controller.BaseController;

@RestController
@RequestMapping("/venda")
public class VendaController extends BaseController<Venda, VendaDTO> {
    VendaController(VendaService vendaService) {
        super(vendaService);
    }
}
