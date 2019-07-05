package kr.co.bit.obj;

import java.sql.SQLException;

public class PrintList extends Board {
	
	public PrintList() {
		super();
	}
	
	public void boardSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD ORDER BY NO ASC"; //select * from board >> 占쏙옙占� 占쌓몌옙 占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
		
	}
	
	public void printListClose() { //占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싱띰옙占�, throws 占싹몌옙 main占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 
		try {
			pstmt.close();
			conn.close();
			rs.close(); //인터페이스는 전부 다 종료시켜 주어야 
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void printListProcess() throws SQLException {
		boardTitle();
		boardSql();
		
		conn = getConnection(); //상속받았으니까 Board.getConnection() 이라고 안해도 된다 
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readcount");
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);	
		}
		printListClose();
	}
}
