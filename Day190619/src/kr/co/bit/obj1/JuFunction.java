package kr.co.bit.obj1;

import java.util.Scanner;

/*
 * 메소드(함수) 만들기 
 * 	 // 입력   (static)     함수이름(신규생성)
	 // void: default로 값이 없음. "호출하는 값, 장소를 되돌릴 것이 없다" => return; 을 적지 않음 
	 // 함수에는 return 명령어가 필요 
	// 파라미터(매개변수, 인수, arguement value) => 메소드()<< ()부분에 해당 
	 
 */
public class JuFunction {
	public static String juSelect(Scanner scan) { // void (X) ==> return할 값의 데이터 타입

		System.out.println("주문하세요. yes/no");
		String ju = scan.next();
		return ju; // return type 일치되어야. 만일 return 값에 "아무거나 임의로 넣으면" 상기 코드와 관계없이 return 값이 도출된다.
	}

	public static void juDisp(int select) { //출력 
	 if (select == 1) {
		 System.out.println("주문선택");		 
	 	} else {
		 System.out.println("주문취소"); 
	 	}
	} 
	public static int menuSelect(Scanner scan) {  //입력 (변화되는 부분)
		System.out.println("1.자장면 2.짬뽕 3.탕수육");
		int menu = scan.nextInt();
		return menu;
	}
	public static void menuDisp(int select) { //출력 
		if (select == 1) {
			System.out.println("자장 선택");
		} else if (select == 2) {
			System.out.println("짬뽕 선택");
		} else if (select == 3) {
			System.out.println("탕수육 선택");
		}	
	}
	public static String gobSelect(Scanner scan) { //입력
		System.out.println("곱배기 yes/no");
		String gob = scan.next();
		return gob; 
	}
	public static void gobDisp(int select) { //출력 
		if(select == 1) {
			System.out.println("자장 곱 선택");
		} else if (select == 2) {
			System.out.println("자장 보통 선택");
		} else if (select == 3) {
			System.out.println("짬뽕 곱 선택");
		} else if (select == 4) {
			System.out.println("짬뽕 보통 선택");
		}
	}
	public static int tangSelect(Scanner scan) { //입력
		System.out.println("1.대 2.중 3.소");
		int tang = scan.nextInt();
		return tang;
	}
	
	public static void tangDisp(int select) {
		if (select == 1) {
			System.out.println("대 선택");
		} else if (select == 2) {
			System.out.println("중 선택");
		} else if (select == 3) {
			System.out.println("소 선택");
		}
	}
	 
	
}
