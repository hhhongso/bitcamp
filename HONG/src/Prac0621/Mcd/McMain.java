package Prac0621.Mcd;

import java.util.Scanner;

public class McMain {

	public static void main(String[] args) {
		McProcess mp = new McProcess();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		System.out.println("찾을 이름 입력: ");
		String productName = sc.next();
		
		
		// t.f의 값을 뱉음 
		boolean selectResult = mp.mcProcess(productName);
		if(selectResult)
			break; 
		System.out.println("찾으시는 이름이 없습니다. ");
		
		}
			

	}

}
