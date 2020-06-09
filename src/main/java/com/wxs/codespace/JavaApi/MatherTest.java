package com.wxs.codespace.JavaApi;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class MatherTest {
    public static void loadDocumentFromURL() {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.baidu.com/").get();
            // 从document中获取title值
            String title = doc.title();
            System.out.println(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  调用document的类似DOM的方法获取Element
     *
     * html: https://jsoup.org/cookbook/extracting-data/dom-navigation
     * @throws IOException
     */
    public static void extractDataByDOM() throws IOException{
        Document doc = Jsoup.connect("https://www.baidu.com/").get();
        Element lg = doc.getElementById("lg");
        log.info("getElementById lg = {}", lg);
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
            log.info("linkHref={}, linkText={}",linkHref, linkText);
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 默认group是整个正则表达式，默认为group(0)；正则表达式中的每个()都算一个group，默认为group(1~n):
         */
//        String ID_REG_EX = "toutiao.com/i([0-9]+)([0-9]*)/";
//        Pattern pattern = Pattern.compile(ID_REG_EX);
//        String url = "toutiao.com/i2/";
//        Matcher matcher = pattern.matcher(url);
//        if (matcher.find()) {
//            System.out.println("=====" + matcher.group(2));
//        }
//        else {
//            System.out.println("nothing");
//        }

        extractDataByDOM();
    }
}
