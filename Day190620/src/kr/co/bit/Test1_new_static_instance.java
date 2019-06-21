package kr.co.bit;

import java.util.Scanner;

public class Test1_new_static_instance {
	public int display() { // case = 1 2 3 4 를 불러와야 함 //인스턴스 메소드 
		Scanner scan = new Scanner(System.in);
		System.out.println("1. 등록 2. 삭제 3. 정렬 4. 종료");
		int number = scan.nextInt();
		return number; 
	}
	
	public static void inputRecord() {
		System.out.println("등록");
		
	}
	
	public static void deleteRecord() {
		System.out.println("삭제");
	}
	
	public static void sortRecord() {
		System.out.println("정렬");
	}
	
	public static void exitRecord() {
		System.out.println("종료합니다. ");
		System.exit(0);
	}


}

