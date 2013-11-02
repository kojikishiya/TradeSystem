package kk.trade.businnesscore.test;

import java.sql.SQLException;

import junit.framework.Assert;
import kk.trade.businesscore.MovingAverage;

import org.junit.Test;

public class MovingAverageTest {
	@Test
	public void getTopCountPriceTest() throws ClassNotFoundException, SQLException{
		Double average = new MovingAverage().getMovingAverage("2148", 10);
		
		Assert.assertEquals(492.6,average);
		
	}
}
