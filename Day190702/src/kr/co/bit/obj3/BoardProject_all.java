package kr.co.bit.obj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardProject_all {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Register register = new Register();
		
			while(true) {
				Connection conn = null;
				try {
					conn = Register.getConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if(conn == null) {
					System.out.println("fail");
				} else { // DB연결중
					System.out.println("OK!");
					System.out.println("====게시판 작성====");
					System.out.println("R:등록  S:검색  D:삭제  U:수정  L:목록");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					if(protocol.equals("R") || protocol.equals("r")) {
							try {
								register.registerProcess();
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}	
					}
					else if (protocol.equals("S") || protocol.equals("s")) { // S 찾기
							
					} // S 찾기
					else if (protocol.equals("U") || protocol.equals("u")) { //U 수정
					
					} //U 수정
					else if (protocol.equals("d") || protocol.equals("D")) { //D 수정
						
					} //D 수정
					else if (protocol.equals("L") || protocol.equals("l")) { // L 전체출력
						
					}// L 전체출력
				}// DB연결중
			} //while
		}				
}