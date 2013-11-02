package kk.trade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kk.trade.entity.*;
import kk.common.*;

public class MarketMasterDataAccess
	extends DataAccessBase<MarketMasterEntity>{

	private static String SQL_SELECT_ALL ="select MARKET_CODE,MARKET_NAME,START_DATE,END_DATE,UPDATE_DATE from market_master order by MARKET_CODE; ";
	
	public ArrayList<MarketMasterEntity> getData(){

		return getDataSql(SQL_SELECT_ALL);
		
	}

	@Override
	public MarketMasterEntity invoke(ResultSet rs) throws SQLException  {
		
		MarketMasterEntity entity = new MarketMasterEntity();
		entity.setMarketCode(rs.getString("MARKET_CODE"));
		entity.setMarketName(rs.getString("MARKET_NAME"));
		entity.setStartDate(rs.getDate("START_DATE"));
		entity.setEndDate(rs.getDate("END_DATE"));
		entity.setUpdateDate(rs.getDate("UPDATE_DATE"));
		return entity;
		
		
	}
}
