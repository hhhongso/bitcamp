package kr.co.bit.obj5_done;

import java.sql.SQLException;

public class Logout extends Function implements LoginInter{
	@Override
	public void isLogin() {
		if(session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		} else {
			execute();
		}
	}
	
//더조은 방법이 없을까 
	public void execute() {
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
