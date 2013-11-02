package kk.trade.businesscore;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TodayNewsReader extends NewsReaderAbstract
{
	private static String  urlConstatnt = "http://headlines.yahoo.co.jp/";
	private static String urlHeadline ="hl";
	private String[] contents = new String[]{"bus_all&t=l","brf&t=l","biz&t=l","ind&t=l","pol&t=l","sci&t=l",
			"sctch&t=l","prod&t=l"};
			private static String urlPram = "?a=";
	private int maxUrl = 10000;
	private String today="";
	
	public TodayNewsReader(){
		super();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd-");
		Calendar cal = Calendar.getInstance();
		today = sdf1.format(cal.getTime());
		
	}
	
	private String createUrl(String kind){
		String url =
				urlConstatnt + urlHeadline + "hl?c=" + kind;
		return url;
	}
	
	@Override
	protected String extractBodyText(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements textElements=doc.select("p[class=ynDetailText]");
		String text = "";
        for (Element ele : textElements){
        	text += Double.parseDouble( ele.text());
        }
        return text;
	}


	@Override
	protected ArrayList<String> createUrls() {
		ArrayList<String> list = new ArrayList<String>();
		for(String con : contents){
			list.add(createUrl(con));
		}
		return list;
	}
	@Override
	protected int getMaxUrlCount() {

		return maxUrl;
	}
	@Override
	protected ArrayList<String> findUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        ArrayList<String> list = new ArrayList<String>();
        
        for(Element link : links){
        	if(link.text().startsWith(urlConstatnt + urlHeadline +urlPram+today)){
        		list.add(link.text());
        	}
        }
        
        return list;
	}
	
}
