package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject_Assignment {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====�޴� ����====");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("----------------");
			System.out.println("0. ����");
			System.out.println("----------------");
			System.out.println("��ȣ�� ������ �ּ���: ");
			int protocol = scan.nextInt();
			
			if(protocol == 1) { // ���
				System.out.println("=====�޴� ����====="); 
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.println("��ȣ�� ������ �ּ���: ");
				protocol = scan.nextInt();
				
				if (protocol == 1) { // �л�
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					
					System.out.print("����: ");
					String age = scan.next();
					System.out.print("�̸�: ");
					String name = scan.next();
					System.out.print("�й�: ");
					String idNum = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("idNum", idNum);
					haksaList.add(haksaHash);
					System.out.println("�л� ����� �Ϸ� �Ǿ����ϴ�. ");
					
				} else if (protocol == 2) { // ����
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("����: ");
					String age = scan.next();
					System.out.print("�̸�: ");
					String name = scan.next();
					System.out.print("����: ");
					String subject = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("subject", subject);
					haksaList.add(haksaHash);
					System.out.println("���� ����� �Ϸ� �Ǿ����ϴ�. ");
					
				} else if (protocol == 3) { // ������
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("����: ");
					String age = scan.next();
					System.out.print("�̸�: ");
					String name = scan.next();
					System.out.print("�μ�: ");
					String part = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("part", part);
					haksaList.add(haksaHash);
					System.out.println("������ ����� �Ϸ� �Ǿ����ϴ�. ");
					
				} else { //�����޴�
					System.out.println("�����޴��� ���ư��ϴ�. ");
					continue; 
				}
				
			} else if(protocol == 2) { //ã�� 
				while(true) {
				System.out.print("�̸��� �Է��� �ּ���.: ");
				String inputName = scan.next();
				int index = -1;
				
					for(int i = 0; i < haksaList.size(); i++) {
						if(haksaList.get(i).get("name").equals(inputName)) {
							index = i; 
				//haksaList �� �״�� ���ҷ����ϱ� .get ���� haksaHash�� (i)�� �� �ҷ�����, �� �ȿ� �ִ� ��ҵ� �� name ���� �� �ҷ��´�. 		
						}
					}
					if (index != -1) { // �л� or ���� or ������
						if (haksaList.get(index).get("idNum") != null) { // idNum
							System.out.println("�̸�: " + haksaList.get(index).get("name") +"\t"
									+ "����: " + haksaList.get(index).get("age") +"\t"
									+ "�й�: " + haksaList.get(index).get("idNum"));
						} else if (haksaList.get(index).get("subject") != null) { //subject
							System.out.println("�̸�: " + haksaList.get(index).get("name") +"\t"
									+ "����: " + haksaList.get(index).get("age") +"\t"
									+ "����: " + haksaList.get(index).get("subject"));
						} else if (haksaList.get(index).get("part") != null) { //part
							System.out.println("�̸�: " + haksaList.get(index).get("name") +"\t"
									+ "����: " + haksaList.get(index).get("age") +"\t"
									+ "�μ�: " + haksaList.get(index).get("part"));
						}
					} else { // index = -1, �� ���� 
						System.out.println("��ϵ� �̸��� �ƴմϴ�. ");
					}
					
					System.out.println("����Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է����ּ���. ");
					int choice = scan.nextInt();
					if (choice == 0) {
						System.out.println("�����մϴ�. ");
						break;
						
					} else {  // else if (protocol == 2) { �� �����ϴ� �� �ƴѰ�? 
					}
					
				}	
			
			} else if(protocol == 3) { //����
				while (true) {
				System.out.println("������ ����� �Է��� �ּ���. ");
				String inputName = scan.next();
				int index = -1;
				
					for (int i = 0 ; i <haksaList.size(); i++) {
						if (haksaList.get(i).get("name").equals(inputName)) {
						index = i; 
						haksaList.remove(index);
						System.out.println(inputName + "���� ���� �Ͽ����ϴ�.");
						
						} else {
							System.out.println("��ϵ� �̸��� �ƴմϴ�. ");
						}
					}
					
					System.out.println("����Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է����ּ���. ");
					int choice = scan.nextInt();
					
					if (choice == 0) {
						System.out.println("�����մϴ�. ");
						break; 
					} else {
						
					}
				} // while�� ���� 
				
				
			} else if(protocol == 4) { //��ü ���
				for(int i = 0; i < haksaList.size(); i++) { 
					if (haksaList.get(i).get("idNum") != null) { // idNum
						System.out.println("�̸�: " + haksaList.get(i).get("name") +"\t"
								+ "����: " + haksaList.get(i).get("age") +"\t"
								+ "�й�: " + haksaList.get(i).get("idNum"));
					} else if (haksaList.get(i).get("subject") != null) { //subject
						System.out.println("�̸�: " + haksaList.get(i).get("name") +"\t"
								+ "����: " + haksaList.get(i).get("age") +"\t"
								+ "����: " + haksaList.get(i).get("subject"));
					} else if (haksaList.get(i).get("part") != null) { //part
						System.out.println("�̸�: " + haksaList.get(i).get("name") +"\t"
								+ "����: " + haksaList.get(i).get("age") +"\t"
								+ "�μ�: " + haksaList.get(i).get("part"));
					}
				}
			} else if(protocol == 0) { // �����մϴ�. 
				System.out.println("�����մϴ�. ");
				System.exit(0);
	
			
		} 
	}// while�� ����
		
	

}
}

