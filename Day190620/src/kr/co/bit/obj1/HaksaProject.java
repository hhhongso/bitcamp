package kr.co.bit.obj1;
// pptx page 113
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); 
		// �迭. haksaList��� �迭�� ���� 
		// ArrayList�� hashMap �� ž�� 
		
		Scanner input = new Scanner(System.in);
		//HaksaFunction haska = new HaksaFunction(); // >> HaksaFunction ��ü ����  �ؼ� �� �ȿ��� �Լ��� ���ȴµ�
		Register register = new Register(); // register Ŭ���� �Լ��� ���� ������ ������ ��� haksaFunction�� ���̻� �ʿ����,  register Ŭ������ �����ͼ� �Լ� �����ϰ� �ϸ� �ȴ�. 
		Search search = new Search();
		Delete delete = new Delete();
		List list = new List();
		
		while(true) {
			System.out.println("=====�޴� ����=====");
			System.out.println("1. ���"); //ctrl +alt + �Ʒ�����Ű = ����
			System.out.println("2. ã��");
			System.out.println("3. ����");
			System.out.println("4. ��ü ���");
			System.out.println("----------------");
			System.out.println("0. ����");
			System.out.println("----------------");
			System.out.println("��ȣ�� ������ �ּ���.. ");
			int protocol = input.nextInt();
			
			if(protocol == 1) {		
				System.out.println("=====�޴� ����====="); 
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.println("��ȣ�� ������ �ּ���.. ");
				protocol = input.nextInt();
				
				protocol = register.registerProcess(protocol);
				//haska.register(input, haksaList, protocol); // ��ü������ haksa Ŭ����.�Լ�
			 	if (protocol == 4) { // �����޴�
				System.out.println("�����޴��� ���ư��ϴ�. ");
				continue; // '//���' �ݺ������� �ö󰣴�.
				}

			} else if (protocol == 2) { // ã��
				//haska.search(input, haksaList);
				search.searchProcess();

			} else if (protocol == 3) { // ����
				//haska.delete(input, haksaList);
				delete.deleteProcess();

			} else if (protocol == 4) { // ��ü ���
				//haska.list(haksaList);
				list.listProcess();

			} else { //����
				System.out.println("�����մϴ�. ");
				System.exit(0); // �ý��� ����. if- break �� ���� ���� 
			}
			
		} // while(true){}

	}

}

