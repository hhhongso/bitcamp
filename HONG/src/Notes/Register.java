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
		System.out.print("����: ");
		age = scan.next();
		System.out.print("�̸�: ");
		name = scan.next();
		System.out.print("�й�: ");
		hakbun = scan.next();
		
	}
 
	public void setProfessor() {
		System.out.print("����: ");
		age = scan.next();
		System.out.print("�̸�: ");
		name = scan.next();
		System.out.print("����: ");
		subject = scan.next();
		
	}
	
	public void setManager() {
		System.out.print("����: ");
		age = scan.next();
		System.out.print("�̸�: ");
		name = scan.next();
		System.out.print("�μ�: ");
		part = scan.next();
		
	}
	public int registerProcess(int protocol) {
		
		if(protocol == 1) { 
			HashMap<String, String> haksaHash = new HashMap<String, String>(); //�޸���Ʈ�� (����Ű��)
		
			setStudent();			
			
			haksaHash.put("age", age);
			haksaHash.put("name", name); 
			haksaHash.put("hakbun", hakbun);
			haksaList.add(haksaHash);
			System.out.println("�л��� ��� �Ǿ����ϴ�. ");
			
			
		} else if (protocol == 2) { //���� 
			HashMap<String, String> haksaHash = new HashMap<String, String>();
		
			setProfessor();

			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("subject", subject);
			haksaList.add(haksaHash);
			System.out.println("������ ��� �Ǿ����ϴ�. ");
			
		} else if (protocol == 3) { //������ 
			HashMap<String, String> haksaHash = new HashMap<String, String>();
			
			setManager();
			
			haksaHash.put("age", age);
			haksaHash.put("name", name);
			haksaHash.put("part", part);
			haksaList.add(haksaHash);
			System.out.println("�����ڰ� ��� �Ǿ����ϴ�. ");
			
			
		}
		return protocol;
	} // ����Լ� 
}

