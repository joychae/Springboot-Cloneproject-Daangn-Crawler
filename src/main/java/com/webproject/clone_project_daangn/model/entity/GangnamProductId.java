package com.webproject.clone_project_daangn.model.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class GangnamProductId {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @NonNull
    @Column (name = "PRODUCT_ID")
    private String productId;

    public GangnamProductId (String productId) {
        this.productId = productId;
    }

}

