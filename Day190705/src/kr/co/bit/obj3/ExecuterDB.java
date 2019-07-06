package kr.co.bit.obj3;
// 등록 후 로그인 필요 > 탈퇴, 수정, 로그아웃 
// 등록 후 로그인 없이 > 목록보기, 아이디찾기 

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuterDB {

	public static String protocol;
	
	
	static {
		
	}
	
	public static void main(String[] args) {
		Register register = new Register();
		PrintList printList = new PrintList();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		Login login = new Login();
		Logout logout = new Logout();
	
			try {
				while(true) {
				Function.getConnection();
				if(Function.conn == null) {
					System.out.println("fail");
				} else {
					System.out.println("ok! ");
						System.out.println("==== 회원관리 ====");
						System.out.println("R:회원가입 L:회원목록 S:아이디찾기 D:회원탈퇴 U:회원수정 I:로그인 O:로그아웃");
						
							protocol = Function.br.readLine();
							if(protocol.equals("R") ||protocol.equals("r")) {
								if(Function.session!=null) {
									System.out.println("로그인중입니다.");
									continue;
								}
								register.RegisterProcess();
							  } //R
							else if(protocol.equals("L") || protocol.equals("l")) {
								printList.PrintListProcess();
							} //L
							else if(protocol.equals("S") || protocol.equals("s")) {
								search.SearchProcess();
							} //S
							else if(protocol.equals("D") || protocol.equals("d")) {
								delete.DeleteProcess();
								
							} //D
							
						else if(protocol.equals("U") || protocol.equals("u")) {
							update.UpdateProcess();
						}// E
							else if(protocol.equals("I") || protocol.equals("i")) {
								login.LoginProcess();
							} //I
				    
						else if(protocol.equals("O") || protocol.equals("o")) {
							logout.LogoutProcess();
						} //O
						
					}// while
				}//db
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		

	} //main

}

