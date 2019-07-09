package kr.co.bit.obj4;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Poly{
	@Override
	protected void set() {
		try {
			System.out.print("아이디: ");
			id = br.readLine();
			System.out.print("비밀번호: ");
			pw = br.readLine();
			System.out.print("주소: ");
			addr = br.readLine();
			System.out.print("전화번호: ");
			tel = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void setSql() {
		sql = "INSERT INTO MEMBER (ID, PW, ADDR, TEL) VALUES (?,?,?,?)";
	}
	
	@Override
	protected void setQuery() {
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	protected void execute() {
		try {
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("등록되지 않았습니다.");
			} else {
				System.out.println(count + "건 등록되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void close() {
		try {
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
