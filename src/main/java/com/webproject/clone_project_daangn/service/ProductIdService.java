package com.webproject.clone_project_daangn.service;

import com.webproject.clone_project_daangn.model.entity.Product;
import com.webproject.clone_project_daangn.model.entity.ProductId;
import com.webproject.clone_project_daangn.repository.ProductIdRepository;
import com.webproject.clone_project_daangn.repository.ProductRepository;
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
    private final ProductRepository productRepository;

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

        for(int i = 0; 3>i ; i++){
           String imgs = "";


            Document doc2 = Jsoup.connect(Detail_DaangnUrl+product_list.get(i).getProductId()).get();
            Element contents2 = doc2.select("#content").get(0);
            Elements img_container = contents2.select("img");

            for(Element img_text: img_container){
                String img_src = img_text.attr("data-lazy");
                imgs = imgs + " 기준 " + img_src;
            }

//            Elements contents2 = doc2.select("#content");
            Elements contents3 = contents2.select("section");
            String contents4 = contents3.select("p").get(0).text();
            String contents5 = contents3.select("#article-counts").text();
            String [] contents6 = contents5.split("∙");

            String nickname = contents3.select("#nickname").text();
            String region = contents3.select("#region-name").text();
            String title = contents3.select("h1").text();
            String category = contents4.substring(0,contents4.indexOf("∙")).trim();
            String createdAt = contents4.substring(contents4.indexOf("∙")+1).trim();
            String price = contents3.select("#article-price").text();
            String contents = contents3.select("#article-detail > p").text();
            String chat = contents6[0].trim();
            String like = contents6[1].trim();
            String view = contents6[2].trim();

            Product product = new Product(imgs,contents,nickname, region, title, category, createdAt, price, chat, like, view);
            productRepository.save(product);

//            System.out.println(contents3.select("#nickname").text()); // nickname
//            System.out.println(contents3.select("#region-name").text()); //region
//            System.out.println(contents3.select("h1").text());  // title
//            System.out.println(contents4.substring(0,contents4.indexOf("∙")).trim());  // category
//            System.out.println(contents4.substring(contents4.indexOf("∙")+1).trim());  // createdAt
//            System.out.println(contents3.select("#article-price").text()); // price
//            System.out.println(contents3.select("#article-detail > p").text()); // contents
//            System.out.println(contents6[0].trim()); // chat
//            System.out.println(contents6[1].trim()); // like
//            System.out.println(contents6[2].trim()); // view
//            System.out.println("=====");

        }
    }
}
