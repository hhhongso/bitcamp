package kr.co.bit2;
/*
 * 최종처리 - 기본 집계 
카운팅, 합, 평균, 최대, 최소 등의 하나의 값을 산출한다. 
 */

import java.util.Arrays;

public class Example14 {
	public static void main(String[] args) {
		long count = Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).filter(n -> n % 2 == 0).count();
		System.out.println("2의 배수 갯수: " + count);
		
		long sum = Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).filter(n -> n % 2 == 0).sum();
		System.out.println("2의 배수 합계: " + sum);
		
		int max = Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).filter(n -> n % 2 == 0).max().getAsInt();
		System.out.println("2의 배수 최대값: " + max);
		
		int min = Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).filter(n -> n % 2 == 0).min().getAsInt();
		System.out.println("2의 배수 최소값: " + min);
		
		int first = Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}).filter(n -> n % 3 == 0).findFirst().getAsInt();
		System.out.println("첫번째 3의 배수 찾기: " + first);
		
		
	}
}
