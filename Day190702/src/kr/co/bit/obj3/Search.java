package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	
	private String searchTitle; 
	private String sql; 
	private PreparedStatement pstmt;
	private ResultSet rs; 
	
	public void search() throws SQLException, IOException {
		System.out.println("찾는 게시글 제목 입력: ");
		Connection conn = Register.getConnection();
		
			searchTitle = Register.br.readLine();
			sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTitle);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				int readCount = rs.getInt("readcount");
				
				System.out.println("번호" + "\t" + "제목" + "\t" +"내용" + "\t" +"작성자" + "\t" +"날짜" + "\t" +"조회수");
				System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			}
			
			pstmt.close();
			conn.close();
		
	}
}
