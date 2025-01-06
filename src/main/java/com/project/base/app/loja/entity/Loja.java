package com.project.base.app.loja.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.base.app.loja.lojaProduto.entity.LojaProduto;
import com.project.base.utils.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
public class Loja extends BaseEntity {
    @NotNull
    private String name;

    @OneToMany(mappedBy = "loja", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LojaProduto> produtos;
}
