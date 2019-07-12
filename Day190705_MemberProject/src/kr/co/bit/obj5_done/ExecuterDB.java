package kr.co.bit.obj5_done;
// 등록 후 로그인 필요 > 탈퇴, 수정, 로그아웃 
// 등록 후 로그인 없이 > 목록보기, 아이디찾기 

import java.io.IOException;
import java.sql.SQLException;
public class ExecuterDB {
	
	public static void main(String[] args) {

		Register register = new Register();
		PrintList printList = new PrintList();
		Search search = new Search();
		Delete delete = new Delete();
		Update update = new Update();
		Login login = new Login();
		Logout logout = new Logout();
		
		MemberPoly mp = new MemberPoly();
		
			try {
				while(true) {
				Function.getConnection();
				if(Function.conn == null) {
					System.out.println("fail");
				} else {
					System.out.println("ok! ");
						System.out.println("==== 회원관리 ====");
						System.out.println("R:회원가입 L:회원목록 S:아이디찾기 D:회원탈퇴 U:회원수정 I:로그인 O:로그아웃");
						
							String protocol = Function.br.readLine();
							if(protocol.equals("R") ||protocol.equals("r")) {
								if(Function.session!=null) {
									System.out.println("로그인중입니다.");
									continue;
								}
								try {
									register.process();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							  } //R
							else if(protocol.equals("L") || protocol.equals("l")) {
								try {
									printList.process();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} //L
							else if(protocol.equals("S") || protocol.equals("s")) {
								try {
									search.process();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} //S
							else if(protocol.equals("D") || protocol.equals("d")) {
								try {
									delete.process();
								} catch (SQLException e) {
									e.printStackTrace();
								}
								
							} //D							
							else if(protocol.equals("U") || protocol.equals("u")) {					
									update.process();
									
							}// E
							else if(protocol.equals("I") || protocol.equals("i")) {
								try {
									login.process();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							} //I
				    
						else if(protocol.equals("O") || protocol.equals("o")) {
							logout.process();
						} //O
						
					}// while
				}//db
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		

	} //main

}
