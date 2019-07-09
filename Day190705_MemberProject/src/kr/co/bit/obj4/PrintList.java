package kr.co.bit.obj4;

import java.sql.SQLException;

public class PrintList extends Poly {
	@Override
	protected void setSql() {
		sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER";
	}
	
	@Override
	protected void setQuery() {
		try {
			pstmt= conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void execute() {
		try {
			rs = pstmt.executeQuery();
			
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
			while(rs.next()) {			
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void close() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void process() {
		setSql();
		setQuery();
		execute();
		close();
	}
}
