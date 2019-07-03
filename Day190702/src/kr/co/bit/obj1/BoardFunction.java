package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardFunction {
																	//예외처리를 main method로 던지기. ClassnotfoundE는 로드할 때 사용하고 끝나는 것이니, 함수에서는 X
	public static void register(BufferedReader br, Connection conn) throws SQLException, IOException {
	
			System.out.println("게시글 번호 입력: ");
			int no = Integer.parseInt(br.readLine()); //readline >> int 로 형변환
			System.out.println("제목|내용: ");
			String titleContent = br.readLine();
			int indexI = titleContent.indexOf("|");
			String title = titleContent.substring(0, indexI);
			String content = titleContent.substring(indexI+1);
			
			String sql = "INSERT INTO BOARD (NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, "김가나");
			pstmt.setString(5, "190701");
			pstmt.setInt(6, 0);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "건 게시글이 등록 되었습니다. ");
			
			pstmt.close();
			conn.close();
		
	}
	public static void search(BufferedReader br, Connection conn) throws SQLException, IOException {
		System.out.println("찾는 게시글 제목 입력: ");
		try {
			String searchTitle = br.readLine();
			String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTitle);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				int readCount = rs.getInt("readcount");
				
				System.out.println("번호" + "\t" + "제목" + "\t" +"내용" + "\t" +"작성자" + "\t" +"날짜" + "\t" +"조회수");
				System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			}
			
			pstmt.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void delete(BufferedReader br, Connection conn) throws SQLException, IOException {
		System.out.println("삭제할 게시글 제목 입력: ");								
		String delTitle = br.readLine();
		String sql = "DELETE FROM BOARD WHERE TITLE = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, delTitle);

		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("삭제할 게시글이 없습니다. ");
		} else {
		System.out.println(count + "건 게시글이 삭제 되었습니다. ");
		
		pstmt.close();
		conn.close();
		}
	}
	public static void update(BufferedReader br, Connection conn) throws SQLException, IOException {
		System.out.println("수정할 게시글 제목 입력: ");
		String searchTitle= br.readLine();
		
		System.out.println("수정 전 내용입니다. ");
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD WHERE TITLE = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchTitle);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readcount");
			
			System.out.println("번호" + "\t" + "제목" + "\t" +"내용" + "\t" +"작성자" + "\t" +"날짜" + "\t" +"조회수");
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
		}
		
		System.out.println("게시글의 제목|내용 수정하기: ");
		String upTitleContent = br.readLine();
		int indexI = upTitleContent.indexOf("|");
		String title = upTitleContent.substring(0, indexI);
		String content = upTitleContent.substring(indexI+1);
		
		sql= "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, searchTitle);
		
		int count = pstmt.executeUpdate();
		System.out.println(count + "건 게시글이 수정되었습니다.");
		
		pstmt.close();
		conn.close();
	
	}																						//키보드 안썼으니까 IOE는 필요없음 
	public static void printList(Connection conn) throws ClassNotFoundException, SQLException {
		System.out.println("게시글 전체 출력");
		System.out.println("번호 \t 제목 \t 내용 \t 작성자 \t 날짜 \t 조회수");
		
		String sql = "SELECT NO, TITLE, CONTENT, AUTHOR, NAL, READCOUNT FROM BOARD"; //select * from board >> 모든 항목 다 가져오기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readCount = rs.getInt("readcount");
			
			System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readCount);
			
		}
		pstmt.close();
		conn.close();
	}
}
