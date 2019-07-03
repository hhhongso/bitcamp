package kr.co.bit.obj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


public class BoardProject_all extends Board {

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
				} else { // DB������
					System.out.println("OK!");
					System.out.println("====�Խ��� �ۼ�====");
					System.out.println("R:���  S:�˻�  D:����  U:����  L:���");
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
					else if (protocol.equals("S") || protocol.equals("s")) { // S ã��
							try {
								search.searchProcess();
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} // S ã��
					else if (protocol.equals("U") || protocol.equals("u")) { //U ����
						try {
							update.updateProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //U ����
					else if (protocol.equals("d") || protocol.equals("D")) { //D ����
						try {
							delete.deleteProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //D ����
					else if (protocol.equals("L") || protocol.equals("l")) { // L ��ü���
						try {
							printList.printListProcess();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}// L ��ü���
				}// DB������
			} //while
		}				
}