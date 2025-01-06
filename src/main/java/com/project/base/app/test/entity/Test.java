package com.project.base.app.test.entity;

import com.project.base.utils.entity.BaseEntity;

import jakarta.persistence.Entity;
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
public class Test extends BaseEntity {
    @NotNull
    private String name;
}
