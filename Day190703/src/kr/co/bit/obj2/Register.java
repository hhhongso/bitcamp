package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board {

	private String titleContent; 
	private int indexI; 
	
	public Register() {
		//초기화: 0/null값으로 자동 초기화
	}
	 
	public void setNo() throws IOException {
		System.out.println("게시글 번호 입력: ");
		no = Integer.parseInt(br.readLine()); //readline >> int 로 형변환
	}

	public void setBoard() throws IOException {
		System.out.println("제목|내용: ");		
		titleContent = br.readLine();
	}
	
	public void divideTC() {		
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);		
	}
	
	public void setSql() {
		sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT) VALUES (?, ?, ?, ?, ?, ?)";
	}
	
	public void setQuery() throws SQLException {		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "김가나");
		pstmt.setString(5, "190701");
		pstmt.setInt(6, 0);
		
		count = pstmt.executeUpdate();
		
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
		setNo();
		setBoard();
		divideTC();
		setSql();
		setQuery();
	
		System.out.println(count + "건 게시글이 등록 되었습니다. ");
		setClose();
}
}
