package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Board {
	
	private String searchTitle; 
	
	public Search() {
		searchTitle = null;
	}
	
	public void setBoard() throws IOException {
		System.out.println("ã�� �Խñ� ���� �Է�: ");
		searchTitle = Register.br.readLine();
	}
	
	public void setTitle() {
		System.out.println("��ȣ \t ���� \t ���� \t �ۼ��� \t ��¥ \t ��ȸ��");
		
	}
	
	@Override
	public void boardQuery() throws SQLException {
		conn = getConnection();
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
	
	@Override
	public void boardProcess() throws IOException {
		setBoard();
		setTitle();
				
		System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);				
	}

	@Override
	public void boardClose() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void boardSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
	}
		
	
}
