package kk.tradeing.business.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import kk.trade.beans.DownloadStockInfo;
import kk.trade.business.*;
public class StockLoaderTest {

	@Test
	public void testloadStock() throws IOException,ParseException{
		ArrayList<DownloadStockInfo> inf = (new StockLoader()).loadStock("2013-07-12","stockT");
		assertNotSame(0, inf.size());
		 assertEquals("1301", inf.get(0).getSecurityCode());
		 assertEquals("T", inf.get(0).getMarketID());
		 assertEquals("ã…óm", inf.get(0).getSecurityName());
		 assertEquals("ìåèÿ1ïî",inf.get(0).getMarketName());
		 assertEquals("êÖéYÅEî_ó—ã∆",inf.get(0).getIndustry());
		 assertEquals(303.0 ,inf.get(0).getOpeningPrice(),0);
		 assertEquals(306.0, inf.get(0).getHighPrice(),0);
		 assertEquals(296.0,inf.get(0).getLowPrice(),0);
		 assertEquals(296.0,inf.get(0).getClosingPrice(),0);
		 assertEquals(3121000,inf.get(0).getDealings(),0);
		 assertEquals(935271000,inf.get(0).getSalesValue(),0);
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		 assertEquals("2013/07/12",sdf1.format(inf.get(0).getDate()));
	}
	
	@Test
	public void testdto(){
		//String id = new ConvertCodeDataAccess().get();
		//assertEquals("0",id);
	}
	
	

}
