package kk.tradeing.business.test;

import kk.trade.business.*;

import org.junit.Assert;
import org.junit.Test;
public class StockPriceLoaderTest {

	@Test
	public void testloadRealTime() {
		StockPriceLoader loader = new StockPriceLoader();
		try{
			String code ="9501";
		    double r = loader.loadRealTime(code,"T");
		    Assert.assertNotSame(r, 0);
		    //Assert.assertEquals(508, r,0);
		}
		catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}

}
