package kr.co.bit;

import java.util.Scanner;

public class MemberSearchMain {

	public static void main(String[] args) {
		MemberSearch ms = new MemberSearch();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("�̸��� �Է��ϼ���: ");
			String name = sc.next();
			
			// t/F �� �����Ͽ� ������ (true �� ã���� ) =  ã������ memberSearch Ŭ������ searchMember�Լ� ���� 
			boolean searchResult = ms.searchMember(name); // boolean searchResult ���� true ��
			if(searchResult) // 
				break; 
						// boolean searchResult ���� false ��
			System.out.println("ã�� ȸ���� �����ϴ�. ");
		} while(true);			
	}
}
