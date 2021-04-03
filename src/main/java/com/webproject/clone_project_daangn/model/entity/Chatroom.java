package com.webproject.clone_project_daangn.model.entity;

import com.webproject.clone_project_daangn.model.dto.ChatContentsRequestDto;
import com.webproject.clone_project_daangn.model.dto.ChatroomRequestDto;
import com.webproject.clone_project_daangn.service.UserService;

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

    public Chatroom (ChatroomRequestDto requestDto, UserService userService) {
        this.user = userService.findbyId(requestDto.getUserId());
        this.seller = user.getUsername();
        this.buyer = requestDto.getBuyer();
    }

}
