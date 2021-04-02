package com.webproject.clone_project_daangn.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CrollingService {

    private static String DaangnUrl = "https://www.daangn.com/region/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C/%EA%B0%95%EB%82%A8%EA%B5%AC";

    @PostConstruct
    public void getKoreaCovidDatas() throws IOException {

        Document doc = Jsoup.connect(DaangnUrl).get();
        Elements contents = doc.select("section");
        for (Element content : contents) {
            Elements tdContents = content.select("article");

            String title = tdContents.select("a").attr("data-event-label");

        }

    }
}