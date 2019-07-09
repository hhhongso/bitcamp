package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Function {
	public void DeleteProcess() {
		try {
			System.out.print("탈퇴할 아이디 입력: ");
			session = br.readLine();
			
			sql = "DELETE FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, session);
			
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("삭제할 아이디가 없습니다. ");
			} else {						
				System.out.println("해당 아이디가 탈퇴되었습니다. ");
				session = null;	
				}
			
			pstmt.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
