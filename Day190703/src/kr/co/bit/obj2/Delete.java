package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	private Connection conn;
	
	private String delTitle;
	private String sql; 
	private PreparedStatement pstmt; 
	private int count; 
	
	public Delete() {
		
	}
	
	public void deleteTitle() throws IOException{
		System.out.println("삭제할 게시글 제목 입력: ");								
		delTitle = Register.br.readLine();
		
	}
	public void deleteSql() {
		sql = "DELETE FROM BOARD WHERE TITLE = ? ";
		
	}
	
	public void deleteQuery() {
		conn = Register.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);

		count = pstmt.executeUpdate();
	}
	public void deleteClose() {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public void deleteProcess() throws SQLException, IOException {
		deleteTitle();
		deleteSql();
		
		if(count == 0) {
			System.out.println("삭제할 게시글이 없습니다. ");
		} else {
		System.out.println(count + "건 게시글이 삭제 되었습니다. ");
		
		deleteClose();
		}
	}
}
