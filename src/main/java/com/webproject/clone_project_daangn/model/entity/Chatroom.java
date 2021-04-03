package com.webproject.clone_project_daangn.model.entity;

import javax.persistence.*;

@Entity

public class Chatroom {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "SELLER")
    private String seller;

    @Column(name = "BUYER")
    private String buyer;

}
