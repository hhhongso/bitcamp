package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Search {
	
	private String nameSearch;
	
	public Search() { // �ʱ�ȭ
		nameSearch = null; 
	}
	
	public void setSearchName() {
		System.out.println("ã�� �̸��� �Է��ϼ���: ");
		String nameSearch = Register.input.next(); // Register�迭�濡�� �����  => ������� �����ߴ� ��
	}
	
	public void setSearchNameType() {
		System.out.println("1. �л� 2. ���� 3. ������");
		String type = Register.input.next();
		System.out.print("����\t �̸�\t �й� \t ���� \t �μ� \n");
	}
	
	public void displaySearchStudent(HashMap<String, String> haksaHash) {
		
			
				System.out.print(haksaHash.get("age")+ "\t");
				System.out.print(haksaHash.get("name")+ "\t");
				System.out.print(haksaHash.get("hakbun")+ "\n");
			} 
		
	
	
	public void displaySearchProfessor(HashMap<String, String> haksaHash) {
		
			System.out.print(haksaHash.get("age")+ "\t");
			System.out.print(haksaHash.get("name")+ "\t");
			System.out.print(haksaHash.get("subject")+ "\n");
	}
	
		
	public void displaySearchManager(HashMap<String, String> haksaHash) {
		
			System.out.print(haksaHash.get("age")+ "\t");
			System.out.print(haksaHash.get("name")+ "\t");
			System.out.print(haksaHash.get("part")+ "\n");
		}
	
	
	public void searchProcess () { // ã�� �Լ� 
		 // search �Լ��� arrayList �迭 �ȿ� �־ null���� ������ �ʵ��� �� 
				
				setSearchName();
				setSearchNameType();
				
				
				for(int i = 0; i <  Register.haksaList.size(); i++) {
					HashMap<String, String> haksaHash = Register.haksaList.get(i);
					// if(haksaHash.get("name").equals(nameSearch)) {
					if(haksaHash.get("type").equals("1")) { // �л�ã�� 
					displaySearchStudent(haksaHash);
					
					} else if (haksaHash.get("type").equals("2")) {// ����ã��
						displaySearchProfessor(haksaHash);
					} else if(haksaHash.get("type").equals("3")) {
						displaySearchManager(haksaHash);
					}
	
				}
				
			//}
}// ã�� �Լ� �� 

}