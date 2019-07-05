package kr.co.bit.obj;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board {
	

	public Register() {
		super();
	}
	
	public void setNo() throws IOException { 
		System.out.println("게시글 번호 입력: ");
		no = Integer.parseInt(Board.br.readLine());
	}
	
	public void divideTC() {		
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);		
	}
	
	public void setSql() {
		sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT) VALUES (?, ?, ?, ?, ?, ?)";
	}
	
	public void executeSql() throws SQLException {		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "작성맨");
		pstmt.setString(5, "190701");
		pstmt.setInt(6, 0);
		
		count = pstmt.executeUpdate();
		
	}

	public void registerClose() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executeProcess() throws SQLException, IOException {
		setNo();
		setTitleContent();
		divideTC();
		setSql();
		executeSql();
		executeProcess();
		
		System.out.println(count + "건 게시글이 등록되었습니다. ");
		registerClose();
	
}
}
