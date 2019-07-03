package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Board {

	protected static BufferedReader br; 
	protected static Connection conn; 
	
	protected String sql;
	protected PreparedStatement pstmt; 
	protected ResultSet rs;
	
	protected int no;
	protected String title;
	protected String content;
	protected String author; 
	protected String nal;
	protected int readCount; 
	
	protected int count; 
	
	static {
		br = new BufferedReader(new InputStreamReader(System.in)); 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		return conn;
	}	
}


interface constructorMethod {
	abstract void constructorexecute();
}
	
interface processMethod {
	abstract void setBoard(); // ~할 게시글 제목 입력:
	abstract void setTitle(); // 번호, 제목, 내용, 작성자,...
	abstract void setSql(); //
	abstract void setQuery();
	abstract void executeProcess();
	abstract void setClose();
}
	


