package kr.co.bit.obj3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintList {
	
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
	}
	
	public void printList(Connection conn) throws SQLException {
		System.out.println("게시글 전체 출력");
		System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 날짜 \t 조회수");
		
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD"; //select * from board >> 모든 항목 다 가져오기
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
		pstmt.close();
		conn.close();
	}
}
