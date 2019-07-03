package kr.co.bit.obj2;

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
		BoardFunction bf = new BoardFunction();
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
				} else { // DB������
					System.out.println("OK!");
					System.out.println("====�Խ��� �ۼ�====");
					System.out.println("R:���  S:�˻�  D:����  U:����  L:���");
					String protocol = null;
					try {
						protocol = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(protocol.equals("R") || protocol.equals("r")) {
						try {
							bf.register(br, conn);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if (protocol.equals("S") || protocol.equals("s")) { // S ã��
							try {
								bf.search(br, conn);
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					} // S ã��
					else if (protocol.equals("U") || protocol.equals("u")) { //U ����
						try {
							bf.update(br, conn);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} //U ����
					else if (protocol.equals("d") || protocol.equals("D")) { //D ����
						try {
							bf.delete(br, conn);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} //D ����
					else if (protocol.equals("L") || protocol.equals("l")) { // L ��ü���
						try {
							bf.printList(conn);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}// L ��ü���
				}// DB������
			} //while
		}				
}