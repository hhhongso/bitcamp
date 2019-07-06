package kr.co.bit.obj4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


abstract public class Function {
	public static Connection conn;
	public static BufferedReader br;
	public static String session;
	
	protected String id; 
	protected String pw; 
	protected String addr;
	protected String tel; 
	
	
	protected String sql; 
	protected PreparedStatement pstmt; 
	protected ResultSet rs;
	
	public static void getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	static {	
		br = new BufferedReader(new InputStreamReader(System.in));
		session = null;
	}

	abstract protected void isLogin();
	abstract protected void set();
	abstract protected void setSql();
	abstract protected void setQuery(); 
	abstract protected void execute();
	abstract protected void close();
	abstract protected void process();

}
