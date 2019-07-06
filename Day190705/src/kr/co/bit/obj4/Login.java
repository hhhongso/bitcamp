package kr.co.bit.obj4;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends Poly{
	private String loginID;
	private String loginPW;
	
	@Override
	protected void set() {
		try {
			System.out.print("아이디: ");
			loginID = br.readLine();
			System.out.print("비밀번호: ");
			loginPW = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void setSql() {
		sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?"; //로그인 프로세스에서는 pw는 비교하지 않는다 
	}

	@Override
	protected void setQuery() {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void execute() {
		try {
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
