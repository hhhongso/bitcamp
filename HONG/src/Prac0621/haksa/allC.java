package Prac0621.haksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class allC {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("=====�޴� ����=====");
			System.out.println("1. ���"); 
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("----------------");
			System.out.println("0. ����");
			System.out.println("----------------");
			System.out.println("��ȣ�� ������ �ּ���.. ");
			int choice = scan.nextInt();
			
			if (choice == 1) { // ��� �޴� ���� 
					System.out.println("=====�޴� ����=====");
					System.out.println("1. �л�");
					System.out.println("2. ����");
					System.out.println("3. ������");
					System.out.println("4. �����޴�");
					System.out.println("��ȣ�� ������ �ּ���.. ");
					choice = scan.nextInt();
					
					if(choice == 1) { // �л� ���
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("�̸�: ");
						String name = scan.next();
						System.out.print("����: ");
						String age = scan.next();
						System.out.print("�й�: ");
						String idNum = scan.next();
						
						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("idNum", idNum);
						haksa.put("type", "stu");
						
						haksaList.add(haksa);
						
						
						System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�.");
						
					} else if (choice == 2) { // ���� ���
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("�̸�: ");
						String name = scan.next();
						System.out.print("����: ");
						String age = scan.next();
						System.out.print("����: ");
						String subject = scan.next();

						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("subject", subject);
						haksa.put("type", "prof");
						
						haksaList.add(haksa);
						
						System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.");
						
					} else if (choice == 3) { // ������ ���
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("�̸�: ");
						String name = scan.next();
						System.out.print("����: ");
						String age = scan.next();
						System.out.print("�μ�: ");
						String part = scan.next();

						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("part", part);
						haksa.put("type", "mng");

						haksaList.add(haksa);
						
						System.out.println("������ ����� �Ϸ�Ǿ����ϴ�.");
						
					} else if (choice == 4) { // ���� �޴���
						System.out.println("���� �޴��� ���ư��ϴ�.");
						continue;
					}
				} // ��� if��
	
			 else if (choice == 2) { // ã�� �޴� ���� 
					System.out.println("ã�� �̸��� �Է����ּ���: ");
					String name = scan.next();
					
					for(int i = 0; i < haksaList.size(); i++) {
						HashMap<String, String> haksa = haksaList.get(i);
						if(haksa.get("name").equals(name)) { // �˻��� �̸��� �ִ�. 
							System.out.println(name +"���� ã�ҽ��ϴ�. ");
							if(haksa.get("type").equals("stu")) { // �� �̸��� �л��̴� .
								System.out.print("�̸�: " + haksa.get("name") +  "\t");
								System.out.print("����: " + haksa.get("age") + "\t");
								System.out.print("�й�: " + haksa.get("idNum") + "\t");
								System.out.println();
							} else if (haksa.get("type").equals("prof")) {
								System.out.print("�̸�: " + haksa.get("name") +  "\t");
								System.out.print("����: " + haksa.get("age") + "\t");
								System.out.print("����: " + haksa.get("subject") + "\t");
								System.out.println();
							} else if (haksa.get("type").equals("mng")) {
								System.out.print("�̸�: " + haksa.get("name") +  "\t");
								System.out.print("����: " + haksa.get("age") + "\t");
								System.out.print("�μ�: " + haksa.get("part") + "\t");
								System.out.println();
							}
							
						//} else {
						//	System.out.println("ã���� �̸��� �����ϴ�.");
						}
					}
					
					
			} // ã�� if �� ��
			else if (choice == 3) { // ���� �޴� ���� 
				System.out.println("������ �̸��� �Է����ּ���: ");
				String name = scan.next();
				
				for(int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksa = haksaList.get(i);
					if(haksa.get("name").equals(name)) {
						if(haksa.get("type").equals("stu")) {
							haksaList.remove(i);
							System.out.println("�ش� �̸��� ���� �Ǿ����ϴ�. ");
						} else if (haksa.get("type").equals("prof")) {
							haksaList.remove(i);
							System.out.println("�ش� �̸��� ���� �Ǿ����ϴ�. ");
						} else if (haksa.get("type").equals("mng")) {
							haksaList.remove(i);
							System.out.println("�ش� �̸��� ���� �Ǿ����ϴ�. ");
					}
						
					//} else {
					//	System.out.println("ã���� �̸��� �����ϴ�. ");
					}
				}
					
			} // ���� if�� �� 
			
			else if (choice == 4) { // ��ü ��� �޴� ���� 
				for(int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksa = haksaList.get(i);
						if(haksa.get("type").equals("stu")) {
							System.out.println("�̸�: " + haksa.get("name") + "����: " + haksa.get("age") + "�й�: " + haksa.get("idNum"));
						} else if (haksa.get("type").equals("prof")) {
							System.out.println("�̸�: " + haksa.get("name") + "����: " + haksa.get("age") + "����: " + haksa.get("subject"));
						} else if (haksa.get("type").equals("mng")) {
							System.out.println("�̸�: " + haksa.get("name") + "����: " + haksa.get("age") + "�μ�: " + haksa.get("part"));
						}
				}
				
			} // ��ü��� if�� ��
			
			else if (choice == 0) { // ���� �޴� ����
				System.out.println("�����մϴ�. ");
				break;
			} else { // �߸��� ���� 
				System.out.println("�߸��Ǿ����ϴ�. �ٽ� �������ּ���. ");
			}
			
		} // while�� 
	}

}
