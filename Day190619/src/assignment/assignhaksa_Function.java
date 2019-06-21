package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class assignhaksa_Function {
	public static int register(Scanner scan, ArrayList<HashMap<String, String>> haksaList, int choice) { //����Լ�
		if (choice == 1) { // �л����
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("����: ");
			String age = scan.next();
			System.out.print("�̸�: ");
			String name = scan.next();
			System.out.print("�й�: ");
			String idNum = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("idNum", idNum);
			hakhash.put("type", "stu");
			haksaList.add(hakhash);	// ArrayList �ȿ� �� ���� �ֱ� 
			
			System.out.println("�л��� ��ϵǾ����ϴ�.");
			
		} else if (choice == 2) { // �������
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("����: ");
			String age = scan.next();
			System.out.print("�̸�: ");
			String name = scan.next();
			System.out.print("����: ");
			String subject = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("subject", subject);
			hakhash.put("type", "prof");
			haksaList.add(hakhash); // ArrayList �ȿ� �� ���� �ֱ� 
			
			System.out.println("������ ��ϵǾ����ϴ�.");
		} else if (choice == 3) { // �����ڵ��
			HashMap<String, String> hakhash = new HashMap<String, String>();
			
			System.out.print("����: ");
			String age = scan.next();
			System.out.print("�̸�: ");
			String name = scan.next();
			System.out.print("�μ�: ");
			String part = scan.next();
			
			hakhash.put("age", age);
			hakhash.put("name", name);
			hakhash.put("part", part);
			hakhash.put("type", "mng");
			haksaList.add(hakhash);// ArrayList �ȿ� �� ���� �ֱ� 
			
			System.out.println("�����ڰ� ��ϵǾ����ϴ�.");
		}
		return choice;
	}   //����Լ�
	
	
	public static void search(Scanner scan, ArrayList<HashMap<String, String>> haksaList, int choice) { //ã��
		
		while (true) {
			System.out.print("ã�� �̸��� �Է����ּ���: ");
			String searchName = scan.next();		
	
			for(int i = 0; i < haksaList.size(); i++) {
				HashMap<String, String> hakhash = haksaList.get(i);
					if (hakhash.get("type").equals("stu")) { //stu type�̰� 
						if(searchName.equals(haksaList.get(i).get("name"))) {// �̸��� ��ġ�ϸ� 
							System.out.print("����: " + hakhash.get("age") + "\t");
							System.out.print("�̸�: " + hakhash.get("name") + "\t");
							System.out.print("�й�: " + hakhash.get("idNum") + "\n");
						}
						
					} else if (hakhash.get("type").equals("prof")) { // prof type
						if(searchName.equals(haksaList.get(i).get("name"))) {
							System.out.print("����: " + hakhash.get("age") + "\t");
							System.out.print("�̸�: " + hakhash.get("name") + "\t");
							System.out.print("����: " + hakhash.get("subject") + "\n");
						}
					} else if (hakhash.get("type").equals("mng")) { // mng type 
						if(searchName.equals(haksaList.get(i).get("name"))) {
							System.out.print("����: " + hakhash.get("age") + "\t");
							System.out.print("�̸�: " + hakhash.get("name") +"\t");
							System.out.print("�μ�: " + hakhash.get("part") + "\n");
						}
					} //else if (hakhash.get("type").equals(0)) {
						// sysout ��ϵ� �̸��� �ƴմϴ�. ;
					//}
			} //for�� ���� 
			
			System.out.println();
			System.out.print("����Ͻ÷��� 1, �����Ͻ÷��� 0�� �Է����ּ���. ");	
			choice = scan.nextInt();
			if (choice == 0) {
				System.out.println("�����մϴ�. ");
				break;
			} else {
				continue; 
			}
		} 		
	} //ã��
	
	public static void delete(Scanner scan, ArrayList<HashMap<String, String>> haksaList) { // ����
		System.out.print("������ �̸��� �Է����ּ���: ");
		String inputName = scan.next();		
		
		for(int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> hakhash = haksaList.get(i);
			if(hakhash.get("type").equals("stu")) {
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " ���� �����Ǿ����ϴ�. ");				
				}
			} else if (hakhash.get("type").equals("prof")) {
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " ���� �����Ǿ����ϴ�. ");		
				} 
			} else if (hakhash.get("type").equals("mng")){
				if(inputName.equals(hakhash.get("name"))) {
					haksaList.remove(i); 
					System.out.println(inputName + " ���� �����Ǿ����ϴ�. ");		
				} 
			} 
		} // sysout ��ϵ� �̸��� �ƴմϴ�. 
	} 
	
	public static void outputList(ArrayList<HashMap<String, String>> haksaList) { // ��ü���
		for(int i = 0; i < haksaList.size(); i++) {
			HashMap<String, String> hakhash = haksaList.get(i);
			if (hakhash.get("type").equals("stu")) {
				System.out.print("����: " + hakhash.get("age") +"\t");
				System.out.print("�̸�: " + hakhash.get("name") +"\t");
				System.out.print("�й�: " + hakhash.get("idNum") + "\n");
				
			} else if (hakhash.get("type").equals("prof")) {
				System.out.print("����: " + hakhash.get("age") + "\t");
				System.out.print("�̸�: " + hakhash.get("name") + "\t");
				System.out.print("����: " + hakhash.get("subject") + "\n");
			} else if (hakhash.get("type").equals("mng")) {
				System.out.print("����: " + hakhash.get("age") + "\t");
				System.out.print("�̸�: " + hakhash.get("name") + "\t");
				System.out.print("�μ�: " + hakhash.get("part") + "\n");
			}
		}
	}// ��ü���
}
