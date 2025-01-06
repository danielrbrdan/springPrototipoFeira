package com.project.base.app.jwt.role.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.project.base.utils.entity.BaseEntity;

import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseEntity {
    @Column
    private String name;

    @Column
    private String description;
}