package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


public class Board_Executer {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Register register = new Register();
		PrintList printList = new PrintList();
		Delete delete = new Delete();
		Search search = new Search();
		Update update = new Update();
		
		BoardPoly bp = new BoardPoly();
		
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
					System.out.println("========�Խ��� ����========");
					System.out.println("R:���  S:�˻�  D:����  U:����  L:��ü���");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					if(protocol.equals("R") || protocol.equals("r")) {
							try {
								bp.boardSQL(register);
								bp.boardQUERY(register);
								register.boardProcess();
								bp.boardCLOSE(register);
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}	
					}
					else if (protocol.equals("S") || protocol.equals("s")) { // S
							try {
								bp.boardSQL(search);
								bp.boardQUERY(search);
								search.boardProcess();
								bp.boardCLOSE(search);
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} // S 
					else if (protocol.equals("U") || protocol.equals("u")) { //U 
						try {
							bp.boardSQL(update);
							bp.boardQUERY(update);
							update.boardProcess();
							bp.boardCLOSE(update);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //U 
					else if (protocol.equals("d") || protocol.equals("D")) { //D 
						try {
							bp.boardSQL(delete);
							bp.boardQUERY(delete);
							delete.boardProcess();
							bp.boardCLOSE(delete);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //D 
					else if (protocol.equals("L") || protocol.equals("l")) { // L 
						try {
							bp.boardSQL(printList);
							bp.boardQUERY(printList);
							printList.boardProcess();
							bp.boardCLOSE(printList);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}// L 
				}// DB
			} //while
		}				
}