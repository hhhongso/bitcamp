package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;

public class List {
	
	public void displayList() {
		 System.out.println("��ü ���"); //�迭: n���� �ش�Ǵ� ������ ����Ǿ� ���� => �ݺ��� Ƚ���� ������ ����. =. for
			System.out.println("���� \t �̸� \t �й� \t ���� \t �μ�");
	}
	
	public void listProcess () { //��ü ��� �Լ�
			displayList();
			
			for(int i = 0; i < Register.haksaList.size(); i++) { 	// length: ������ ���� / size: ������ ũ��(�� ���� ������ �ִ���)
				HashMap<String, String> haksaHash = Register.haksaList.get(i);
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
