package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {

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
	
	private String upTitleContent;
	private int indexI; 
	private int count; 
	
	public Update() {
		conn = null; 	searchTitle = null;		sql = null;
	}
		
	public void updateTitle() throws IOException {
		System.out.println("������ �Խñ� ���� �Է�: ");
		searchTitle= Register.br.readLine();
	}

	public void beforeUpdate() {
		System.out.println("���� �� �����Դϴ�. ");
		System.out.println("��ȣ" + "\t" + "����" + "\t" +"����" + "\t" +"�ۼ���" + "\t" +"��¥" + "\t" +"��ȸ��");		
	}
	public void updateSearchSql() {	
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
	}

	public void updateTitleContent() throws IOException {
		System.out.println("�Խñ��� ����|���� �����ϱ�: ");
		upTitleContent = Register.br.readLine();
	}
	
	public void updateSql() {
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
	}
	
	public void updateClose() {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
		}
	}
	
	public void updateProcess() throws SQLException, IOException {
		conn = Register.getConnection();
		updateTitle();
		beforeUpdate();
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
		
		updateTitleContent();
		
		indexI = upTitleContent.indexOf("|");
		title = upTitleContent.substring(0, indexI);
		content = upTitleContent.substring(indexI+1);
		
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

