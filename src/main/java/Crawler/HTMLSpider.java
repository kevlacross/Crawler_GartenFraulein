package Crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HTMLSpider {
    public static Document parsePage(Page page) {

        //Konvertierung in String weil jsoup das so brauch

        HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
        String html = htmlParseData.getHtml();

        return Jsoup.parse(html);
    }
}
