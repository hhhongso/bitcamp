package kr.co.bit.obj5;

import java.io.IOException;
import java.sql.SQLException;

public class Search extends Function implements MemberInter, SetInter{
	String searchID;
	
	public Search() {
		searchID = null;
	}
	
	@Override
	public void set() throws IOException {
		
			System.out.print("찾는 아이디 입력: ");
			searchID = br.readLine();
	
	}

	@Override
	public void setSql() {
		sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
	}

	@Override
	public void setQuery() throws SQLException{
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchID);
		
		
	}

	@Override
	public void execute() throws SQLException{
		
			rs = pstmt.executeQuery();
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
			
			while(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
				System.out.println("아이디를 찾았습니다. ");
				
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
