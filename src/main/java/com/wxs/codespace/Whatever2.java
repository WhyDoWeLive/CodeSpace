package com.wxs.codespace;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.wxs.codespace.RPCTest.SerializableTest.SerializablePersonTest;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Whatever2{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new DateTime(1593036743000L));
    }

    /**
     * Jsoup
     * @throws IOException
     */
    public static void getHtmlByJsoup(String url) throws IOException {
//        Map<String, String> cookies = new HashMap<>();
//        cookies.put("SINAGLOBAL", "5088163188475.501.1591409145455");
//        cookies.put("UOR", ",,www.google.com");
//        cookies.put("wvr", "6");
//        cookies.put("webim_unReadCount", "%7B%22time%22%3A1591458645724%2C%22dm_pub_total%22%3A0%2C%22chat_group_client%22%3A0%2C%22chat_group_notice%22%3A0%2C%22allcountNum%22%3A1%2C%22msgbox%22%3A0%7D");
//        cookies.put("SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9WFxCbW0ZsmcT81xa4FKDIlK5JpX5KMhUgL.FoqX1h.RS0z4eoM2dJLoI7_PIGL2dfULKsLc9Btt");
//        cookies.put("ALF", "1623029730");
//        cookies.put("SSOLoginState", "1591493730");
//        cookies.put("SCF", "AgfTmuwj5VeL_NEQXm62bE9gHwtKnLJjTq7t1Dn_DDINmdygPYX6qqz-tZYYRwmoSm8iDc_KaqCLG1nc5S4QiaQ.");
//        cookies.put("SUB", "_2A25z2DQzDeRhGeBK41sZ9yzFyTuIHXVQrCL7rDV8PUNbmtAKLWPykW9NR2Lw_AGU2RZbrwQgi9hwRo3PO2QxnE57");
//        cookies.put("SUHB", "0h1J-YhIy22NGH");
//        cookies.put("YF-V5-G0", "99df5c1ecdf13307fb538c7e59e9bc9d");
//        cookies.put("_s_tentry", "weibo.com");
//        cookies.put("Apache", "9976560118921.87.1591493763449");
//        cookies.put("wb_view_log_6489872927", "2560*14402");
//        cookies.put("ULV", "1591493763464:2:2:1:9976560118921.87.1591493763449:1591409145961");
//        cookies.put("YF-Page-G0", "4358a4493c1ebf8ed493ef9c46f04cae|1591493763|1591493763");



        Connection connection = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36")
                ;
        Connection.Response response = connection.execute();
        System.out.println(response.statusCode());
        System.out.println(response.body());
//        System.out.println(response.);
    }

    public static void getHtmlByJavaAPI(String pageUrl, String encoding) throws IOException {
        StringBuffer sb = new StringBuffer();
        //构建一URL对象
        URL url = new URL(pageUrl);
        //使用openStream得到一输入流并由此构造一个BufferedReader对象
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
        String line;
        //读取www资源
        while ((line = in.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        in.close();
        System.out.println(sb.toString());
    }

    public static void getHtmlByHtmlUnitAndJsoup(String url) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //支持JavaScript
        webClient.getOptions().setJavaScriptEnabled(true);  //启用js解析器
        webClient.getOptions().setCssEnabled(false);   //禁用css文件
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);  //运行js错误时是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(9000);
        //设置一个运行JavaScript的时间
        webClient.waitForBackgroundJavaScript(6000);

        HtmlPage rootPage = webClient.getPage(url);
        System.out.println(rootPage.asXml());
    }
}
