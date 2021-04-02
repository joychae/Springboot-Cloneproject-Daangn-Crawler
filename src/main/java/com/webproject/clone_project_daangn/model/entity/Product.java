package com.webproject.clone_project_daangn.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(length = 3000000)
    private String imgs;
    @Column
    private String nickname;
    @Column
    private String region;
    @Column
    private String title;
    @Column
    private String category;
    @Column
    private String createdAt;
    @Column
    private String price;
    @Column(length = 20000)
    private String contents;
    @Column
    private String chat;
    @Column
    private String like;
    @Column
    private String view;


    public Product(String imgs ,String contents,String nickname, String region, String title, String category, String createdAt, String price, String chat, String like, String view) {
        this.imgs = imgs;
        this.contents= contents;
        this.nickname = nickname;
        this.region = region;
        this.title = title;
        this.category = category;
        this.createdAt = createdAt;
        this.price = price;
        this.chat = chat;
        this.like = like;
        this.view = view;

    }
}