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
							
					} // S ã��
					else if (protocol.equals("U") || protocol.equals("u")) { //U ����
					
					} //U ����
					else if (protocol.equals("d") || protocol.equals("D")) { //D ����
						
					} //D ����
					else if (protocol.equals("L") || protocol.equals("l")) { // L ��ü���
						
					}// L ��ü���
				}// DB������
			} //while
		}				
}