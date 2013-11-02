package kk.trade.businesscore;

import java.sql.SQLException;
import java.util.ArrayList;

import kk.trade.dao.PreviousStockDataAccess;

public class MovingAverage {

	public double getMovingAverage(String securityCode, int dayCount) throws ClassNotFoundException, SQLException{
		return getMovingAferage(
				new PreviousStockDataAccess().getTopCountPrice(securityCode, dayCount));
	}
	
	public double getMovingAferage(ArrayList<Double> prices){
		double sum = 0;
		for(Double price : prices){
			sum += price.doubleValue();
		}
		
		return sum/prices.size();
	}
}
