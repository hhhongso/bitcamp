package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {
	
	//멤버변수
	public static Scanner input; //클래스 변수 ==> 하나만 만들어주면 됨 
	public static ArrayList<HashMap<String, String>> haksaList; //클래스 변수
	
	private int protocol; //인스턴스 변수
	private String age; 
	private String name; 
	private String hakbun;
	private String subject;
	private String part;
	private String type;
	
	public Register() { // 생성자 초기화 
		protocol = 0;
		age = null; 
		name = null; 
		hakbun = null;
		subject = null;
		part = null;
		type = null;
	
	}
	static { //클래스 초기화
		input = new Scanner(System.in);
		haksaList = new ArrayList<HashMap<String, String>>();
	}
	
	public void setStudent() { // 클래스 함수 
		 
		System.out.print("나이: ");
		age = input.next();
		System.out.print("이름: ");
		name = input.next();
		System.out.print("학번: ");
		hakbun = input.next();
		System.out.print("구분: ");
		type = input.next();
	}
	
	public void setProfessor() {
		System.out.print("나이: ");
		age = input.next();
		System.out.print("이름: ");
		name = input.next();
		System.out.print("과목: ");
		subject = input.next();
		System.out.print("구분: ");
		type = input.next();
	}
	
	public void setManager() {
		System.out.print("나이: ");
		age = input.next();
		System.out.print("이름: ");
		name = input.next();
		System.out.print("부서: ");
		part = input.next();
		System.out.print("구분: ");
		type = input.next();
	}
	
	public int registerProcess(int protocol) { //등록 함수 만들기 
		//함수를 클래스로 만들기 ==> parameter는 멤버변수로 변경 
				
			 if(protocol == 1) { // 학생 
			 HashMap<String, String> haksaHash = new HashMap<String, String>(); //메모리컨트롤 (기억시키기)
			 
				setStudent(); // 같은 클래스 안에 있으니까 그대로 가져온다. 
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("hakbun", hakbun);
				haksaHash.put("type", "1"); 
				
				haksaList.add(haksaHash);
				System.out.println("학생이 등록 되었습니다. ");
				
			
			} else if (protocol == 2) { //교수 
				HashMap<String, String> haksaHash = new HashMap<String, String>();
				
				setProfessor();
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("subject", subject);
				haksaHash.put("type", "2"); // type2 = professor
				haksaList.add(haksaHash);
				System.out.println("교수가 등록 되었습니다. ");
				
			} else if (protocol == 3) { //관리자 
				HashMap<String, String> haksaHash = new HashMap<String, String>();
				
				setManager();
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("part", part);
				haksaHash.put("type", "3"); // manager
				haksaList.add(haksaHash);
				System.out.println("관리자가 등록 되었습니다. ");
				}
			 
			 return protocol;
		 	} // 등록 함수 끝 
	
	
	
	///////////////////////////////////////////////////////////////// Register클래스 내에서 main method 진행 : 잘 되는지 확인 [단위 테스트 진행]
	
	/*
	 * public static void main(String[] args) { Register register = new Register();
	 * register.registerProcess(3);
	 * 
	 * }
	 */
}
