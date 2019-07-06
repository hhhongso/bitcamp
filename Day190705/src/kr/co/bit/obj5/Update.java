package kr.co.bit.obj5;

import java.io.IOException;
import java.sql.SQLException;

public class Update extends Function implements LoginInter, SetInter, MemberInter {
	
	private String editID;
	private String editPW;

	public Update() {
		editID = null;		editPW = null;
	}
	@Override
	public void isLogin() {
		if (session == null) {
			System.out.println("로그인 중이 아닙니다. ");
		} else {
			try {
				set();
				setSql();
				setQuery();
				execute();
				close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}	
	
	@Override
	public void set() throws IOException {
		System.out.print("수정할 아이디: ");
		editID = br.readLine();
		System.out.print("수정할 비밀번호: ");
		editPW = br.readLine();
	}

	@Override
	public void setSql() {
		sql = "UPDATE MEMBER SET ID = ?, PW = ? WHERE ID = ?";
	}

	@Override
	public void setQuery() throws SQLException {
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, editID);
		pstmt.setString(2, editPW);
		pstmt.setString(3, session);
	}

	@Override
	public void execute() throws SQLException {
		int count = pstmt.executeUpdate();
		if (count != 0) {
			System.out.println(count + "건 아이디, 비밀번호 변경완료 ");
			session = editID;
		}

	}

	@Override
	public void close() throws SQLException {
		pstmt.close();
		conn.close();

	}

	public void process() {
		isLogin();
		
	}
	

}
