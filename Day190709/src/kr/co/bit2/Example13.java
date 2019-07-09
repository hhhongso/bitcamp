package kr.co.bit2;

/*
 * 매칭
요소들이 특정 조건에 만족하는 지 조사할 수 있도록 하는 매칭 메소드
all: 모든 요소들이 매개값으로 주어진 predicate의 조건에 만족하는 지 조사 
any: 최소 1개 
noneMatch(): 0개
 */

import java.util.Arrays;

public class Example13 {
	public static void main(String[] args) {
		int[] intArr = {2, 4, 6, 8, 10};
		
		boolean result = Arrays.stream(intArr).allMatch(a -> a % 2 == 0);
		System.out.println("모두 2의 배수 ?: " + result);
		
		result = Arrays.stream(intArr).anyMatch(a -> a % 3 == 0);
		System.out.println("하나라도 3의 배수?: " + result);
		
		result = Arrays.stream(intArr).noneMatch(a -> a % 3 == 0);
		System.out.println("3의 배수가 없는가?: " + result);
		
	}
}


