package kr.co.bit.obj1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintList {
	
	private Connection conn;
	
	private String sql;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private int no; 
	private String title; 
	private String content; 
	private String author; 
	private String nal; 
	private int readCount;
	
	public PrintList() {
		conn = null; 	sql = null;		rs = null;
	}
	
	public void boardTitle() {
		System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 날짜 \t 조회수");
	}
	
	public void boardSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD ORDER BY NO ASC"; //select * from board >> 모든 항목 다 가져오기
		
	}
	
	public void boardClose() { //연속적으로 진행할 것이라면, throws 하며 main에서 예외잡이 
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void printListProcess() throws SQLException {
		boardTitle();
		boardSql();
		
		conn = Register.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readcount");
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);	
		}
		boardClose();
	}
}
