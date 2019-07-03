package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search extends Board {
	
	private Connection conn;
	
	private String searchTitle; 
	private String sql; 
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	private int no; 
	private String title; 
	private String content; 
	private String author; 
	private String nal; 
	private int readCount;
	
	public Search() {
		conn = null;	sql = null;		pstmt = null;
		no = 0;		title = null;	content = null;		author = null;		nal = null;		readCount= 0; 
	}
	
	public void setBoard() throws IOException {
		System.out.println("찾는 게시글 제목 입력: ");
		searchTitle = Register.br.readLine();
	}
	
	public void setTitle() {
		System.out.println("번호" + "\t" + "제목" + "\t" +"내용" + "\t" +"작성자" + "\t" +"날짜" + "\t" +"조회수");
		
	}
	
	public void setSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
		
	}
	public void executeSql() {
		getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchTitle);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readcount");
		}
	}	
	public void setClose() {		
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void executeProcess() throws SQLException, IOException {
		setBoard();
		setTitle();
		setSql();
		executeSql();			
		System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
		setClose();
				
	}
		
	
}
