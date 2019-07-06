package kr.co.bit.obj1;
// 등록 후 로그인 필요 > 탈퇴, 수정, 로그아웃 
// 등록 후 로그인 없이 > 목록보기, 아이디찾기 

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuterDB {

	public static String protocol;

	
	static {
	}
	
	public static void main(String[] args) {
		Function func = new Function();
		try {
			while(true) {
			Class.forName("oracle.jdbc.OracleDriver");
			Function.conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
			if(Function.conn == null) {
				System.out.println("fail");
			} else {
				System.out.println("ok! ");
			
				
					System.out.println("==== 회원관리 ====");
					System.out.println("R:회원가입 L:회원목록 S:아이디찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
					
						protocol = Function.br.readLine();
						if(protocol.equals("R") ||protocol.equals("r")) {
							if(Function.session!=null) {
								System.out.println("로그인중입니다.");
								continue;
							}
							Function.Register();
						  } //R
						else if(protocol.equals("L") || protocol.equals("l")) {
							Function.PrintList();
						} //L
						else if(protocol.equals("S") || protocol.equals("s")) {
							Function.Search();
						} //S
						else if(protocol.equals("D") || protocol.equals("d")) {
							Function.Delete();
							
						} //D
						
					else if(protocol.equals("E") || protocol.equals("e")) {
						Function.Update();
					}// E
						else if(protocol.equals("I") || protocol.equals("i")) {
							Function.Login();
						} //I
			    
					else if(protocol.equals("O") || protocol.equals("o")) {
						Function.Logout();
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

