package com.webproject.clone_project_daangn.model.entity;

import com.webproject.clone_project_daangn.model.dto.ProductRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table (name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(length = 3000000)
    private String productImgs;
    @Column
    private String nickname;
    @Column
    private String productRegion;
    @Column
    private String productTitle;
    @Column
    private String productCategory;
    @Column
    private String createdAt;
    @Column
    private String productPrice;
    @Column(length = 20000)
    private String productContents;
    @Column
    private String productChat;
    @Column
    private String productLike;
    @Column
    private String productView;
    @Column
    private String daangnProductId;


    public Product(String imgs ,String contents,String nickname, String region, String title, String category, String createdAt, String price, String chat, String like, String view, String daangnProductId) {
        this.productImgs = imgs;
        this.productContents = contents;
        this.nickname = nickname;
        this.productRegion = region;
        this.productTitle = title;
        this.productCategory = category;
        this.createdAt = createdAt;
        this.productPrice = price;
        this.productChat = chat;
        this.productLike = like;
        this.productView = view;
        this.daangnProductId = daangnProductId;

    }

    public Product(ProductRequestDto requestDto){
        this.productImgs = requestDto.getImg();
        this.productTitle = requestDto.getTitle();
        this.productCategory = requestDto.getCategory();
        this.productPrice = requestDto.getPrice();
        this.productContents = requestDto.getContents();
        this.createdAt =requestDto.getCreatedAt();
    }
}