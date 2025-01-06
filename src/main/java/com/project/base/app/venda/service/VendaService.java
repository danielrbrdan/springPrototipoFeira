package com.project.base.app.venda.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.base.app.loja.entity.Loja;
import com.project.base.app.loja.lojaProduto.service.LojaProdutoService;
import com.project.base.app.loja.service.LojaService;
import com.project.base.app.produto.dto.ProdutoDTO;
import com.project.base.app.produto.entity.Produto;
import com.project.base.app.produto.service.ProdutoService;
import com.project.base.app.venda.dto.VendaDTO;
import com.project.base.app.venda.entity.Venda;
import com.project.base.app.venda.repository.VendaRepository;
import com.project.base.utils.service.BaseService;

import jakarta.transaction.Transactional;
import lombok.Builder;

@Service
public class VendaService extends BaseService<Venda, VendaDTO> {
    private LojaProdutoService lojaProdutoService;
    private LojaService lojaService;
    private ProdutoService produtoService;

    @Builder
    public VendaService(VendaRepository vendaRepository, LojaProdutoService lojaProdutoService, LojaService lojaService,
            ProdutoService produtoService) {
        super(vendaRepository);
        this.lojaProdutoService = lojaProdutoService;
        this.lojaService = lojaService;
        this.produtoService = produtoService;
    }

    @Transactional
    @Override
    public Venda save(VendaDTO vendaDto) {
        var lojaProduto = this.lojaProdutoService.findByLojaIdAndProdutoId(vendaDto.getLoja().getId(),
                vendaDto.getProduto().getId());

        if (lojaProduto == null || lojaProduto.getQuantidade() < vendaDto.getQuantidadeVendida()) {
            // throw new BadRequestException("Não há produtos suficientes no estoque da
            // Loja");
            return new Venda();
        }

        lojaProduto.setQuantidade(lojaProduto.getQuantidade() - vendaDto.getQuantidadeVendida());

        Optional<Loja> loja = this.lojaService.findById(vendaDto.getLoja().getId());
        Optional<Produto> produto = this.produtoService.findById(vendaDto.getProduto().getId());

        if (!produto.isPresent() || !loja.isPresent()) {
            // throw new BadRequestException("Produto não encontrado");
            return new Venda();
        }

        this.lojaProdutoService.save(lojaProduto);

        Venda newVenda = new Venda(vendaDto.getQuantidadeVendida(), loja.get(), produto.get());

        return super.save(newVenda);
    }

    @Override
    public Venda mapToEntity(VendaDTO dto) {
        return modelMapper.map(dto, Venda.class);
    }

    @Override
    public VendaDTO mapToDto(Venda entity) {
        return modelMapper.map(entity, VendaDTO.class);
    }
}
