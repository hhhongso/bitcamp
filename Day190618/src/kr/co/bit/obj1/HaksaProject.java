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
			
			if(protocol == 1) { // ���
								
				System.out.println("=====�޴� ����====="); 
				System.out.println("1. �л�");
				System.out.println("2. ����");
				System.out.println("3. ������");
				System.out.println("4. �����޴�");
				System.out.println("��ȣ�� ������ �ּ���.. ");
				protocol = input.nextInt();
				
				if(protocol == 1) { //�л�
					HashMap<String, String> haksaHash = new HashMap<String, String>(); //�޸���Ʈ�� (����Ű��)
					//2�����迭(��, ��) (key)String, (��;value)String ��
					// String, Integer �� ����. ��, �̰�� ���� int�� Ŭ���� Integer�� �����ؾ� 
					
					/* HashMap Ŭ���� ?
					 * Ű�� ���� ���� �ϳ��� entry �� ����, �÷��� Ŭ������ �����Ѵ� . 
					 * key �� 2���� �� �� ������, value�� �ߺ� ����. 
					 * 1���� hashMap �� �迭�� ���� �ڿ��� ������ �޸� ������ �����Ͽ���.
					 * hashing (�˻����)�� ����Ͽ� ���� ���� �����͸� �˻� �� �� �ִ�. 
					 */
					
					System.out.print("����: ");
					String age = input.next();
					System.out.print("�̸�: ");
					String name = input.next();
					System.out.print("�й�: ");
					String hakbun = input.next();
					
					              //key  value
					haksaHash.put("age", age);
					haksaHash.put("name", name); // key ���� age�� �� ���� ����(�ߺ� �Ұ�)
					haksaHash.put("hakbun", hakbun);
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
					haksaList.add(haksaHash);
					System.out.println("�����ڰ� ��� �Ǿ����ϴ�. ");
					
				} else { //�����޴� 
					System.out.println("�����޴��� ���ư��ϴ�. ");
					continue;                   // '//���' �ݺ������� �ö󰣴�. 
				}
				
			} else if(protocol == 2) { //ã��
				
			} else if (protocol == 3) { //����
				System.out.println("����");
			} else if (protocol == 4) { //��ü ���
				System.out.println("��ü ���"); //�迭: n���� �ش�Ǵ� ������ ����Ǿ� ���� => �ݺ��� Ƚ���� ������ ����. =. for
				System.out.println("���� \t �̸� \t �й� \t ���� \t �μ� \n");
				for(int i = 0; i < haksaList.size(); i++) { 	// length: ������ ���� / size: ������ ũ��(�� ���� ������ �ִ���)
					HashMap<String, String> haksaHash = haksaList.get(i);
					System.out.print(haksaHash.get("age")+ "\t");
					System.out.print(haksaHash.get("name")+ "\t");
					System.out.print(haksaHash.get("hakbun")+ "\t"); // �л� ��ü��� 
					System.out.print(haksaHash.get("subject")+ "\t"); // ���� 
					System.out.print(haksaHash.get("part")+ "\t \n"); // ������
				}
				
				
			} else { //����
				System.out.println("�����մϴ�. ");
				System.exit(0); // �ý��� ����. if- break �� ���� ���� 
			}
			
		} // while(true){}

	}

}
