package com.carwl.carwldata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class excutePicture {
    //d3p https://bbs.17500.cn/thread-4417635-1-2.html
    //d3z

    public static void main(String[] args) {
        String url = "https://bbs.17500.cn/thread-4417635-1-2.html";
        try {
            //先调用下忽略https证书的再请求才可以
            HttpsUrlValidator.retrieveResponseFromServer(url);
            Document doc = Jsoup
                    .connect(url)
                    .timeout(100000).get();
            if (doc != null) {
                Elements tables = doc.getElementsByTag("table");
                if (tables != null && tables.size() > 0) {
                    List<Elements> elements = new ArrayList<Elements>();
                    for (Element element : tables) {
                        if (element.attr("id").indexOf("pid") != -1) {
                            Elements obj = element.select("div.xs0");
                            if (obj!=null&&obj.size()>0){
                                elements.add(obj);
                            }
                        }
                    }
                    System.out.println(elements);
                }

//                List<Node> nodes = doc.childNodes();
//                if (nodes!=null&&nodes.size()>0)
//                {
//                    Node node = nodes.get(1);
//                    String html = ((Element) node).html();
//                    Document docment = Jsoup.parse(html);
//                    String body = docment.getElementById("#postlist").html();
//                    System.out.println(docment);
//                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
