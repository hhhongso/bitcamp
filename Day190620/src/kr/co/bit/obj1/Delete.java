package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Delete {
	
	private String nameDelete; // 
	private String type;
	
	public Delete() {
		nameDelete = null;
		type = null;
	
	}
	
	public void setDeleteName() {
		System.out.println("������ �̸��� �Է��ϼ���: ");
		nameDelete = Register.input.next();
		
	}
	public void setDeleteType () {
		System.out.println("1. �л� 2. ���� 3. ������ ");
		type = Register.input.next();
	}
	
	 public void deleteProcess () { //���� �Լ�
			setDeleteName();
			setDeleteType();
			
			for (int i = 0; i < Register.haksaList.size();i++) {
				HashMap<String, String> haksaHash = Register.haksaList.get(i);
				if(haksaHash.get("type").equals("1")) { // �л� ����  // �л��ؽÿ��� ->type = stu�� ��ġ�ϸ� 
					if (nameDelete.equals(haksaHash.get("name"))) { // => nameDelete�� �л��ؽ�(stu)�� name�� ��ġ�ϸ� 	
						Register.haksaList.remove(i); // �ش� i��° ���� ArrayList�� �����Ѵ�. 
						System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
						//i = i -1; // Ȥ�� key ���� �ϳ� �߰��ؼ�, ���� key���� �ѹ��� ���� �� �ֵ��� (�������� ó���ϱ�) 
					}
				} else if(haksaHash.get("type").equals("2")) { //���� ����
					if(nameDelete.equals(haksaHash.get("name"))) {
						Register.haksaList.remove(i);
						System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
					}
				} else if(haksaHash.get("type").equals("3")) { // ������ ����
					if (nameDelete.equals(haksaHash.get("name"))) {
						Register.haksaList.remove(i);
						System.out.println(nameDelete + "���� �����Ǿ����ϴ�. ");
					}
				}
			}
	} //���� �Լ� ��
}
