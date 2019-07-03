package kr.co.bit.obj1;

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
		System.out.println("������ �Խñ� ���� �Է�: ");								
		delTitle = Register.br.readLine();
		
	}
	public void deleteSql() {
		sql = "DELETE FROM BOARD WHERE TITLE = ? ";
		
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
		conn = Register.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);

		count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("������ �Խñ��� �����ϴ�. ");
		} else {
		System.out.println(count + "�� �Խñ��� ���� �Ǿ����ϴ�. ");
		
		deleteClose();
		}
	}
}
