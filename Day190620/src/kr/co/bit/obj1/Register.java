package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {
	
	//�������
	public static Scanner input; //Ŭ���� ���� ==> �ϳ��� ������ָ� �� 
	public static ArrayList<HashMap<String, String>> haksaList; //Ŭ���� ����
	
	private int protocol; //�ν��Ͻ� ����
	private String age; 
	private String name; 
	private String hakbun;
	private String subject;
	private String part;
	private String type;
	
	public Register() { // ������ �ʱ�ȭ 
		protocol = 0;
		age = null; 
		name = null; 
		hakbun = null;
		subject = null;
		part = null;
		type = null;
	
	}
	static { //Ŭ���� �ʱ�ȭ
		input = new Scanner(System.in);
		haksaList = new ArrayList<HashMap<String, String>>();
	}
	
	public void setStudent() { // Ŭ���� �Լ� 
		 
		System.out.print("����: ");
		age = input.next();
		System.out.print("�̸�: ");
		name = input.next();
		System.out.print("�й�: ");
		hakbun = input.next();
		System.out.print("����: ");
		type = input.next();
	}
	
	public void setProfessor() {
		System.out.print("����: ");
		age = input.next();
		System.out.print("�̸�: ");
		name = input.next();
		System.out.print("����: ");
		subject = input.next();
		System.out.print("����: ");
		type = input.next();
	}
	
	public void setManager() {
		System.out.print("����: ");
		age = input.next();
		System.out.print("�̸�: ");
		name = input.next();
		System.out.print("�μ�: ");
		part = input.next();
		System.out.print("����: ");
		type = input.next();
	}
	
	public int registerProcess(int protocol) { //��� �Լ� ����� 
		//�Լ��� Ŭ������ ����� ==> parameter�� ��������� ���� 
				
			 if(protocol == 1) { // �л� 
			 HashMap<String, String> haksaHash = new HashMap<String, String>(); //�޸���Ʈ�� (����Ű��)
			 
				setStudent(); // ���� Ŭ���� �ȿ� �����ϱ� �״�� �����´�. 
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("hakbun", hakbun);
				haksaHash.put("type", "1"); 
				
				haksaList.add(haksaHash);
				System.out.println("�л��� ��� �Ǿ����ϴ�. ");
				
			
			} else if (protocol == 2) { //���� 
				HashMap<String, String> haksaHash = new HashMap<String, String>();
				
				setProfessor();
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("subject", subject);
				haksaHash.put("type", "2"); // type2 = professor
				haksaList.add(haksaHash);
				System.out.println("������ ��� �Ǿ����ϴ�. ");
				
			} else if (protocol == 3) { //������ 
				HashMap<String, String> haksaHash = new HashMap<String, String>();
				
				setManager();
				haksaHash.put("age", age);
				haksaHash.put("name", name);
				haksaHash.put("part", part);
				haksaHash.put("type", "3"); // manager
				haksaList.add(haksaHash);
				System.out.println("�����ڰ� ��� �Ǿ����ϴ�. ");
				}
			 
			 return protocol;
		 	} // ��� �Լ� �� 
	
	
	
	///////////////////////////////////////////////////////////////// RegisterŬ���� ������ main method ���� : �� �Ǵ��� Ȯ�� [���� �׽�Ʈ ����]
	
	/*
	 * public static void main(String[] args) { Register register = new Register();
	 * register.registerProcess(3);
	 * 
	 * }
	 */
}
