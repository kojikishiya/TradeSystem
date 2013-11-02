package kk.trade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kk.common.DataAccessBase;
import kk.common.DataBaseAccess;
import kk.trade.entity.PreviousStockDataEntity;

public class PreviousStockDataAccess 
{

	 private static String SQL_UPDATE ="insert into previous_stock_data (SECURITY_CODE,ID,MARKET_CODE,INDUSTRY_CODE,OPENING_PRICE,HIGH_PRICE,LOW_PRICE,CLOSING_PRICE,DEALINGS,SALES_VALUE,VALUE_DATE)" 
				+ " values (?,?,?,?,?,?,?,?,?,?,?) "
				+ " ON DUPLICATE KEY UPDATE ID = ?,INDUSTRY_CODE = ?,OPENING_PRICE=?,HIGH_PRICE=?,LOW_PRICE=?,CLOSING_PRICE=?,DEALINGS=?,SALES_VALUE=?";
	 
	 
	 private static String SQL_SELECT_MAXDATE ="select max(VALUE_DATE) from previous_stock_data";
	 
	 private static String SQL_SELECT_TOPCOUNT_PRICE ="select CLOSING_PRICE,SECURITY_CODE,MARKET_CODE from trade.previous_stock_data where SECURITY_CODE= '%s'  ORDER BY VALUE_DATE DESC limit 0,%s";
	 public String getMaxDate() throws ClassNotFoundException, SQLException{
		 ArrayList<String> list = new DataBaseAccess().getData(SQL_SELECT_MAXDATE, new SelectString());
		 if(list.size() == 0){
			 return "2012-01-01";
		 }
		 return list.get(0);
	 }
	 public ArrayList<Double> getTopCountPrice(String securityCode,int count) throws ClassNotFoundException, SQLException{
		 String sql = String.format(SQL_SELECT_TOPCOUNT_PRICE,securityCode,count);
		 
		 return new DataBaseAccess().getData(sql, new SelectDouble());
	 }
	public int updateData(ArrayList<PreviousStockDataEntity> updateData) throws SQLException, ClassNotFoundException{
		int cnt = 0;
		 DataBaseAccess dao  = new DataBaseAccess();
		   dao.prepareStatement(SQL_UPDATE);
		   	   for(PreviousStockDataEntity data : updateData){
			   dao.setString(1, data.getSecurityCode());
			   dao.setString(2, data.getId());
			   dao.setString(3, data.getMarketCode());
			   dao.setString(4, data.getIndustryCode());
			   dao.setDouble(5, data.getOpeningPrice());
			   dao.setDouble(6, data.getHighPrice());
			   dao.setDouble(7, data.getLowPrice());
			   dao.setDouble(8, data.getClosingPrice());
			   dao.setDouble(9,data.getDealings());
			   dao.setDouble(10, data.getSalesValue());
			   dao.setString(11, data.getValueDate());
			   dao.setString(12, data.getId());
			   dao.setString(13, data.getIndustryCode());
			   dao.setDouble(14, data.getOpeningPrice());
			   dao.setDouble(15, data.getHighPrice());
			   dao.setDouble(16, data.getLowPrice());
			   dao.setDouble(17, data.getClosingPrice());
			   dao.setDouble(18,data.getDealings());
			   dao.setDouble(19, data.getSalesValue());
			   
			   cnt+= dao.executeUpdate();
		   }
		   return cnt;
		
		
	}

	class SelectString 
	extends DataAccessBase<String>{
		@Override
		public String invoke(ResultSet rs) throws SQLException {
			
			return rs.getString(1);
		}
	}
	
	class SelectDouble 
	extends DataAccessBase<Double>{

		@Override
		public Double invoke(ResultSet rs) throws SQLException {
			return rs.getDouble(1);
		}
		
	}

}
