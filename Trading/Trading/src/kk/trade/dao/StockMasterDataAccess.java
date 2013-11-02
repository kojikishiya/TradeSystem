

package kk.trade.dao;

import java.util.ArrayList;
import java.sql.SQLException;

import kk.trade.beans.*;
import kk.common.*;

public class StockMasterDataAccess {

	private static String SQL_UPDATE =
					"insert into stock_master (SECURITY_CODE,MARKET_CODE,SECURITY_NAME,MARKET_NAME,INDUSTRY_NAME) "
					+ " values (?,?,?,?,?) "
					+ " ON DUPLICATE KEY UPDATE SECURITY_NAME = ?,MARKET_NAME = ?,INDUSTRY_NAME=?";
	public int updateStockMaster(ArrayList<DownloadStockInfo> info)
			throws SQLException,ClassNotFoundException {
		
	   DataBaseAccess dao  = new DataBaseAccess();
	   dao.prepareStatement(getUpdateSql());
	   int cnt =0;
	   for(DownloadStockInfo inf : info){
		   dao.setString(1, inf.getSecurityCode());
		   dao.setString(2, inf.getMarketID());
		   dao.setString(3, inf.getSecurityName());
		   dao.setString(4, inf.getMarketName());
		   dao.setString(5, inf.getIndustry());
		   dao.setString(6, inf.getSecurityName());
		   dao.setString(7, inf.getMarketName());
		   dao.setString(8, inf.getIndustry());
		   cnt+= dao.executeUpdate();
	   }
	   return cnt;
	}
	
	private String getUpdateSql(){
		return SQL_UPDATE;
	}



}
