package com.webproject.clone_project_daangn.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ProductId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @NonNull
    @Column
    private String productId;

    public ProductId(String productId) {
        this.productId = productId;
    }

}

