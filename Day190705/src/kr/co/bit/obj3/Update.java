package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Function {
	public void UpdateProcess() {
		try {
			System.out.print("수정할 아이디 찾기: ");
			session = br.readLine();
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");

			sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, session);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
				System.out.println("아이디를 찾았습니다. ");
			}	
			
			System.out.print("수정할 아이디: ");
			String editID = br.readLine();
			System.out.print("수정할 비밀번호: ");
			String editPW = br.readLine();
			
			sql = "UPDATE MEMBER SET ID = ?, PW = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, editID);
			pstmt.setString(2, editPW);	
			pstmt.setString(3, session);
			
			int count = pstmt.executeUpdate();
			
			if(count == 0) {
				System.out.println("수정 실패");
			} else {
				System.out.println(count + "건 아이디, 비밀번호 변경완료 ");
				session = editID;
			}
			pstmt.close();
			rs.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
