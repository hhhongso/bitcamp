package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
	public static BufferedReader br;
	public static Connection conn;
	
	private int no; 
	private String titleContent; 
	private int indexI; 
	private String title; 
	private String content;
	
	private String sql;
	private PreparedStatement pstmt;
	private int count; 
	
	public Register() {
		//초기화: 0/null값으로 자동 초기화
	}

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
	
	
			//setNO(): 입력받은 게시글 번호가 정수형이 아닐 때를 걸러내기 위함 
	public void setNo() throws IOException {
		System.out.println("게시글 번호 입력: ");
		no = Integer.parseInt(br.readLine()); //readline >> int 로 형변환
	}

	public void setTitleContent() throws IOException {
		System.out.println("제목|내용: ");		
		titleContent = br.readLine();
	}
	
	public void divideTC() {		
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);		
	}
	
	public void insertRegitSql() {
		sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT) VALUES (?, ?, ?, ?, ?, ?)";
	}
	
	public void executeRegitSql() throws SQLException {		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "김가나");
		pstmt.setString(5, "190701");
		pstmt.setInt(6, 0);
		
		count = pstmt.executeUpdate();
		
	}
	public void registerProcess() throws SQLException, IOException {
		setNo();
		setTitleContent();
		divideTC();
		insertRegitSql();
		executeRegitSql();
		
		System.out.println(count + "건 게시글이 등록 되었습니다. ");
		pstmt.close();
		conn.close();
	
}
}
