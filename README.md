Springboot-Cloneproject-Daangn-당근마켓-Crawler
=====================

참여인원 : 백앤드 2명 (김동현, 채수연) / 프론트 2명 (김광수, 박민경)  


</br>

프로젝트 백앤드 당근마켓 클론 프로젝트에 필요한 데이터를 쌓기위한 코드입니다.
- 당근마켓의 인기 매물 상품 번호를 받아왔습니다.  
- 인기 매물 상품번호를 기준으로 상세정보 url로 접속한 후 상세정보를 크롤링 하였습니다.

</br>

개발 언어
---------
- Backend: Java 8
- Frontend: React


</br>

개발 환경
---------
- Java: JDK 1.8.0  
- IDE: IntelliJ IDEA 2020.3.3 x64  
- Build Management: Gradle  
- Framework: SpringBoot  
> - ORM: Spring Data JPA  
> - Sub-Framework: Spring security  


</br>

폴더 구조
---------
```
main
java
com.clone.daangnclone_Crawler
│  │  
│  │  
├─ model.entity
│  └─ Product.java
│  └─ ProductId.java
│  │
│  │  
├─ repository
│  └─ ProductIdRepository.java
│  └─ ProductRepository.java
│  │
│  │  
├─ service
│  └─ ProductIdService.java
└─  DanngnCloneApplication
```


</br>

기능 소개
---------
- 크롤링의 전반적인 로직

>- 인기매물 목록 페이지에 들어가서 각각의 상품 ID값을 추출
>- 추출된 아이디 값을 ProductId DB에 저장
>- 저장하고자 하는 매물들의 ID값이 담긴 ProductId DB의 모든 목록을 불러옴
>- 불러온 리스트의 요소들을 매물 상세 페이지 URL에 id 값으로 넣어줌
>- 넣어준 URL에 접속하여 매물의 상세 정보를 추출

기능의 자세한 로직
---------
- ProductID값 추출하기
```
 @PostConstruct
    public void getKoreaCovidDatas() throws IOException {
        String [] regions= {"강남구","강북구","노원구","동대문구","동작구","마포구","송파구","용산구"};
        for(int i =0; i<regions.length ; i++){
            String want = DaangnUrl + regions[i];
            Document doc = Jsoup.connect(want).get();
            Elements contents = doc.select("article");
            for (Element content : contents) {
                String domain = content.select("a").attr("data-event-label");
                ProductId gangnamProductId = new ProductId(domain);
                productIdRepository.save(gangnamProductId);
            }
        }

        make_detail(productIdRepository.findAll());
    }
```

>- 추출하고자 하는 지역을 배열안에 넣어준다.
>- 반복문이 돌면서 DaangnUrl뒤에 상세 주소로 배열의 요소를 넣어준다.
>- 완성된 want 변수를 기준으로 크롤링을 시작하여 ProductId값을 추출한다.

- Product 값 추출하기
```
 public void make_detail(List<ProductId> product_list) throws IOException {

        for(int i = 0; product_list.size()>i ; i++){
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
            String danngnProductId = product_list.get(i).getProductId();

            Product product = new Product(imgs,contents,nickname, region, title, category, createdAt, price, chat, like, view, danngnProductId);
            productRepository.save(product);

        }
    }
```

>- 불러온 ProductID 길이만큼 반복문 실행(모든 상품의 상세정보 크롤링)
>- 그롤링한 상세정보를 Product DB에 저장한다.
