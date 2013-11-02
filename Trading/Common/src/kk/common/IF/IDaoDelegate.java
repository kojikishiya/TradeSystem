package kk.common.IF;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDaoDelegate<T> {
	public T invoke(ResultSet rs) throws SQLException ;
}
