package kr.co.bit.obj;
// 등록 후 로그인 필요 > 탈퇴, 수정, 로그아웃 
// 등록 후 로그인 없이 > 목록보기, 아이디찾기 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuterDB {
	
	public static String session;
	
	public static String id; 
	public static String pw; 
	public static String addr;
	public static String tel; 
	public static String protocol;
	
	public static String sql; 
	public static PreparedStatement pstmt; 
	public static ResultSet rs;
	
	static {
		session = null;
	}
	
	public static void main(String[] args) {
		try {
			while(true) {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
			if(conn == null) {
				System.out.println("fail");
			} else {
				System.out.println("ok! ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
					System.out.println("==== 회원관리 ====");
					System.out.println("R:회원가입 L:회원목록 S:아이디찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
					
						protocol = br.readLine();
						if(protocol.equals("R") ||protocol.equals("r")) {
							if(session!=null) {
								System.out.println("로그인중입니다.");
								continue;
							}
							System.out.print("아이디: ");
							id = br.readLine();
							System.out.print("비밀번호: ");
							pw = br.readLine();
							System.out.print("주소: ");
							addr = br.readLine();
							System.out.print("전화번호: ");
							tel = br.readLine();

							sql = "INSERT INTO MEMBER (ID, PW, ADDR, TEL) VALUES (?,?,?,?) ";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, id);
							pstmt.setString(2, pw);
							pstmt.setString(3, addr);
							pstmt.setString(4, tel);
							
							int count = pstmt.executeUpdate();
							
							if(count == 0) {
								System.out.println("등록되지 않았습니다.");
							} else {
								System.out.println(count + "건 등록되었습니다.");
								pstmt.close();
								conn.close();
							}						
						  } //R
						else if(protocol.equals("L") || protocol.equals("l")) {
							
							sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER";
							pstmt= conn.prepareStatement(sql);
							rs = pstmt.executeQuery();
							
							System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
							while(rs.next()) {
								id = rs.getString("id");
								pw = rs.getString("pw");
								addr = rs.getString("addr");
								tel = rs.getString("tel");
								System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
							}
							
							pstmt.close();
							rs.close();
							conn.close();
							
						} //L
						else if(protocol.equals("S") || protocol.equals("s")) {
							System.out.print("찾는 아이디 입력: ");
							String searchID = br.readLine();
							System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
							
							sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, searchID);
							
							rs = pstmt.executeQuery();
							while(rs.next()) {
								id = rs.getString("id");
								pw = rs.getString("pw");
								addr = rs.getString("addr");
								tel = rs.getString("tel");
								System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
								System.out.println("아이디를 찾았습니다. ");
								
							}
							rs.close();
							pstmt.close();
							conn.close();
							
						} //S
						else if(protocol.equals("D") || protocol.equals("d")) {
							System.out.print("탈퇴할 아이디 입력: ");
							session = br.readLine();
							
							sql = "DELETE FROM MEMBER WHERE ID = ?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, session);
							
							int count = pstmt.executeUpdate();
							if(count == 0) {
								System.out.println("삭제할 아이디가 없습니다. ");
							} else {						
								System.out.println("해당 아이디가 탈퇴되었습니다. ");
								session = null;	
								}
							
							pstmt.close();
							conn.close();
							
						} //D
						
					else if(protocol.equals("E") || protocol.equals("e")) {
						System.out.print("수정할 아이디 찾기: ");
						session = br.readLine();

						sql = "SELECT ID, PW, ADDR, TEL FROM MEMBER WHERE ID = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, session);
						
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
						
						System.out.print("수정할 아이디: ");
						String editID = br.readLine();
						System.out.print("수정할 비밀번호: ");
						String editPW = br.readLine();
						
						sql = "UPDATE MEMBER SET ID = ?, PW = ? WHERE ID = ?";
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setString(1, editID);
						pstmt.setString(2, editPW);	
						pstmt.setString(3, session);
						
						int count = pstmt.executeUpdate();
						
						if(count == 0) {
							System.out.println("수정 실패");
						} else {
							System.out.println(count + "건 아이디, 비밀번호 변경완료 ");
							session = editID;
						}
						pstmt.close();
						rs.close();
						conn.close();
					}// E
						else if(protocol.equals("I") || protocol.equals("i")) {
							System.out.print("아이디: ");
							String loginID = br.readLine();
							System.out.print("비밀번호: ");
							String loginPW = br.readLine();
							
							sql = "SELECT ID, PW FROM MEMBER WHERE ID = ?"; //로그인 프로세스에서는 pw는 비교하지 않는다 
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, loginID);
							//pstmt.setString(2, loginPW);
						
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
							pstmt.close();
							rs.close();
							conn.close();
						} //I
			    
					else if(protocol.equals("O") || protocol.equals("o")) {
						session = null;
						System.out.println("로그아웃 되었습니다. ");
						
						conn.close();
					} //O
					
				}// while
			}//db
		} catch (ClassNotFoundException e) {
			System.out.println("클래스없쓰요");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sQL문 예외");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("in/out 예외");
			e.printStackTrace();
		}
		

	} //main

}

