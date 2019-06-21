package kr.co.bit.haksaFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaFunction {
 public static int register(Scanner input, ArrayList<HashMap<String, String>> haksaList, int protocol) { //��� �Լ� ����� 

	 if(protocol == 1) { // �л� 
	 HashMap<String, String> haksaHash = new HashMap<String, String>(); //�޸���Ʈ�� (����Ű��)
	 
		System.out.print("����: ");
		String age = input.next();
		System.out.print("�̸�: ");
		String name = input.next();
		System.out.print("�й�: ");
		String hakbun = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("hakbun", hakbun);
		haksaHash.put("type", "1"); 
		
		haksaList.add(haksaHash);
		System.out.println("�л��� ��� �Ǿ����ϴ�. ");
		
	
	} else if (protocol == 2) { //���� 
		HashMap<String, String> haksaHash = new HashMap<String, String>();
		System.out.print("����: ");
		String age = input.next();
		System.out.print("�̸�: ");
		String name = input.next();
		System.out.print("����: ");
		String subject = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("subject", subject);
		haksaHash.put("type", "2"); // type2 = professor
		haksaList.add(haksaHash);
		System.out.println("������ ��� �Ǿ����ϴ�. ");
		
	} else if (protocol == 3) { //������ 
		HashMap<String, String> haksaHash = new HashMap<String, String>();
		System.out.print("����: ");
		String age = input.next();
		System.out.print("�̸�: ");
		String name = input.next();
		System.out.print("�μ�: ");
		String part = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("part", part);
		haksaHash.put("type", "3"); // manager
		haksaList.add(haksaHash);
		System.out.println("�����ڰ� ��� �Ǿ����ϴ�. ");
		}
	 
	 return protocol;
 	} // ��� �Լ� �� 
 
  public static void search (Scanner input, ArrayList<HashMap<String, String>> haksaList) { // ã�� �Լ� 
	 // search �Լ��� arrayList �迭 �ȿ� �־ null���� ������ �ʵ��� �� 
			System.out.println("ã�� �̸��� �Է��ϼ���: ");
			String nameSearch = input.next();
			System.out.println("1. �л� 2. ���� 3. ������");
			String type = input.next();
			System.out.print("����\t �̸�\t �й� \t ���� \t �μ� \n");
			for(int i = 0; i <  haksaList.size(); i++) {
				HashMap<String, String> haksaHash = haksaList.get(i);
				if(haksaHash.get("type").equals(type)) { // �л�ã�� 
					if (nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("hakbun")+ "\n");
					} 
				}else if (haksaHash.get("type").equals(type)) {// ����ã��
					if(nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("subject")+ "\n");
					}
				} else if(haksaHash.get("type").equals(type)) {
					if(nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("part")+ "\n");
					}
				}
				
			}
			
		}// ã�� �Լ� �� 

  
  public static void delete (Scanner input, ArrayList<HashMap<String, String>> haksaList) { //���� �Լ�
	  System.out.println("������ �̸��� �Է��ϼ���: ");
		String nameDelete = input.next();
		
		for (int i = 0; i < haksaList.size();i++) {
			HashMap<String, String> haksaHash = haksaList.get(i);
			if(haksaHash.get("type").equals("1")) { // �л� ����  // �л��ؽÿ��� ->type = stu�� ��ġ�ϸ� 
				if (nameDelete.equals(haksaHash.get("name"))) { // => nameDelete�� �л��ؽ�(stu)�� name�� ��ġ�ϸ� 
					haksaList.remove(i); // �ش� i��° ���� ArrayList�� �����Ѵ�. 
					System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
					i = i -1; // Ȥ�� key ���� �ϳ� �߰��ؼ�, ���� key���� �ѹ��� ���� �� �ֵ��� (�������� ó���ϱ�) 
				}
			} else if(haksaHash.get("type").equals("2")) { //���� ����
				if(nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
				}
			} else if(haksaHash.get("type").equals("3")) { // ������ ����
				if (nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
				}
			}
		}
} //���� �Լ� ��
 public static void list (ArrayList<HashMap<String, String>> haksaList) { //��ü ��� �Լ�
	 System.out.println("��ü ���"); //�迭: n���� �ش�Ǵ� ������ ����Ǿ� ���� => �ݺ��� Ƚ���� ������ ����. =. for
		System.out.println("���� \t �̸� \t �й� \t ���� \t �μ� \n");
		for(int i = 0; i < haksaList.size(); i++) { 	// length: ������ ���� / size: ������ ũ��(�� ���� ������ �ִ���)
			HashMap<String, String> haksaHash = haksaList.get(i);
			if(haksaHash.get("type").equals("1")) { 
				System.out.print(haksaHash.get("age")+ "\t");
				System.out.print(haksaHash.get("name")+ "\t");
				System.out.print(haksaHash.get("hakbun")+ "\n"); // �л� ��ü��� 
			} else if (haksaHash.get("type").equals("2")) {
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t \t");
				System.out.print(haksaHash.get("subject") + "\n");
			} else if (haksaHash.get("type").equals("3")) {
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t \t \t");
				System.out.print(haksaHash.get("part") + "\n");
			}
			
		}
 } // ��ü ��� �� 
}
