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
public class BasicExample {
	// commit test
	public static void main(String[] args) {

		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		String uri = "https://www.ptt.cc/bbs/MakeUp/index.html";

		Document content = CrawlerPack.start().getFromHtml(uri);

		for (Element ele1 : content.select(".r-ent")) {
			String title = ele1.select(".title a").text();
			String author = ele1.select(".author").text();
			uri = "https://www.ptt.cc"+ele1.select(".title a[href]").attr("href");
			//System.out.print(title+"\t"+author+"\t"+uri);
            System.out.println(uri);

            Document content2 = CrawlerPack.start().getFromHtml(uri);
			System.out.print(content2.select(".push .push-userid"));

		}
	}
}
