package kr.co.bit.obj3;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Function {
	public void SearchProcess() {		
		try {
			System.out.print("찾는 아이디 입력: ");
			String searchID = br.readLine();
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
			
			sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchID);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
				System.out.println("아이디를 찾았습니다. ");
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
