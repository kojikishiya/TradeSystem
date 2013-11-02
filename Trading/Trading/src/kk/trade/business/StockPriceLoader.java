package kk.trade.business;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class StockPriceLoader {


	
	public double loadRealTime(String securityCode,String marketCode)	
			throws IOException {
	     String url = "http://stocks.finance.yahoo.co.jp/stocks/detail/?code=%s.%s";
	     	url = String.format(url, securityCode,getMarketCodeOrg(marketCode));
	        Document doc = Jsoup.connect(url).get();
	        Elements stoksPrices=doc.select("td[class=stoksPrice]");
	       
	        double d = 0;
	        
	        for (Element stoksPrice : stoksPrices){
	            d = Double.parseDouble( stoksPrice.text());
	        }
	        
	        return d;
	}
	
	private String getMarketCodeOrg(String marketCode){
		switch(marketCode){
		case "":
		return "T";
		default:
			return "T";
		}
	}
}
