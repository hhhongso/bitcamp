package kr.co.bit.obj4;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Poly {
	
	private String editID;
	private String editPW;
	
	@Override
	protected void isLogin() {
		if(session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		}
	}
	
	@Override
	protected void setSql() {
		sql = "UPDATE MEMBER SET ID = ?, PW = ? WHERE ID = ?";
	}

	@Override
	protected void setQuery() {
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, editID);
			pstmt.setString(2, editPW);	
			pstmt.setString(3, session);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void execute() {
		try {
			int count = pstmt.executeUpdate();
			if(count != 0) {				
				System.out.println(count + "건 아이디, 비밀번호 변경완료 ");
				session = editID;
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
		isLogin();
		setSql();
		setQuery();
		execute();		
		close();
		
	}
	
}
