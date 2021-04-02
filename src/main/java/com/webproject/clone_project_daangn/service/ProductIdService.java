package com.webproject.clone_project_daangn.service;

import com.webproject.clone_project_daangn.model.entity.ProductId;
import com.webproject.clone_project_daangn.repository.ProductIdRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductIdService {

    private final ProductIdRepository productIdRepository;

    private static String DaangnUrl = "https://www.daangn.com/region/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C/%EA%B0%95%EB%82%A8%EA%B5%AC";
    private static String Detail_DaangnUrl = "https://www.daangn.com/articles/";

    @PostConstruct
    public void getKoreaCovidDatas() throws IOException {

        Document doc = Jsoup.connect(DaangnUrl).get();
        Elements contents = doc.select("article");
        for (Element content : contents) {
            String domain = content.select("a").attr("data-event-label");
            ProductId gangnamProductId = new ProductId(domain);
            productIdRepository.save(gangnamProductId);
        }

        make_detail(productIdRepository.findAll());
    }

    public void make_detail(List<ProductId> product_list) throws IOException {

        for(int i = 0; 1>i ; i++){
            List<String> img_list = new ArrayList<>();


            Document doc2 = Jsoup.connect(Detail_DaangnUrl+product_list.get(i).getProductId()).get();
            Element contents2 = doc2.select("#content").get(0);
            Elements img_container = contents2.select("img");

            for(Element img_text: img_container){
                String img_src = img_text.attr("data-lazy");
                img_list.add(img_src);
            }
            for(int j = 0; j<img_list.size();j++){
                System.out.println(img_list.get(j));
            }

        }
    }
}
