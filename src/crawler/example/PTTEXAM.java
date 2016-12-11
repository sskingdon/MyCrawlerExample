package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class PTTEXAM {
	// commit test
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481374603.A.18B.html";

        Document jsoup = CrawlerPack.start().addCookie("over18","1").getFromHtml(uri);
        //System.out.println(jsoup);
        for (Element ele:jsoup.select("#main-content *")) {
            ele.remove();
            //System.out.println(ele);
        }
        System.out.println(jsoup.select("#main-content").text());
    }
}
