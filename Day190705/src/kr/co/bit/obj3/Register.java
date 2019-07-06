package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Function {

	protected void RegisterProcess() {
		try {
			System.out.print("아이디: ");
			id = br.readLine();
			System.out.print("비밀번호: ");
			pw = br.readLine();
			System.out.print("주소: ");
			addr = br.readLine();
			System.out.print("전화번호: ");
			tel = br.readLine();


sql = "INSERT INTO MEMBER (ID, PW, ADDR, TEL) VALUES (?,?,?,?) ";


			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			
				int count = pstmt.executeUpdate();
				if(count == 0) {
					System.out.println("등록되지 않았습니다.");
				} else {
					System.out.println(count + "건 등록되었습니다.");
					pstmt.close();
					conn.close();
				}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
