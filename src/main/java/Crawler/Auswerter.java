package Crawler;

import com.sun.javafx.runtime.SystemProperties;
import edu.uci.ics.crawler4j.crawler.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.time.LocalDate;


public class Auswerter {

    public static void sniffer(Page page){
//Jsoup - Teil
        Document doc = HTMLSpider.parsePage(page);
        Elements divsid = doc.select("divwas ");

        Elements divs = doc.select("div.post-content > p");
        Elements hs = doc.select("h1, h2, h3, h4, h5, h6");
        Elements date = doc.select("span.published");
        System.out.println(date.first().toString());
        Elements updated = doc.select("span.published");
    }

    public static boolean ausgabe(){

       //Datum Dateiname
        LocalDate now = LocalDate.now();
        String target = "Export" + now.toString() + ".csv" ;

        String testString = "hallo;zweite\nhallo;zweite";

        try{
            PrintWriter pw = new PrintWriter(new File(target));

            //HIer kommt der Doppelt CSV Müll hin

            pw.write(testString);
            pw.close();

        } catch (FileNotFoundException e ) {
            System.out.println("Datei konnte nicht gefunden werden");
        }

        return true;
    }
}
