package kr.co.bit.obj3;

import java.sql.SQLException;

public class PrintList extends Function{
	protected void setSql() {
		sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER";
	}
	
	public void PrintListProcess() {

		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
			while(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
			}
			
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
