package Prac0621.Mcd;

import java.util.Scanner;

public class McMain {

	public static void main(String[] args) {
		McProcess mp = new McProcess();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		System.out.println("ã�� �̸� �Է�: ");
		String productName = sc.next();
		
		
		// t.f�� ���� ���� 
		boolean selectResult = mp.mcProcess(productName);
		if(selectResult)
			break; 
		System.out.println("ã���ô� �̸��� �����ϴ�. ");
		
		}
			

	}

}
