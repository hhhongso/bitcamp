package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Board {
	
	private String searchTitle; 
	
	public Search() { 
	}
	
	public void setBoard() throws IOException {
		System.out.println("ã�� �Խñ� ���� �Է�: ");
		searchTitle = Register.br.readLine();
	}
	
	public void setTitle() {
		System.out.println("��ȣ" + "\t" + "����" + "\t" +"����" + "\t" +"�ۼ���" + "\t" +"��¥" + "\t" +"��ȸ��");
		
	}
	
	public void setSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
		
	}
	
	public void setQuery() throws SQLException {
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
		setQuery();
		
		System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
		setClose();
		}

}