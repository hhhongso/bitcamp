package kr.co.bit2;
//반복하는 객체 다루기: forEach, peek
//peek는 중간처리단계에서, 반복하고자 하는 것을 뽑아내기 위한 것 ==> forEach처럼 뽑아내어 출력까지는 불가. 
//forEach는 최종처리단계에 있어, forEach 뒤에 다른 함수/연산자 등을 사용할 수 없다. 
//peek는 가능. ==> 뽑아낸 값을 마지막에 연산자로 더해주어 [뽑아낸 값 + 연산 후 최종 값]을 출력할 수 있다. 

import java.util.Arrays;

public class Example12 {
	public static void main(String[] args) {
		int[] intArr = {1, 2, 3, 4, 5};
		
		System.out.println("forEach 출력");
		Arrays.stream(intArr).filter(a -> a % 2 == 0)
		.forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		int total = Arrays.stream(intArr).filter(a -> a % 2 == 0)
				.peek(n -> System.out.print(n + ",")).sum();
		System.out.println("총합: " + total);
	}
}
 

