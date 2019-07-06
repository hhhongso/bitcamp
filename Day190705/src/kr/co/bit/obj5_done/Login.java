package kr.co.bit.obj5_done;

import java.io.IOException;
import java.sql.SQLException;

public class Login extends Function implements MemberInter, SetInter{
	private String loginID;
	private String loginPW;
	
	public Login() {
		loginID = null;		loginPW = null;
	}
	
	@Override
	public void set() throws IOException{
		
			System.out.print("아이디: ");
			loginID = br.readLine();
			System.out.print("비밀번호: ");
			loginPW = br.readLine();
	
	}

	@Override
	public void setSql() {
		sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?"; //로그인 프로세스에서는 pw는 비교하지 않는다 
	}

	@Override
	public void setQuery() throws SQLException{
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginID);
		

	}

	@Override
	public void execute() throws SQLException {
		
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
		
	}

	@Override
	public void close() throws SQLException{
		
			rs.close();
			pstmt.close();
			conn.close();
			
	}


	public void process() throws SQLException, IOException{
		set();
		setSql();
		setQuery();
		execute();
		close();
	}

}
