package kr.co.bit.haksaFunction;
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
				
				HaksaFunction.register(input, haksaList, protocol);
				if (protocol == 4) { // �����޴�
				System.out.println("�����޴��� ���ư��ϴ�. ");
				continue; // '//���' �ݺ������� �ö󰣴�.
				}

			} else if (protocol == 2) { // ã��
				HaksaFunction.search(input, haksaList);

			} else if (protocol == 3) { // ����
				HaksaFunction.delete(input, haksaList);

			} else if (protocol == 4) { // ��ü ���
				HaksaFunction.list(haksaList);

			} else { //����
				System.out.println("�����մϴ�. ");
				System.exit(0); // �ý��� ����. if- break �� ���� ���� 
			}
			
		} // while(true){}

	}

}

