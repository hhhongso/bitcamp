package kr.co.bit.obj1;

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
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			}
			while(true) {
				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(protocol.equals("R") || protocol.equals("r")) {
						try {
							BoardFunction.register(br, conn);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if (protocol.equals("S") || protocol.equals("s")) { // S 찾기
							try {
								BoardFunction.search(br, conn);
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} // S 찾기
					else if (protocol.equals("U") || protocol.equals("u")) { //U 수정
						try {
							BoardFunction.update(br, conn);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} //U 수정
					else if (protocol.equals("d") || protocol.equals("D")) { //D 수정
						try {
							BoardFunction.delete(br, conn);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //D 수정
					else if (protocol.equals("L") || protocol.equals("l")) { // L 전체출력
						try {
							BoardFunction.printList(conn);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}// L 전체출력
				}// DB연결중
			} //while
		}				
}