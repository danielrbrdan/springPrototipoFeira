package com.project.base.app.loja.lojaProduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.base.app.loja.lojaProduto.entity.LojaProduto;

public interface LojaProdutoRepository extends JpaRepository<LojaProduto, Long> {
    LojaProduto findByLojaIdAndProdutoId(Long lojaId, Long produtoId);
}