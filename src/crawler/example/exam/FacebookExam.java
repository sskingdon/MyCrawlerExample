package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/posts?&since=1480852800&until=1480856400&fields=id,reactions.type(HAHA).limit(0).summary(total_count)"
				+ "&access_token=EAACEdEose0cBAHiKOhjQZBVfEv3kY3XVLw1nfRh3JHLHnhVU6VsNKvZBf8vwLECx4ZANwHPzylTVXwP37qMIaMxOZB6U73oWwkNAx5uhucUqX6JUEzv7qxAacIdvhMdBFX3y0bE19Gaw8OotoPLoSqhXXsnmkRyMyoId9p6EoVD10BxUIoO05lhs8BGQOQTp2ZBqdYglxOQZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output="";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			String reaction_HAHA = data.select("total_count").text();
			// FIXIT



			output += id + "," + reaction_HAHA + "\n";
		}

		System.out.println( output );
	} 
}
