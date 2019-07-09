package kr.co.bit.obj4;

import java.sql.SQLException;

public class Logout extends Poly {
	@Override
	protected void isLogin() {
		if(session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		} else {
			execute();
		}
	}
	
	@Override
	protected void execute() {
		try {
			System.out.println("로그아웃 되었습니다. ");
			session = null;
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void process() {
		isLogin(); 
		
	
	}
}
