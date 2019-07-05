package kr.co.bit.obj1;

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
	
	@Override
	public void boardQuery() throws SQLException {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);
		count = pstmt.executeUpdate();
	}
	
	
	@Override
	public void boardProcess() throws IOException {
		deleteTitle();	
		if(count == 0) {
			System.out.println("������ �Խñ��� �����ϴ�. ");
		} else {
		System.out.println(count + "�� �Խñ��� �����Ǿ����ϴ�. ");
		}
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
		sql = "DELETE FROM BOARD WHERE TITLE = ? ";
	}
}
