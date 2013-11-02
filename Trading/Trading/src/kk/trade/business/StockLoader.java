package kk.trade.business;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import kk.trade.beans.DownloadStockInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockLoader {

	public ArrayList<DownloadStockInfo> loadStock(String date,String market)
			throws IOException,ParseException{
	     String url = "http://k-db.com/site/download.aspx?date=%s&p=%s";	     
	     	url = String.format(url, date, market);
	        Document doc = Jsoup.connect(url).get();
	        Elements stoksPrices=doc.select("div[id=maintable]");
	        ArrayList<DownloadStockInfo> d =  new ArrayList<DownloadStockInfo>();
	        
	        for (Element stoksPrice : stoksPrices){
	        	for(Element a : stoksPrice.select("tr")){
	        		Elements td = a.select("td");
	        		String[] stockInf = td.get(0).text()
	    					.split(" ");
	        		String[] codeInfs = stockInf[0].split("-");
	        		
    			d.add(new DownloadStockInfo(
    					codeInfs[0],
    					codeInfs[1],
    					stockInf[1],
    					td.get(1).text(),
    					td.get(2).text(),
    					this.convertDoubleOrg(td.get(3).text()),
    					this.convertDoubleOrg(td.get(4).text()),
    					this.convertDoubleOrg(td.get(5).text()),
    					this.convertDoubleOrg(td.get(6).text()),
    					this.convertDoubleOrg(td.get(7).text()),
    					this.convertDoubleOrg(td.get(8).text()),
    					date));
	        	}
	        }
	        
	        return d;

	}
	
	private Double convertDoubleOrg(String val){
		Double r;
		try{
		if(val.trim() == "-"){
			return null;
		}
		r = Double.parseDouble(val);
		}
		catch(Exception ex){
			return null;
		}
		

		return r;

	}
}
