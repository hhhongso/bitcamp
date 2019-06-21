package kr.co.bit.obj2;

import java.util.Scanner;

// 이름 찾기 테스트: 특정 배열에서 Scanner로 읽어들인 이름이 몇 번 인덱스에 저장되어 있는지 찾기 
public class Array_Test4 {
public static void main(String[] args) {
	String[] names = new String[] {"가나다", "라마바", "사아자", "차카타", "타파하"};
	Scanner input = new Scanner(System.in);
	int index = -1; //? 찾았는지 여부를 확인하기 위해 의도적으로 설정. -1이면 못찾은 것, 이외 0 1 2~~ ok
	
	do {
		System.out.println("검색할 이름을 입력하세요.");
		System.out.println("이름: ");		
		String name = input.next();
		
		for(int i = 0; i < names.length; i++) {
			if(name.equals(names[i])) { // if(names[i].equals(name)) 이라고 해도 동일 결과값.
				index = i;
			}
		}
			if (index != -1) {
				System.out.println(name +"은 배열의" + index + "번 방에서 찾았습니다. ");
			break;
			}
			System.out.println("해당 이름이 존재하지 않습니다. ");
		
		
	} while(true);
	
}
}
