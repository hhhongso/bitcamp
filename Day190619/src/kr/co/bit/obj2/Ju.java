package kr.co.bit.obj2;
/*Class: 
현실세계의 개념을 
컴퓨터의 개념으로 가져오도록 하는 설계도, 주조 틀

에어컨 (객체) 클래스에는 
특성(변수/명사)
기능(메소드/동사)
 * 
 */
import java.util.Scanner;

public class Ju {
	//변수정의
	static Scanner scan; // static 으로 메모리 공간 선언 후, 변수 scan 선언  ==> 기존 파라미터에 입력하였던 매개변수가 더이상 필요하지 않게 됨
	static String ju; 
	static int select;
	static int menu;
	static String gob;
	static int tang; 
	
	//메소드정의
	public static String juSelect() { // void (X) ==> return할 값의 데이터 타입
		System.out.println("주문하세요. yes/no");
		ju = scan.next();
		return ju; // return type 일치되어야. 만일 return 값에 "아무거나 임의로 넣으면" 상기 코드와 관계없이 return 값이 도출된다.
	}

	public static void juDisp() { //출력 
	 if (select == 1) {
		 System.out.println("주문선택");		 
	 	} else {
		 System.out.println("주문취소"); 
	 	}
	} 
	public static int menuSelect() {  //입력 (변화되는 부분)
		System.out.println("1.자장면 2.짬뽕 3.탕수육");
		menu = scan.nextInt();
		return menu;
	}
	public static void menuDisp() { //출력 
		if (select == 1) {
			System.out.println("자장 선택");
		} else if (select == 2) {
			System.out.println("짬뽕 선택");
		} else if (select == 3) {
			System.out.println("탕수육 선택");
		}	
	}
	public static String gobSelect() { //입력
		System.out.println("곱배기 yes/no");
		gob = scan.next();
		return gob; 
	}
	public static void gobDisp() { //출력 
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
	public static int tangSelect() { //입력
		System.out.println("1.대 2.중 3.소");
		tang = scan.nextInt();
		return tang;
	}
	
	public static void tangDisp() {
		if (select == 1) {
			System.out.println("대 선택");
		} else if (select == 2) {
			System.out.println("중 선택");
		} else if (select == 3) {
			System.out.println("소 선택");
		}
	}
	 
}
