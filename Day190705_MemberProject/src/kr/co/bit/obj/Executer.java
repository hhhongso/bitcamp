package kr.co.bit.obj;
// 등록 후 로그인 필요 > 탈퇴, 수정, 로그아웃 
// 등록 후 로그인 없이 > 목록보기, 아이디찾기 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Executer {
	
	public static String session;
	
	static {
		session = null;
	}
	
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("==== 회원관리 ====");
			System.out.println("R:회원가입 L:회원목록 S:아이디찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
			
			try {
				
				String protocol = br.readLine();
				if(protocol.equals("R") ||protocol.equals("r")) {
					if(session!=null) {
						System.out.println("로그인중입니다.");
						continue;
					}
					HashMap<String, String> hashmap = new HashMap<String, String>();
				
					
					System.out.print("아이디: ");
					String id = br.readLine();
					System.out.print("비밀번호: ");
					String pw = br.readLine();
					System.out.print("주소: ");
					String addr = br.readLine();
					System.out.print("전화번호: ");
					String tel = br.readLine();
					
					hashmap.put("id", id);
					hashmap.put("pw", pw);
					hashmap.put("addr", addr);
					hashmap.put("tel", tel);
					arr.add(hashmap);					
					System.out.println("회원 등록 되었습니다. ");
					
					
					
				  } //R
				else if(protocol.equals("L") || protocol.equals("l")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
					System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
					for(int i = 0; i < arr.size(); i++) {
						hashmap = arr.get(i);
						
							String id = hashmap.get("id");
							String pw = hashmap.get("pw");
							String addr = hashmap.get("addr");
							String tel = hashmap.get("tel");
							System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
						}
					
				} //L
				else if(protocol.equals("S") || protocol.equals("s")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
					System.out.print("찾는 아이디 입력: ");
					String searchID = br.readLine();
					for(int i = 0; i < arr.size(); i++) {
						hashmap = arr.get(i);
						if(hashmap.get("id").equals(searchID)) {

							String id = hashmap.get("id");
							String pw = hashmap.get("pw");
							String addr = hashmap.get("addr");
							String tel = hashmap.get("tel");
							
							System.out.println("아이디 \t 비밀번호 \t 주소 \t 전화번호");
							System.out.println(id + "\t" + pw + "\t" + addr + "\t" +tel);
							System.out.println("아이디를 찾았습니다. ");
						} 
//						else if (!hashmap.get("id").equals(searchID)){
//							System.out.println("찾는 아이디가 없습니다. ");
//						}
					}
				} //S
				else if(protocol.equals("D") || protocol.equals("d")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
					System.out.print("탈퇴할 아이디 입력: ");
					session = br.readLine();
					for(int i = 0; i < arr.size(); i++) {
						hashmap = arr.get(i);
						if(hashmap.get("id").equals(session)) {
							arr.remove(i);
							session = null;
							System.out.println("해당 아이디가 탈퇴되었습니다. ");
						} else {
							System.out.println("찾는 아이디가 없습니다. ");
						}
					}
				} //D
				else if(protocol.equals("E") || protocol.equals("e")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
					System.out.print("수정할 아이디 찾기: ");
					session = br.readLine();
					for(int i = 0; i < arr.size(); i++) {
						hashmap = arr.get(i);
						if(hashmap.get("id").equals(session)) {
							System.out.print("아이디 수정: ");
							String editID = br.readLine();
							System.out.print("비밀번호 수정: ");
							String pw = br.readLine();
							hashmap.put("id", editID);
							hashmap.put("pw", pw);
							arr.set(i, hashmap);
							
							session = editID;
							System.out.println("아이디, 비밀번호 변경완료 ");
						} 					
					}
					
					
				}// E
				else if(protocol.equals("I") || protocol.equals("i")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
					System.out.print("아이디: ");
					String loginID = br.readLine();
					System.out.print("비밀번호: ");
					String loginPW = br.readLine();
					
					hashmap.put("id",loginID);
					hashmap.put("pw",loginPW);
					
					for(int i = 0; i < arr.size(); i++) {						
						hashmap = arr.get(i);
						arr.set(i, hashmap);//////////////////////////////////////////////////////////여기에 set
						if (hashmap.get("id").equals(loginID) && hashmap.get("pw").equals(loginPW)) {
						System.out.println("로그인 성공");			
						session = loginID;
						
						} else if (hashmap.get("id").equals(loginID) && !hashmap.get("pw").equals(loginPW)) {
							System.out.println("비번 불일치");
							
						} else if (!hashmap.get("id").equals(loginID) && hashmap.get("pw").equals(loginPW)) {
							System.out.println("아이디 불일치");
						
						} else if (!hashmap.get("id").equals(loginID) && !hashmap.get("pw").equals(loginPW)) {
							System.out.println("아이디&비번 불일치. 더이상 가입할 수 없습니다. ");
							return;
						}
						
					}
				} //I
	    
				else if(protocol.equals("O") || protocol.equals("o")) {
					HashMap<String, String> hashmap = new HashMap<String, String>();
//					System.out.print("아이디 입력: ");
//					session = br.readLine();
					for(int i = 0; i < arr.size(); i++) {
						hashmap = arr.get(i);
						if(hashmap.get("id").equals(session)) {
							session = null;
							System.out.println("로그아웃 되었습니다. ");
						} 
					}
				} //O
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// while

	} //main

}

