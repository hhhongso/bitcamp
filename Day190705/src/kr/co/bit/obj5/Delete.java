package kr.co.bit.obj5;
// 탈퇴는 로그인인 중에서 진행되어야 함 > set 필요없음.  
//로그인 상태가 아니라면, '로그인 중이 아닙니다.'

import java.sql.SQLException;

public class Delete extends Function implements LoginInter, MemberInter{
	
	@Override
	public void isLogin() {
		if(session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		}
	}

	@Override
	public void setSql() {
		sql = "DELETE FROM MEMBER WHERE ID = ?";
	}

	@Override
	public void setQuery() throws SQLException {
		pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, session);
		
	}

	@Override
	public void execute() throws SQLException {
		
			int count = pstmt.executeUpdate();
			if(count != 0) {					
				System.out.println("해당 아이디가 탈퇴되었습니다. ");
				session = null;	
				}
		
	}

	@Override
	public void close() throws SQLException {
	
			pstmt.close();
			conn.close();
		
	}

	
	public void process() throws SQLException {
		//로그인 상태 여부를 먼저 확인 
		
		isLogin();
		setSql();
		setQuery();
		execute();
		close();
		
	}

	
}
