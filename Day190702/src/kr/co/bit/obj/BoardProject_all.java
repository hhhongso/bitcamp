package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardProject_all {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//DB로 바꾸면서 ArrayList & hashMap 는 필요없으니까 
		
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					while(true) { // 연결은 계속 반복				
						Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");				
						if(conn == null) {
							System.out.println("fail");
						} else { // DB연결중
							System.out.println("OK!");
							System.out.println("====게시판 작성====");
							System.out.println("R:등록  S:검색  D:삭제  U:수정  L:목록");
							String protocol = br.readLine();
							
							if(protocol.equals("R") || protocol.equals("r")) {
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
								
							} // R 등록
							else if (protocol.equals("S") || protocol.equals("s")) { // S 찾기
								System.out.println("찾는 게시글 제목 입력: ");
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
							} // S 찾기
							else if (protocol.equals("D") || protocol.equals("d")) { // D 삭제
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
							} // D 삭제
							else if (protocol.equals("U") || protocol.equals("u")) { //U 수정
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
							
							} //U 수정
							else if (protocol.equals("L") || protocol.equals("l")) { // L 전체출력
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
							}// L 전체출력
						} // DB연결중
					} //while문
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		
		
		/*
		while(true) {
			String protocol;
		
				if(protocol.equals("R") || protocol.equals("r")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					
					String titleContent= br.readLine();
					int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
					String title = titleContent.substring(0,indexI); // 문자열을 자를 때 사용하는 함수 substring
					String content = titleContent.substring(indexI+1);
					//유효성 검사 ==> 예외처리로 발전 
					if(title == null || title == "") {
						System.out.println("제목이 공백이거나 null일 때 ");
					}
					if(content == null || content == "") {
						System.out.println("내용이 공백이거나 null일 때 ");
					}
					hashMap.put("title", title);
					hashMap.put("content", content);
					
					hashMap.put("author", "김가나");
					hashMap.put("date", "190701");
					hashMap.put("readcount", "0");
					
					boardList.add(hashMap);
					System.out.println("게시글 등록 완료");
					
				} else if (protocol.equals("S") || protocol.equals("s")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("찾는 게시글 제목 입력: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
						}
					}
					
				} else if (protocol.equals("D") || protocol.equals("d")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("삭제할 게시글 제목 입력: ");
					String delTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(delTitle)) {
							boardList.remove(i);
							System.out.println("해당 게시글은 삭제되었습니다. ");
						}
					}
				} else if (protocol.equals("U") || protocol.equals("u")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("수정할 게시글 제목 입력: ");
					String searchTitle = br.readLine();
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						if(hashMap.get("title").equals(searchTitle)) {
							System.out.println("수정 전 내용:");
							System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
							System.out.println(hashMap.get("title") + "\t" 
									+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
									+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");					
							
							System.out.println(" 해당 게시글이 검색되었습니다. ");	
						}
						
						System.out.println("수정할 제목|내용 입력: ");
						String titleContent = br.readLine();
						int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
						String title = titleContent.substring(0,indexI); // 문자열을 자를 때 사용하는 함수 substring
						String content = titleContent.substring(indexI+1);
						
						hashMap.put("title", title);
						hashMap.put("content", content);
						boardList.set(i, hashMap);
						
						
//							hashMap.replace("title", title);
//							hashMap.replace("content", content);
//							
//							hashMap.replace("author", "ABC");
//							hashMap.replace("date", "181231");
//							hashMap.replace("readcount", "100");
//							//boardList.set(i, hashMap);
						System.out.println("게시글 수정 완료");
						
					}
					
					
				} else if (protocol.equals("L") || protocol.equals("l")) {
					HashMap<String, String> hashMap = new HashMap<String, String>();
					System.out.println("==== 전체출력 ====");
					System.out.println("제목 \t 내용 \t 작성자  \t 날짜 \t 조회수");
					for(int i = 0; i < boardList.size(); i++) {
						hashMap = boardList.get(i);
						System.out.println(hashMap.get("title") + "\t" 
								+ hashMap.get("content") + "\t" + hashMap.get("author") + "\t" 
								+hashMap.get("date") + "\t" + hashMap.get("readcount") + "\t");
						
						
					}
				}
			
			
			
		} // while문
		*/

	}

}
