package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class User_InputStreamReader {
	public InputStreamReader isr = null; 
	public BufferedReader bfr = null; 
	
	private User getUserInfo() {
		User user = null; 
		isr = new InputStreamReader(System.in);
		bfr = new BufferedReader(isr);
		
		try {
			System.out.println("사용자 정보를 입력하세요. ");
			System.out.print("아이디: ");
			String iD = bfr.readLine();
			System.out.print("비밀번호: ");
			String pw = bfr.readLine();
			System.out.print("주소: ");
			String addr = bfr.readLine();
			System.out.print("나이: ");
			int age = Integer.parseInt(bfr.readLine());
			System.out.print("이름: ");
			String name = bfr.readLine();
			user = new User(iD, pw, addr, age, name);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user; 
		
	}
	
	public static void main(String[] args) {
		User_InputStreamReader isrt = new User_InputStreamReader();
		User user = isrt.getUserInfo();
		System.out.println("입력한 사용자 정보: ");
		System.out.println(user); // user.toString()
	}
	
	
}
