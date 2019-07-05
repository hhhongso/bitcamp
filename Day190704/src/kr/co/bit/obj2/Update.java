package kr.co.bit.obj2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends Board implements BoardInter{

	private String searchTitle; 	
	
	public Update() {
	}
		
	public void updateTitle() throws IOException {
		System.out.println("������ �Խñ� ���� �Է�: ");
		searchTitle= br.readLine();
	}

			//�̰ű��� override�� �Ѵٸ�, boardSql�� ������� �ʴ� �ǰ�? 
	public void updateSql() {
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
	}
	
	@Override
	public void boardQuery() throws SQLException{
		conn = getConnection();
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
	
	public void updateQuery() throws SQLException {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, searchTitle);
		
		count = pstmt.executeUpdate();
	}
	
	@Override
	public void boardProcess() throws IOException, SQLException {
		updateTitle();
		boardTitle();	
		System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			
		
		setTitleContent();
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI+1);
		
		updateSql();
		updateQuery();
		System.out.println(count + "�� �Խñ��� �����Ǿ����ϴ�.");
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

