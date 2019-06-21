package Notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Register {
	
	public static Scanner scan;
	public static ArrayList<HashMap<String, String>> haksaList;
	
	private String age; 
	private String name;
	private String hakbun;
	private String subject; 
	private String part;
	private int type;
	
	static {
		scan = new Scanner(System.in);
		haksaList = new ArrayList<HashMap<String, String>>();
	}
	
	public void setStudent() {
		System.out.print("나이: ");
		age = scan.next();
		System.out.print("이름: ");
		name = scan.next();
		System.out.print("학번: ");
		hakbun = scan.next();
		
	}
 
	public void setProfessor() {
		System.out.print("나이: ");
		age = scan.next();
		System.out.print("이름: ");
		name = scan.next();
		System.out.print("과목: ");
		subject = scan.next();
		
	}
	
	public void setManager() {
		System.out.print("나이: ");
		age = scan.next();
		System.out.print("이름: ");
		name = scan.next();
		System.out.print("부서: ");
		part = scan.next();
		
	}
	public int registerProcess(int protocol) {
		
		if(protocol == 1) { 
			HashMap<String, String> haksaHash = new HashMap<String, String>(); //메모리컨트롤 (기억시키기)
		
			setStudent();			
			
			haksaHash.put("age", age);
			haksaHash.put("name", name); 
			haksaHash.put("hakbun", hakbun);
			haksaList.add(haksaHash);
			System.out.println("학생이 등록 되었습니다. ");
			
			
		} else if (protocol == 2) { //교수 
			HashMap<String, String> haksaHash = new HashMap<String, String>();
		
			setProfessor();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("subject", subject);
			haksaList.add(haksaHash);
			System.out.println("교수가 등록 되었습니다. ");
			
		} else if (protocol == 3) { //관리자 
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			
			setManager();
			
			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("part", part);
			haksaList.add(haksaHash);
			System.out.println("관리자가 등록 되었습니다. ");
			
			
		}
		return protocol;
	} // 등록함수 
}

