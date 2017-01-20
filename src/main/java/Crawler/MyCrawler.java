package Crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;




import java.util.regex.Pattern;


public class MyCrawler extends WebCrawler {

    //TODO adjust FILTERS pattern
    //Pattern for sites to be ignored, might have to adjust it tho
    private static final Pattern FILTERS = Pattern.compile(
            ".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf" +
                    "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    //public BlogStat blogStat;


    // private static  final Logger logger = LoggerFactory.getLogger(MyCrawler.class);

    private static final Logger logger = LogManager.getLogger(MyCrawler.class);

    public MyCrawler() {

        // blogStat = new BlogStat();

    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url){
        String href = url.getURL().toLowerCase();

        return !FILTERS.matcher(href).matches() && href.startsWith("http://www.garten-fraeulein.de/category");
    }

    @Override
    public void visit(Page page) {
        logger.info("Visited: " + page.getWebURL().getURL());

        String href = page.getWebURL().getURL().toLowerCase();

        //href = "http://www.garten-fraeulein.de/madeira/";

        Pattern pattern = Pattern.compile("http://www.garten-fraeulein.de/category/(.)*");

        if(!pattern.matcher(href).matches() && !href.equals("http://www.garten-fraeulein.de/")){

            if(page.getParseData() instanceof HtmlParseData){



                //hier processing code
                logger.info("Seite processed");
                //Auswerter.ausgabe(); Aufruf der Ausgabe
                Auswerter.sniffer(page);

            }
        }else{
            logger.info("Seite ignoriert");
        }





    }

    public void dumpStats(){







    }
}
