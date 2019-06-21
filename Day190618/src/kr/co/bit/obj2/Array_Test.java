package kr.co.bit.obj2;
/*
 * 1. 배열선언
* 데이터 타입[] 배열 변수명; 또는 데이터 타입 배열 변수명[];
* int[] args; // java 첫번째 숫자를 0으로 봄. 타입[] 연속적인 공간을 확보.  
* int args[]; // C 방식
 */
import java.util.ArrayList;

public class Array_Test {

	public static void main(String[] args) {
		int[] number; // number라는 이름으로 연속적인 공간 []을 정수형 확보
		number= new int[3]; // new 연산자로 3개의 연속적인 공간을 만든다. 
		number[0] = 10;
		number[1] = 20;
		number[2] = 30;
		for(int i = 0; i < number.length; i++) { //length는 배열[]에서 공간의 길이 0,1,2
			System.out.println(number[i]); // 대괄호로 가져온다 
		}
		
		System.out.println();
		/*
		* ArrayList list = new ArrayList();
		* list.add("문자열");
		* list.add(1);
		* list.add(3.14); // 제네릭 타입 설정 없이는 위와 같이 문자, 정수, 실수 등 구분없이 모두 add가 가능. 
		
		* ArrayList<Integer> list1 = new ArrayList<Integer>();
		* list1.add("문자열"); Integer타입이 아닌 것은 들어올 수 없도록 제네릭으로 규정해놓음. 
		* list1.add(1);
		*/
		
		//상기 배열과 아래 어레이리스트(컬렉션 클래스) 는 동일 개념 
		// <제네릭 타입> = integer 클래스
		// 제네릭? 고정된 타입 외에는 적용할 수 없도록 함 
		
		ArrayList<Integer> numberList = new ArrayList<Integer>(); //[]공간 증가/감소에 대한 자동 컨트롤 기능이 있음. 
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		for(int i = 0; i < numberList.size(); i++) { //size는 컬렉션 클래스에서 공간의 사이즈 0,1,2
			System.out.println(numberList.get(i)); // get함수로 가져온다 
		}
		
		System.out.println();
		
		String[] ar = new String[3];
		ar[0] = "안녕하세요. ";
		ar[1] = "감사합니다. ";
		ar[2] = "학원입니다. ";
		for (int i = 0; i<ar.length; i++) {
			System.out.println(ar[i]);		
		}

	}

}
