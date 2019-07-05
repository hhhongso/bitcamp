package kr.co.bit.obj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends Board {

	private String searchTitle; 	
	
	public Update() {
	}
		
	public void updateTitle() throws IOException {
		System.out.println("������ �Խñ� ���� �Է�: ");
		searchTitle= br.readLine();
	}

//	public void beforeUpdate() {
//		System.out.println("���� �� �Խñ��Դϴ�. ");
//		System.out.println("��ȣ \t ���� \t ���� \t �ۼ��� \t ��¥ \t ��ȸ��");		
//	}
	public void updateSearchSql() {	
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
	}

//	public void updateTitleContent() throws IOException {
//		System.out.println("����|����: ");
//		titleContent = Register.br.readLine();
//	}
	
	public void updateSql() {
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
	}
	
	public void updateClose() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
		}
	}
	
	public void updateProcess() throws SQLException, IOException {
		conn = getConnection();
		updateTitle();
		boardTitle();
		updateSearchSql();
		
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
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
		}
		
		
		setTitleContent();
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);
		
		updateSql();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, searchTitle);
		
		count = pstmt.executeUpdate();
		System.out.println(count + "�� �Խñ��� �����Ǿ����ϴ�.");
		
		updateClose();
	}			
}

