package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardFunction {
																	//����ó���� main method�� ������. ClassnotfoundE�� �ε��� �� ����ϰ� ������ ���̴�, �Լ������� X
	
	
	public void delete(BufferedReader br, Connection conn) throws SQLException, IOException {
		System.out.println("������ �Խñ� ���� �Է�: ");								
		String delTitle = br.readLine();
		String sql = "DELETE FROM BOARD WHERE TITLE = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);

		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("������ �Խñ��� �����ϴ�. ");
		} else {
		System.out.println(count + "�� �Խñ��� ���� �Ǿ����ϴ�. ");
		
		pstmt.close();
		conn.close();
		}
	}
	public void update(BufferedReader br, Connection conn) throws SQLException, IOException {
		System.out.println("������ �Խñ� ���� �Է�: ");
		String searchTitle= br.readLine();
		
		System.out.println("���� �� �����Դϴ�. ");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchTitle);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readcount");
			
			System.out.println("��ȣ" + "\t" + "����" + "\t" +"����" + "\t" +"�ۼ���" + "\t" +"��¥" + "\t" +"��ȸ��");
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
		}
		
		System.out.println("�Խñ��� ����|���� �����ϱ�: ");
		String upTitleContent = br.readLine();
		int indexI = upTitleContent.indexOf("|");
		String title = upTitleContent.substring(0, indexI);
		String content = upTitleContent.substring(indexI+1);
		
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, searchTitle);
		
		int count = pstmt.executeUpdate();
		System.out.println(count + "�� �Խñ��� �����Ǿ����ϴ�.");
		
		pstmt.close();
		conn.close();
	
	}																						//Ű���� �Ƚ����ϱ� IOE�� �ʿ���� 
	public void printList(Connection conn) throws ClassNotFoundException, SQLException {
		System.out.println("�Խñ� ��ü ���");
		System.out.println("��ȣ \t ���� \t ���� \t �ۼ��� \t ��¥ \t ��ȸ��");
		
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD"; //select * from board >> ��� �׸� �� ��������
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readcount");
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			
		}
		pstmt.close();
		conn.close();
	}
}