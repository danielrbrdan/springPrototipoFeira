package com.project.base.app.venda.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.base.app.loja.entity.Loja;
import com.project.base.app.produto.entity.Produto;
import com.project.base.utils.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Venda extends BaseEntity {
    @NotNull
    private Long quantidadeVendida;

    @ManyToOne
    @JoinColumn(name = "loja_id")
    @NotNull
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @NotNull
    private Produto produto;
}
