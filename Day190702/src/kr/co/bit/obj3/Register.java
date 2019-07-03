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
		//�ʱ�ȭ: 0/null������ �ڵ� �ʱ�ȭ
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
	
	
			//setNO(): �Է¹��� �Խñ� ��ȣ�� �������� �ƴ� ���� �ɷ����� ���� 
	public void setNo() throws IOException {
		System.out.println("�Խñ� ��ȣ �Է�: ");
		no = Integer.parseInt(br.readLine()); //readline >> int �� ����ȯ
	}

	public void setTitleContent() throws IOException {
		System.out.println("����|����: ");		
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
		pstmt.setString(4, "�谡��");
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
		
		System.out.println(count + "�� �Խñ��� ��� �Ǿ����ϴ�. ");
		pstmt.close();
		conn.close();
	
}
}
