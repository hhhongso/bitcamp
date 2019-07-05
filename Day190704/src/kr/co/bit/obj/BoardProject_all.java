package kr.co.bit.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


public class BoardProject_all {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Register register = new Register();
		PrintList printList = new PrintList();
		Delete delete = new Delete();
		Search search = new Search();
		Update update = new Update();
		
			while(true) {
				Connection conn = null;
				try {
					conn = Register.getConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if(conn == null) {
					System.out.println("fail");
				} else { // DB
					System.out.println("OK!");
					System.out.println("====게시판 관리====");
					System.out.println("R:등록  S:검색  D:삭제  U:수정  L:전체출력");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					if(protocol.equals("R") || protocol.equals("r")) {
							try {
								register.executeProcess();
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}	
					}
					else if (protocol.equals("S") || protocol.equals("s")) { // S
							try {
								search.executeProcess();
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} // S 
					else if (protocol.equals("U") || protocol.equals("u")) { //U 
						try {
							update.updateProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //U 
					else if (protocol.equals("d") || protocol.equals("D")) { //D 
						try {
							delete.deleteProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //D 
					else if (protocol.equals("L") || protocol.equals("l")) { // L 
						try {
							printList.printListProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}// L 
				}// DB
			} //while
		}				
}