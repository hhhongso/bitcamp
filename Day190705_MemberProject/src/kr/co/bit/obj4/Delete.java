package kr.co.bit.obj4;
// 탈퇴는 로그인인 중에서 진행되어야 함 > set 필요없음.  
//로그인 상태가 아니라면, '로그인 중이 아닙니다.'

import java.io.IOException;
import java.sql.SQLException;

public class Delete extends Poly {
	
	@Override
	protected void isLogin() {
		if(session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		}
	}

	@Override
	protected void setSql() {
		sql = "DELETE FROM MEMBER WHERE ID = ?";
	}

	@Override
	protected void setQuery() {
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, session);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void execute() {
		try {
			int count = pstmt.executeUpdate();
			if(count != 0) {					
				System.out.println("해당 아이디가 탈퇴되었습니다. ");
				session = null;	
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
		//로그인 상태 여부를 먼저 확인 
		
		isLogin();
		set();
		setSql();
		setQuery();
		execute();
		close();
		
	}

	
}
