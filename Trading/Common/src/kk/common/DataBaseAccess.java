package kk.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import kk.common.IF.IDaoDelegate;


public class DataBaseAccess {
	public <T> ArrayList<T> getData(String sql,IDaoDelegate<T> delegate){

		
        try {
        	Connection con = getConnection();
            // テーブル照会実行
            Statement stmt = con.createStatement ();
            ResultSet rs = stmt.executeQuery (sql);
    		ArrayList<T> list 
    		= new ArrayList<T>();
    		while(rs.next()){
    			list.add(delegate.invoke(rs));
    		}
            
            // データベースのクローズ
            rs.close();
            stmt.close();
            con.close();
            return list;
            
        } catch (SQLException e) {
            System.err.println("SQL failed.");
            e.printStackTrace ();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace ();
        }
        return null;
	}
	Connection conn;
	PreparedStatement stmt;
	public DataBaseAccess() throws SQLException,ClassNotFoundException{
		conn = getConnection();
		
	}
	public void setString(int parameterIndex,String value) throws SQLException{
		stmt.setString(parameterIndex, value);
	}
	public void setDouble(int parameterIndex,Double value) throws SQLException{
		if(value == null)
			stmt.setNull(parameterIndex,java.sql.Types.DOUBLE);
		else
		stmt.setDouble(parameterIndex, value);
		
	}
	public void prepareStatement(String sql) throws SQLException{
		stmt = conn.prepareStatement(sql);

	}
	public int executeUpdate(){
		try {
			
			  int num = stmt.executeUpdate();
			  return num;
			}catch (SQLException e){
			  e.printStackTrace();
			}
		return 0;
	}
	private Connection getConnection() throws SQLException,ClassNotFoundException{
        // JDBCドライバの登録
		String driver   = "org.gjt.mm.mysql.Driver";
        // データベースの指定
        String server   = "localhost";      // MySQLサーバ ( IP または ホスト名 )
        String dbname   = "trade";         // データベース名
        String url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=EUC_JP";
        String user     = "tradeuser";         // データベース作成ユーザ名
        String password = "tradeuser";     // データベース作成ユーザパスワード
        Class.forName (driver);
        // データベースとの接続
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
	}
}
