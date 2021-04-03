package com.webproject.clone_project_daangn.model.entity;

import com.webproject.clone_project_daangn.model.Timestamped;
import com.webproject.clone_project_daangn.model.dto.ChatContentsRequestDto;
import com.webproject.clone_project_daangn.service.ChatroomService;

import javax.persistence.*;

public class ChatContents extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CHATROOM_ID")
    private Chatroom chatroom;

    @Column(name = "WRITER")
    private String writer;

    @Column(name = "CONTENTS")
    private String contents;

    public ChatContents (ChatContentsRequestDto requestDto, ChatroomService chatroomService) {
        this.chatroom = chatroomService.findbyId(requestDto.getChatroomId());
        this.writer = requestDto.getWriter();
        this.contents = requestDto.getContents();
    }

}
