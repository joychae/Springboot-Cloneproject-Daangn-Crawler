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
    private String title; // 시도명

    private String imgUrl; // 전일대비확진환자증감

    private int price; // 확진환자수

    private int region; // 사망자수

    private String like; // 발병률

    private String chat; // 일일 검사환자 수
}
