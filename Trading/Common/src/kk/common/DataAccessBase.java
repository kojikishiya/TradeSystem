package kk.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kk.common.IF.IDaoDelegate;

public abstract class  DataAccessBase<T> implements IDaoDelegate<T> {
    
	protected ArrayList<T> getDataSql(String sql){
		try{
		DataBaseAccess dao = new DataBaseAccess();
		ArrayList<T> data =
				dao.getData(sql,this);
		if(data != null){
		
		return data;
		}
		}

		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public abstract T invoke(ResultSet rs) throws SQLException;
	

}
