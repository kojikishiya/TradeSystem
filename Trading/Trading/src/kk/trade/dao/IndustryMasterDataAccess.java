package kk.trade.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kk.common.DataAccessBase;
import kk.trade.entity.*;

public class IndustryMasterDataAccess 
	extends DataAccessBase<IndustryMasterEntity>{
	
	private static String SQL_SELECT_ALL = "select INDUSTRY_CODE,INDUSTRY_NAME from industry_master order by INDUSTRY_CODE; ";
	
	public ArrayList<IndustryMasterEntity> getData(){
		
		return getDataSql(SQL_SELECT_ALL);
	}

	@Override
	public IndustryMasterEntity invoke(ResultSet rs) throws SQLException{
		
		IndustryMasterEntity data
		= new IndustryMasterEntity();
		data.setIndusryName(rs.getString("INDUSTRY_NAME"));
		data.setIndustryCode(rs.getString("INDUSTRY_CODE"));
		return data;

		
	}
	

}
