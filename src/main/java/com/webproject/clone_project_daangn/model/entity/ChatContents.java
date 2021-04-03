package com.webproject.clone_project_daangn.model.entity;

import com.webproject.clone_project_daangn.model.Timestamped;

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

}
