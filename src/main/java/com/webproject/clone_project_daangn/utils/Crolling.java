package com.webproject.clone_project_daangn.utils;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@ToString
@Builder
@Getter
public class Crolling {

    private String img;

    private String nickname;

    private String region;

    private String title;

    private String category;

    private String createdAt;

    private String price;

    private String contents;

    private int chat;

    private  int like;

    private int view;
    
}
