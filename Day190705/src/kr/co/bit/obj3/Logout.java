package kr.co.bit.obj3;

import java.sql.SQLException;

public class Logout extends Function{
	public void LogoutProcess() {
		try {
			session = null;
			System.out.println("로그아웃 되었습니다. ");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
