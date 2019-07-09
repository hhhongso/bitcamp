package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends Function {
	public void LoginProcess() {
		try {
			System.out.print("아이디: ");
			String loginID = br.readLine();
			System.out.print("비밀번호: ");
			String loginPW = br.readLine();
			
			sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?"; //로그인 프로세스에서는 pw는 비교하지 않는다 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginID);
			//pstmt.setString(2, loginPW);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {								
				loginID = rs.getString("id");
				pw = rs.getString("pw");
				
				if(pw.equals(loginPW)) {									
					System.out.println("로그인 성공");
					session = loginID;
				} else if(!pw.equals(loginPW)) {
					System.out.println("비번 오류");								
					return;
				}
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
