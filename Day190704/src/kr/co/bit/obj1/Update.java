package kr.co.bit.obj1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends Board {

	private String searchTitle; 	
	
	public Update() {
	}
		
	public void updateTitle() throws IOException {
		System.out.println("수정할 게시글 제목 입력: ");
		searchTitle= br.readLine();
	}

			//이거까지 override를 한다면, boardSql은 실행되지 않는 건가? 
	public void updateSql() {
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
	}
	
	@Override
	public void boardQuery() throws SQLException{
		conn = getConnection();
		updateTitle();
		boardTitle();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchTitle);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readCount = rs.getInt("readcount");
		}
		
	}
	
	public void updateProcess() throws IOException {
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			
		
		setTitleContent();
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);
		
		updateSql();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, searchTitle);
		
		count = pstmt.executeUpdate();
		System.out.println(count + "건 게시글이 수정되었습니다.");
		
	}

	@Override
	public void boardClose() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void boardSql() {	
		sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
	}
}

