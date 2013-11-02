package kk.trade.batch.UpdateStockMaster;

import java.util.ArrayList;

import kk.trade.beans.DownloadStockInfo;
import kk.trade.business.*;
import kk.trade.dao.*;

public class UpdateStockMasterMain {

	public static void main(String[] args){
		update();
	}
	
	private static void update() {
		try{
		ArrayList<DownloadStockInfo> inf = (new StockLoader()).loadStock("2013-08-11","stockT");
		StockMasterDataAccess dao = new StockMasterDataAccess();
		dao.updateStockMaster(inf);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
