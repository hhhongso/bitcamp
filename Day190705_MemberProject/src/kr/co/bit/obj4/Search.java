package kr.co.bit.obj4;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Poly {
	String searchID;
	
	@Override
	protected void set() {
		try {
			System.out.print("찾는 아이디 입력: ");
			searchID = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void setSql() {
		sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
	}

	@Override
	protected void setQuery() {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchID);
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
				System.out.println("아이디를 찾았습니다. ");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void close() {		
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void process() {
		set();
		setSql();
		setQuery(); 
		execute();
		close();		
	}
	
	
	
}
