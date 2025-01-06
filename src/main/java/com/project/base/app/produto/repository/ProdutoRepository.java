package com.project.base.app.produto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.base.app.produto.entity.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
