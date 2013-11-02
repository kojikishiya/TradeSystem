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
            // �e�[�u���Ɖ���s
            Statement stmt = con.createStatement ();
            ResultSet rs = stmt.executeQuery (sql);
    		ArrayList<T> list 
    		= new ArrayList<T>();
    		while(rs.next()){
    			list.add(delegate.invoke(rs));
    		}
            
            // �f�[�^�x�[�X�̃N���[�Y
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
        // JDBC�h���C�o�̓o�^
		String driver   = "org.gjt.mm.mysql.Driver";
        // �f�[�^�x�[�X�̎w��
        String server   = "localhost";      // MySQL�T�[�o ( IP �܂��� �z�X�g�� )
        String dbname   = "trade";         // �f�[�^�x�[�X��
        String url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=EUC_JP";
        String user     = "tradeuser";         // �f�[�^�x�[�X�쐬���[�U��
        String password = "tradeuser";     // �f�[�^�x�[�X�쐬���[�U�p�X���[�h
        Class.forName (driver);
        // �f�[�^�x�[�X�Ƃ̐ڑ�
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
	}
}
