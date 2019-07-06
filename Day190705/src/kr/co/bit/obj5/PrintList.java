package kr.co.bit.obj5;

import java.sql.SQLException;

public class PrintList extends Function implements MemberInter{
	@Override
	public void setSql() {
		sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER";
	}
	
	@Override
	public void setQuery() throws SQLException {
		
			pstmt= conn.prepareStatement(sql);
		
		
	}
	
	@Override
	public void execute() throws SQLException {
	
			rs = pstmt.executeQuery();
			
			System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
			while(rs.next()) {			
				id = rs.getString("id");
				pw = rs.getString("pw");
				addr = rs.getString("addr");
				tel = rs.getString("tel");
				System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
			}
		
	}
	
	@Override
	public void close() throws SQLException {
		
			pstmt.close();
			rs.close();
			conn.close();
	
	}
	
	
	public void process() throws SQLException {
		setSql();
		setQuery();
		execute();
		close();
	}

}
