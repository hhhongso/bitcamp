package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.SQLException;

public class PrintList extends Board {
	
	public PrintList() {
		super();
	}

	@Override
	public void boardQuery() throws SQLException {
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
	}
	
	@Override
	public void boardProcess() throws IOException {
		boardTitle();
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);	
		}
	}

	@Override
	public void boardClose() {
		try {
			pstmt.close();
			conn.close();
			rs.close(); //인터페이스는 전부 다 종료시켜 주어야 
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void boardSql() {
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD ORDER BY NO ASC"; //select * from board >> 占쏙옙占� 占쌓몌옙 占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
	}
	
}
