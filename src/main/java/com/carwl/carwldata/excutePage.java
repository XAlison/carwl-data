package com.carwl.carwldata;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class excutePage {
    public static void main(String[] args) throws IOException {
///sss
        String url = "https://taihu.17500.cn/home/zimi/index/?page=2";
        try {
            //先调用下忽略https证书的再请求才可以
          HttpsUrlValidator.retrieveResponseFromServer(url);
            Document doc = Jsoup
                    .connect(url)
                    .timeout(10000).get();
            //String table = doc.getElementsByClass("thtable1").html();
            String body = doc.getElementsByTag("body").html();


            System.out.println(body);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
