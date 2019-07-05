package kr.co.bit.obj;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Board {
	
	private String delTitle;
	
	public Delete() {
		delTitle = null;
	}
	
	public void deleteTitle() throws IOException{
		System.out.println("������ �Խñ� ���� �Է�: ");								
		delTitle = br.readLine();
		
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
		
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);

		count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("������ �Խñ��� �����ϴ�. ");
		} else {
		System.out.println(count + "�� �Խñ��� �����Ǿ����ϴ�. ");
		
		deleteClose();
		}
	}
}
