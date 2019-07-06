package kr.co.bit.obj5;

import java.io.IOException;
import java.sql.SQLException;

public class Register extends Function implements MemberInter, SetInter{
	@Override
	public void set() throws IOException{
	
			System.out.print("아이디: ");
			id = br.readLine();
			System.out.print("비밀번호: ");
			pw = br.readLine();
			System.out.print("주소: ");
			addr = br.readLine();
			System.out.print("전화번호: ");
			tel = br.readLine();
	
	}
	
	@Override
	public void setSql() {
		sql = "INSERT INTO MEMBER (ID, PW, ADDR, TEL) VALUES (?,?,?,?)";
	}
	
	@Override
	public void setQuery() throws SQLException {
		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			
	}
	
	@Override
	public void execute() throws SQLException {
	
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("등록되지 않았습니다.");
			} else {
				System.out.println(count + "건 등록되었습니다.");
			}
		
	}
	
	@Override
	public void close() throws SQLException {
	
			pstmt.close();
			conn.close();
		
	}
	

	public void process() throws SQLException, IOException {			
			set();
			setSql();
			setQuery();
			execute();
			close();	
	}

	
}
