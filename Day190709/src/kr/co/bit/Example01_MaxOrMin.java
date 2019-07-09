package kr.co.bit;

import java.util.function.IntBinaryOperator;

//최대값, 최소값 구하기.
//[기존]: abcde 중 a=max라고 설정, a><b비교, b가 더 크면 b=max로 변수 조정. X반복  >>순차지향<<
//[람다]: ***재사용성*** 상기 프로세스 중 반복되는 비교 구조를 람다식으로 넘겨버림. >>객체지향<<
public class Example01_MaxOrMin {
	private static int[] scores = {92, 95, 87, 80, 78, 88};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int i : scores) {					//score[i]가 아니라 그냥 i야? 
			result = operator.applyAsInt(result, i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int max = maxOrMin((a,b) -> (a>= b) ? a: b);
		System.out.println("최대값: " + max);
		
		int min =  maxOrMin((a,b) -> (a<= b) ? a: b);
		System.out.println("최소값: " + min);
	}
}
