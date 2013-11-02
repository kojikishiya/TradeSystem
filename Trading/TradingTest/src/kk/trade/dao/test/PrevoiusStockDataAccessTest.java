package kk.trade.dao.test;

import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import kk.trade.dao.*;

public class PrevoiusStockDataAccessTest {
	@Test
	public void getMaxDateTest() throws ClassNotFoundException, SQLException{
		String date = new PreviousStockDataAccess().getMaxDate();
		
		//Assert.assertEquals("2013-08-17", date);
	}
	@Test
	public void getTopCountPriceTest() throws ClassNotFoundException, SQLException{
		ArrayList<Double> list = new PreviousStockDataAccess().getTopCountPrice("2148", 10);
		
		Assert.assertEquals(10, list.size());
		Assert.assertEquals(480.0, list.get(0).doubleValue());
		Assert.assertEquals(503.0, list.get(9).doubleValue());
	}
}
