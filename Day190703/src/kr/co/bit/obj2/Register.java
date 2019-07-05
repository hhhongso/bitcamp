package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Board {

	private String titleContent; 
	private int indexI; 
	
	public Register() {
		//�ʱ�ȭ: 0/null������ �ڵ� �ʱ�ȭ
	}
	 
	public void setNo() throws IOException {
		System.out.println("�Խñ� ��ȣ �Է�: ");
		no = Integer.parseInt(br.readLine()); //readline >> int �� ����ȯ
	}

	public void setBoard() throws IOException {
		System.out.println("����|����: ");		
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
		pstmt.setString(4, "�谡��");
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
	
		System.out.println(count + "�� �Խñ��� ��� �Ǿ����ϴ�. ");
		setClose();
}
}
