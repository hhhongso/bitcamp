package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class assignhaksa {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {	
			System.out.println("=====�޴�����=====");
			System.out.println("1. ���");
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("---------------");
			System.out.println("0. ����");
			System.out.println("---------------");
			System.out.print("��ȣ�� ������ �ּ���: ");
			int choice = scan.nextInt();
			
			if (choice == 1) { // ���	
				System.out.println("=====�޴�����=====");
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.print("��ȣ�� ������ �ּ���: ");
				
				choice = scan.nextInt();				
				assignhaksa_Function.register(scan, haksaList, choice); //����Լ� �� �ܺ� Ŭ�������� �����´�.
				
				if(choice == 4) { // �����޴��� ���ư���  
				System.out.println("�����޴��� ���ư��ϴ�. ");
				continue; 
				}
				
			} else if (choice == 2) { // ã��
				assignhaksa_Function.search(scan, haksaList, choice);
				//ã���Լ�
			} else if (choice == 3) { // ����
				assignhaksa_Function.delete(scan, haksaList);
				//�����Լ�
			} else if (choice == 4) { //��ü���
				assignhaksa_Function.outputList(haksaList);
				//����Լ�
			} else { // ����
				System.out.println("�����մϴ�. ");
				System.exit(0);
			}
			
		} //while�� ���� 

	}

}
